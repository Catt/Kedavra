package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 * CoCtrl_PlayerMotion works in conjunction with a Component implementing the Motion interface to allow for motion control
 * using the WSAD key-set and mouse-based orientation.
 * @author Catt
 *
 */
public class CoCtrl_PlayerMotion extends CoMove implements Updatable {
	
	/** The Motion Component that provides the functionality which actually moves the Entity. */
	private Motion motion;
	/** The amount of friction to simulate when moving. */
	private float friction;
	/** The max speed at which the owner can move while walking (after acceleration). */
	private float speed_walk;
	/** The max speed at which the owner can move while sprinting (after acceleration). */
	private float speed_sprint;
	/** The owner's rate of acceleration while walking. */
	private float accel_walk;
	/** The owner's rate of acceleration while sprinting. */
	private float accel_sprint;
	
	/**
	 * Initialize a new CoMovePlayer Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param baseSpeed The base speed before acceleration.
	 * @param maxWalk The max walking speed after acceleration.
	 * @param maxSprint The max sprinting speed after acceleration.
	 * @param walkAccel The rate of acceleration, when walking.
	 * @param sprintAccel The rate of acceleration, when sprinting.
	 */
	public CoCtrl_PlayerMotion(String id, Motion motion) {
		this.motion = motion;
		this.id = id;
		this.speed_walk = 3;
		this.speed_sprint = 5;
		this.accel_walk = .3f;
		this.accel_sprint = .5f;
		this.friction = 0.0001f;
		motion.setFriction(friction);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if (!getStunned()){
			Input input = gc.getInput();
			//c//Toggle sprint.
			if(input.isKeyPressed(Input.KEY_LSHIFT)) {
				motion.setSpeed(speed_sprint);
				motion.setAcceleration(accel_sprint);
			}
			else {
				motion.setSpeed(speed_walk);
				motion.setAcceleration(accel_walk);
			}
			
			//c//Motion commands.
			if(input.isKeyPressed(Input.KEY_W))
				motion.forward();
			if(input.isKeyPressed(Input.KEY_S))
				motion.backward();
			if(input.isKeyPressed(Input.KEY_A))
				motion.strafe_left();
			if(input.isKeyPressed(Input.KEY_D))
				motion.strafe_right();
			
			
		}
	}

}
