package catt.kedavra.entities.spells;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoMoveLinear;
import catt.kedavra.components.CoStun;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Spark;

public class PetrificusTotalus extends Spell implements SpellStun {
	
	public PetrificusTotalus(GameplayState gameState, int id, int x, int y, float rotation) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		addComponent(new CoAnimate(0, game.data.getImage("aniIncendio"), 30, 8, 50));
		game.data.playSound("incendio");
		this.rotation = rotation;
		//Add movement.
		movement = new CoMoveLinear(1, .5f, rotation, 400);
		addComponent(movement);
		//Set the bounding circle's size.
		collisionRadii[0] = 15;
	}
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		if (!Player.class.isInstance(other)){
			addPosition(offset);
			Spark spark = new Spark(game, game.nextID_ent(), (int)(getX()), (int)(getY()));
			spark.spawn();
			this.kill();
		}
	}

	@Override
	public void stun(Entity recipient) {
		if (recipient.getMove() != null){
			if (!recipient.getMove().getStunned())
				recipient.addComponent(new CoStun(5, 5000));
		}
		
	}

}
