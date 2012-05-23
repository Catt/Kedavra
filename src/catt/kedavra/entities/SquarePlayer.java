package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.CoCastPlayer;
import catt.kedavra.components.CoRender;
import catt.kedavra.components.CoWSAD;

/**
 * This Entity represents the user's player character.
 * @author Catt
 * @author Zhengman777
 *
 */
public class SquarePlayer extends Entity {
	
	/**
	 * Creates a new Player Entity with the specified id and collisionType.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public SquarePlayer(int x, int y, int id) {
		super(x, y, id, Collidable.CT_RECTANGLE);
		//c//Add sprite.
		try {
			addComponent(new CoRender(0, new Image("img/crate.png")));
		} catch (SlickException e) {
			System.out.println("Could not load img/crate.png");
		}
		//c//Add WSAD movement with mouse orientation.
		addComponent(new CoWSAD(1, .11f, .25f, .4f, .0004f, .0007f));
		addComponent(new CoCastPlayer(2));
		//c//Set the bounding circle's size.
		collisionRadii[0] = 25;
		collisionRadii[1] = 25;
		
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		//c//Keep the player from getting stuck inside rocks.
		if(WideCrate.class.isInstance(other))
			addPosition(offset);
	}	

}
