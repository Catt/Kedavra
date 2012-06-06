package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoTimedRemoval;
import catt.kedavra.components.Renderable;
import catt.kedavra.components.Updatable;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This is a spark.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Spark extends Entity implements Renderable, Updatable{
	
	/**
	 * Creates a new Rock.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Spark(GameplayState gameState, int id, int x, int y) {
		super(gameState, id, x, y, Collidable.CT_NONE);
		//c//Add sprite.
		addComponent(new CoAnimate(ID_DISPLAY, game.data.getImage("aniSpark"), 50, 50, 50));
		addComponent(new CoTimedRemoval(ID_MISC,190));
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
