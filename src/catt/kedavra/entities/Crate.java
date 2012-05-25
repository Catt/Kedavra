package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

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
	public Crate(int x, int y, int id) {
		super(x, y, id, Collidable.CT_RECTANGLE);
		//c//Add sprite.
		try {
			addComponent(new CoRender(0, new Image("img/crate.png")));
		} catch (SlickException e) {
			System.out.println("Could not load img/crate.png");
		}
		//Set the bounding rectangle's size.
		collisionRadii[0] = 25;
		collisionRadii[1] = 25;
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
