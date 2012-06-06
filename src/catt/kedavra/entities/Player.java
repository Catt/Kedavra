package catt.kedavra.entities;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoCastPlayer;
import catt.kedavra.components.CoMovePlayer;
import catt.kedavra.components.CoPing;
import catt.kedavra.components.CoRender;
import catt.kedavra.entities.spells.Incendio;

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
	public Player(GameplayState gameState, int id, int x, int y) {
		super(gameState, id, x, y, Collidable.CT_CIRCLE);
		//c//Add sprite.
		addComponent(new CoRender(ID_DISPLAY, game.data.getImage("player")));
		//c//Add WSAD movement with mouse orientation.
		addComponent(new CoMovePlayer(ID_MOVEMENT, .11f, .25f, .4f, .0004f, .0007f));
		addComponent(new CoCastPlayer(ID_MISC));
		addComponent(new CoPing(4,100,100,Input.KEY_HOME));
		//c//Set the bounding circle's size.
		collisionRadii[0] = 25;
		
		
	}
	
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		//c//Keep the player from getting stuck inside rocks.
		if(!Incendio.class.isInstance(other)){
			addPosition(offset);
			//c//Move the camera.
			game.addCamX(offset.x);
			game.addCamY(offset.y);
		}
	}	

}
