package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoRender;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This is a wide crate.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Crate_Wide extends Entity {
	
	/**
	 * Creates a new Wide Crate.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Crate_Wide(GameplayState gameState, int id, int x, int y) {
		super(gameState, id, x, y, Collidable.CT_RECTANGLE);
		//c//Add sprite.
		addComponent(new CoRender(0, game.data.getImage("crate_wide")));
		//Set the bounding rectangle's size.
		collisionRadii[0] = 50;
		collisionRadii[1] = 25;
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
