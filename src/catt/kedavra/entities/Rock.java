package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

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
	 * Creates a new Rock
	 * @param id This Entity's unique id.
	 * @param collisionType This entity's collision type.  (See Collidable for collision type constants.)
	 */
	public Rock(int x, int y, int id) {
		super(x, y, id, Collidable.CT_CIRCLE);
		//c//Add sprite.
		try {
			addComponent(new CoRender(1, new Image("img/rock.png")));
		} catch (SlickException e) {
			System.out.println("Could not load img/rock.png");
		}
		//Set the bounding circle's size.
		collisionRadii[0] = 32;
		
	}
	
	public void collision(Collidable other, Vector2f offset) {
		
	}

}
