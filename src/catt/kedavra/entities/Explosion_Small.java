package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoTimedRemoval;

/**
 * A small explosion.
 * @author AbsentMoniker
 *
 */
public class Explosion_Small extends Entity {
	/**
	 * Creates a new Explosion with specified position
	 * @param x the x position
	 * @param y the y position
	 * @param id the unique id
	 */
	public Explosion_Small(GameplayState gameState, int id, int x, int y){
		super(gameState, id, x, y, Collidable.CT_NONE);
		addComponent(new CoAnimate(ID_DISPLAY, game.data.getImage("explosion_small"), 80, 80,50));
		addComponent(new CoTimedRemoval(ID_MISC, 240));
		game.data.playSound("explosion_small",(getX()-game.getCamX()-400)/20,(getY()-game.getCamY()-300)/20);
	}
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
	}

}
