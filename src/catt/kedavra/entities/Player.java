package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import catt.kedavra.components.CoMovement;
import catt.kedavra.components.CoRender;

/**
 * This Entity represents the user's player character.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Player extends Entity {
	
	/**
	 * Creates a new Player Entity with the specified id and collisionType.
	 * @param id This Entity's unique id.
	 * @param collisionType This entity's collision type.  (See Collidable for collision type constants.)
	 */
	public Player(int x, int y, int id) {
		super(x, y, id, Collidable.CT_CIRCLE);
		//c//Add sprite.
		try {
			addComponent(new CoRender(0, new Image("img/player.png")));
		} catch (SlickException e) {
			System.out.println("Could not load img/player.png");
		}
		//c//Add WSAD movement with mouse orientation.
		addComponent(new CoMovement(1, .11f, .25f, .4f, .0004f, .0007f));
		//c//Set the bounding circle's size.
		collisionRadii[0] = 32;
		
		
	}
	
	public void collision(Collidable other, Vector2f offset) {
		//c//Keep the player from getting stuck inside things.
		addPosition(offset);
	}

}
