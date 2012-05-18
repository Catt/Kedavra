package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The CoMoveLinear component can be added to an Entity to allow for linear movement in an immutable direction.
 * @author Zhengman777
 * @author Catt
 *
 */

public class CoMoveLinear extends Component implements Updatable {
	
	/** The owner's speed. **/
	private float speed;
	/** The owner's orientation (in degrees). **/
	private float rotation;
	
	/**
	 * Initialize a new CoMoveLinear Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param speed The speed at which the Entity moves.
	 */
	public CoMoveLinear(int id, float speed) {
		this.id = id;
		this.speed = speed;
		rotation = owner.getRotation();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		owner.addX((float)Math.cos(rotation)*speed*delta);
		owner.addY((float)Math.sin(rotation)*speed*delta);
	}

}
