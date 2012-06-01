package catt.kedavra.entities.spells;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoMoveLinear;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Spark;

/**
 * This Entity is a missile spell which sets things on fire.
 * @author Zhengman777
 * @author Catt
 */

public class Incendio extends Spell implements SpellDamage {
	
	/**
	 * Creates a new Incendio.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 * @param rotation This Entity's orientation (in degrees).
	 */
	public Incendio(GameplayState gameState, int id, int x, int y, float rotation) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE, rotation);
		power = 2;
		addComponent(new CoAnimate(0, game.data.getImage("aniIncendio"), 30, 8, 50));
		game.data.playSound("incendio");
		this.rotation = rotation;
		//Add movement.
		addComponent(new CoMoveLinear(1, .5f, rotation, 400));
		//Set the bounding circle's size.
		collisionRadii[0] = 15;
	}

	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		if (!Player.class.isInstance(other)){
			addPosition(offset);
			Spark spark = new Spark(game, game.nextID_ent(), (int)(getX()), (int)(getY()));
			spark.spawn();
			this.kill();
		}
	}

	@Override
	public void damage(Entity recipient) {
		//IMPLEMENTATION NEEDED
	}
}
