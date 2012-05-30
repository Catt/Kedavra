package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This component moves the Entity aimlessly.
 * @author Catt
 *
 */
public class CoMove_Saunter extends Component implements Updatable {
	
	/** The owner's speed along the x-axis. */
	private float speedX;
	/** The owner's speed along the y-axis. */
	private float speedY;
	/** The amount of friction to simulate when moving. */
	//private float friction = .0005f;
	/** The owner's current orientation (in degrees). */
	private float rotation;
	/** The max speed at which the owner can move. */
	private float maxSpeed;
	/** The owner's max rate of acceleration. */
	//private float maxAccel;
	
	/**
	 * Initialize a new CoMovement_Saunter Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param baseSpeed The base speed before acceleration.
	 * @param maxWalk The max walking speed after acceleration.
	 * @param maxSprint The max sprinting speed after acceleration.
	 * @param walkAccel The rate of acceleration, when walking.
	 * @param sprintAccel The rate of acceleration, when sprinting.
	 */
	public CoMove_Saunter(int id, float maxSpeed, float maxAccel) {
		this.id = id;
		this.maxSpeed = maxSpeed;
		//this.maxAccel = maxAccel;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		//c//Pick a random direction!
		rotation = (float)(Math.random()*360.f);
		//c//Pick a random speed!
		float p = (float)Math.random();
		speedX = (p)*(maxSpeed)*(float)Math.cos(rotation);
		speedY = (p)*(maxSpeed)*(float)Math.sin(rotation);
		
		//c//Set position.
		owner.addX(speedX*delta);
		owner.addY(speedY*delta);
		//c//Set rotation.
		owner.setRotation(rotation);
	}

}

