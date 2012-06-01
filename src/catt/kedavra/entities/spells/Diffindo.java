package catt.kedavra.entities.spells;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.EntityDamageable;
/**
 * This entity is a spell that rips, divides, and separates objects into parts.
 * @author AbsentMoniker
 *
 */
public class Diffindo extends Spell implements SpellDamage {
	public Diffindo(GameplayState gameState, int id, int x, int y, int rotation) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		this.rotation=rotation;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public void damage(EntityDamageable recipient) {
		// TODO Auto-generated method stub

	}

}
