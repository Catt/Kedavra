package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoRender;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This is a rock.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Rock extends Entity {
	
	/**
	 * Creates a new Rock.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Rock(GameplayState gameState, int id, int x, int y) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		//c//Add sprite.
		addComponent(new CoRender(0, game.data.getImage("rock")));
		//Set the bounding circle's size.
		collisionRadii[0] = 32;
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
