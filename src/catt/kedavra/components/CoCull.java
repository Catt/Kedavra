package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The CoCull Component will cull any entity bound to it when a specified key is pressed.
 * @author Catt
 */

public class CoCull extends Component implements Updatable{
	
	private int key;
	
	/**
	 * 
	 * @param id This Component's unique id.
	 */
	public CoCull(int id, int key) {
		this.id = id;
		this.key = key;
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if(input.isKeyDown(key)) {
			owner.kill();
		}
	}

}
