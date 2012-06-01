package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The CoPing Component will make a pinging sound at a specified location when a specified key is pressed.
 * @author Catt
 */

public class CoPing extends Component implements Updatable{
	
	private int x;
	private int y;
	private int key;
	
	/**
	 * 
	 * @param id This Component's unique id.
	 */
	public CoPing(int id, int x, int y, int key) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.key = key;
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if(input.isKeyPressed(key)) {
			owner.getGame().data.playSound("ping",(x-owner.getGame().getCamX()+gc.getWidth())/10,(y-owner.getGame().getCamY()+gc.getHeight())/10);
		}
		
	}

}
