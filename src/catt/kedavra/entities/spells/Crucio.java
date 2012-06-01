package catt.kedavra.entities.spells;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This entity is a curse of torture, inflicting excruciating pain on a victim (though no physical harm)
 * @author AbsentMoniker
 *
 */
public class Crucio extends Spell implements SpellStatus {
	public Crucio(GameplayState gameState, int id, int x, int y, int rotation) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		this.rotation=rotation;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public void imposeStatus(Entity recipient) {
		// TODO Auto-generated method stub
		
	}

}
