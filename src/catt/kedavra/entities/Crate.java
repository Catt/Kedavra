package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoRender;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This is a Crate.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Crate extends Entity {
	
	/**
	 * Creates a new Crate.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Crate(GameplayState gameState, int id, int x, int y) {
		super(gameState, id, x, y, Collidable.CT_RECTANGLE);
		//c//Add sprite.
		addComponent(new CoRender(ID_DISPLAY, game.data.getImage("crate")));
		//Set the bounding rectangle's size.
		collisionRadii[0] = 25;
		collisionRadii[1] = 25;
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
