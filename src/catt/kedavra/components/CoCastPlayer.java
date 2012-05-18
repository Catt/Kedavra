package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.GameplayState;
import catt.kedavra.entities.Incendio;

public class CoCastPlayer extends Component implements Updatable{
	
	/**
	 * Initialize a new CoCastPlayer Component.
	 * @param id This Component's unique id.
	 */
	public CoCastPlayer(int id) {
		this.id = id;
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			Incendio incendio = new Incendio(10,30,0,owner.getRotation());
			((GameplayState)sbg.getCurrentState()).addRendered(incendio);
			((GameplayState)sbg.getCurrentState()).addUpdated(incendio);
		}
	}

}
