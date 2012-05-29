package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.GameplayState;
import catt.kedavra.entities.Wand;
import catt.kedavra.entities.Spells.Incendio;

/**
 * The CoCastPlayer component can be added to an Entity to allow it to create spells through manual input.
 * @author Zhengman777
 * @author Catt
 */

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
			//Creates the spell at the edge of the collision radius.
			Incendio incendio = new Incendio((int)(owner.getX()+Math.cos(Math.toRadians(owner.getRotation()))*(owner.getCollisionRadii()[0]+Wand.LENGTH)),(int)(owner.getY()+Math.sin(Math.toRadians(owner.getRotation()))*(owner.getCollisionRadii()[0]+Wand.LENGTH)),0,owner.getRotation());
			((GameplayState)sbg.getCurrentState()).addRendered(incendio);
			((GameplayState)sbg.getCurrentState()).addUpdated(incendio);
			((GameplayState)sbg.getCurrentState()).addCollider(incendio);
			
		}
	}

}
