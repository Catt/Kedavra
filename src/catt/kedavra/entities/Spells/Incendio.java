package catt.kedavra.entities.spells;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoMoveLinear;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.EntityDamageable;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Spark;

/**
 * This Entity is a missile spell which sets things on fire.
 * @author Zhengman777
 * @author Catt
 */

public class Incendio extends Spell implements SpellDamage, SpellFire {
	private static final int POWER = 2;
	/**
	 * Creates a new Incendio.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 * @param rotation This Entity's orientation (in degrees).
	 */
	public Incendio(GameplayState gameState, int id, int x, int y, float rotation) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		this.power = POWER;
		addComponent(new CoAnimate("Animate", game.data.getImage("aniIncendio"), 30, 8, 50));
		game.data.playSound("incendio");
		this.rotation = rotation;
		//Add movement.
		addComponent(new CoMoveLinear("Move_Linear", .5f, rotation, 400));
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
	public void damage(EntityDamageable recipient) {
		recipient.damage(power);
	}

	@Override
	public void burn(Entity recipient) {
		// Implementation needed
		
	}
}
