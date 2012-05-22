package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoTimedRemoval;
import catt.kedavra.components.Renderable;
import catt.kedavra.components.Updatable;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This is a rock.
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
	public Spark(int x, int y, int id) {
		super(x, y, id, Collidable.CT_NONE);
		//c//Add sprite.
		try {
			addComponent(new CoAnimate(0, new Image("img/aniSpark.png"), 50, 50, 50));
			addComponent(new CoTimedRemoval(1,190));
		} catch (SlickException e) {
			System.out.println("Could not load img/rock.png");
		}
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		
	}

}
