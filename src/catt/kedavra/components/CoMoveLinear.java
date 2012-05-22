package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.GameplayState;

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
	/** The maximum distance that the Entity can travel. **/
	private int range;
	/** The owner's traveled distance. **/
	private float distance;
	
	/**
	 * Initialize a new CoMoveLinear Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param speed The speed at which the Entity moves.
	 * @param rotation The owner's orientation (in degrees).
	 * @param range The maximum distance that the Entity can travel
	 */
	public CoMoveLinear(int id, float speed, float rotation, int range) {
		this.id = id;
		this.speed = speed;
		this.rotation = rotation;
		this.range = range;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		//Checks to see if the entity has traveled the maximum distance.
		if(speed*delta+distance > range) {
			((GameplayState)sbg.getCurrentState()).removeRendered(owner);
			((GameplayState)sbg.getCurrentState()).removeUpdated(owner);
			((GameplayState)sbg.getCurrentState()).removeCollider(owner);
		}
		else {
			distance += speed*delta;
			owner.addX((float)Math.cos(Math.toRadians(rotation))*speed*delta);
			owner.addY((float)Math.sin(Math.toRadians(rotation))*speed*delta);
		}
	}

}
