package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.CoCastPlayer;
import catt.kedavra.components.CoMovePlayer;
import catt.kedavra.components.CoRender;
import catt.kedavra.entities.Spells.Incendio;

/**
 * This Entity represents the user's player character.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Player extends Entity {
	
	/**
	 * Creates a new Player Entity with the specified id and collisionType.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
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
		addComponent(new CoMovePlayer(1, .11f, .25f, .4f, .0004f, .0007f));
		addComponent(new CoCastPlayer(2));
		//c//Set the bounding circle's size.
		collisionRadii[0] = 25;
		
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		//c//Keep the player from getting stuck inside rocks.
		if(!Incendio.class.isInstance(other))
			addPosition(offset);
	}	

}
