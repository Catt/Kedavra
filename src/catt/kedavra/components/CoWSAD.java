package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The CoMovePlayer Component can be added to an Entity to allow for 2-axis movement with the WSAD keys, as well as sprite orientation
 * @author Zhengman77
 * @author Catt
 *
 */
public class CoWSAD extends Component implements Updatable {
	
	/** The owner's speed along the x-axis. */
	private float speedX;
	/** The owner's speed along the y-axis. */
	private float speedY;
	/** The amount of friction to simulate when moving. */
	private float friction = .0005f;
	/** Whether or not the owner is sprinting. */
	private boolean sprint;
	/** The speed at which the owner moves immediately (before acceleration). */
	private float baseSpeed;
	/** The max speed at which the owner can move while walking (after acceleration). */
	private float maxWalk;
	/** The max speed at which the owner can move while sprinting (after acceleration). */
	private float maxSprint;
	/** The owner's rate of acceleration while walking. */
	private float walkAccel;
	/** The owner's rate of acceleration while sprinting. */
	private float sprintAccel;
	//Used to resolve conflicting keystrokes in movement.
	private int dominantX = 0;
	private int dominantY = 0;
	
	/**
	 * Initialize a new CoMovePlayer Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param baseSpeed The base speed before acceleration.
	 * @param maxWalk The max walking speed after acceleration.
	 * @param maxSprint The max sprinting speed after acceleration.
	 * @param walkAccel The rate of acceleration, when walking.
	 * @param sprintAccel The rate of acceleration, when sprinting.
	 */
	public CoWSAD(int id, float baseSpeed, float maxWalk, float maxSprint, float walkAccel, float sprintAccel) {
		this.id = id;
		this.baseSpeed = baseSpeed;
		this.maxWalk = maxWalk;
		this.maxSprint = maxSprint;
		this.walkAccel = walkAccel;
		this.sprintAccel = sprintAccel;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		//c//Toggle sprint.
		if(input.isKeyDown(Input.KEY_LSHIFT)) {
			sprint = true;
		}
		else {
			sprint = false;
		}
		//c//Find dominant directions.  Which ever key was more recently pressed becomes the dominant direction.
		//c//If only one key is down, it becomes the dominant direction.
		int pressedY = 0;
		int pressedX = 0;
		if(input.isKeyPressed(Input.KEY_W)){
			dominantY = 1; pressedY = 1;
		}
		if(input.isKeyPressed(Input.KEY_S)){
			dominantY = 2; pressedY = 2;
		}
		if(input.isKeyPressed(Input.KEY_A)){
			dominantX = 1; pressedX = 1;
		}
		if(input.isKeyPressed(Input.KEY_D)){
			dominantX = 2; pressedX = 2;
		}
		if(input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_S))
			dominantY = 1;
		if(!input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_S))
			dominantY = 2;
		if(input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_D))
			dominantX = 1;
		if(!input.isKeyDown(Input.KEY_A) && input.isKeyDown(Input.KEY_D))
			dominantX = 2;
		if(!input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_S))
			dominantY = 0;
		if(!input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_D))
			dominantX = 0;
		//Upwards movement
		if(input.isKeyDown(Input.KEY_W) && dominantY != 2) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(pressedY == 1) {
				speedY = -baseSpeed;
			}
			//Walking acceleration w/ speed cap
			if(sprint == false) {
				if(speedY <= -maxWalk) {
					speedY = -maxWalk;
				}
				if(speedY > -maxWalk) {
					speedY -= walkAccel*delta;
				}
			}
			//Sprinting acceleration w/ speed cap
			else{
				if(speedY <= -maxSprint) {
					speedY = -maxSprint;
				}
				if(speedY > -maxSprint) {
					speedY -= sprintAccel*delta;
				}
			}
		}
		//Downwards movement
		else if(input.isKeyDown(Input.KEY_S) && dominantY != 1) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(pressedY == 2) {
				speedY = baseSpeed;
			}
			//Walking acceleration w/ speed cap
			if(sprint == false) {
				if(speedY >= maxWalk) {
					speedY = maxWalk;
				}
				if(speedY < maxWalk) {
					speedY += walkAccel*delta;
				}
			}
			//Sprinting acceleration w/ speed cap
			if(sprint == true) {
				if(speedY >= maxSprint) {
					speedY = maxSprint;
				}
				if(speedY < maxSprint) {
					speedY += sprintAccel*delta;
				}
			}
		}
		//Vertical Friction
		else {
			//For downwards movement
			if(speedY < 0) {
				//Prevents overshoot
				if((speedY += friction*delta) > 0) {
					speedY = 0;
				}
				else {
					speedY += friction*delta;
				}
			}
			//For upwards movement
			if(speedY > 0) {
				//Prevents overshoot
				if((speedY -= friction*delta) < 0) {
					speedY = 0;
				}
				else {
					speedY -= friction*delta;
				}
			}
		}
		//Left movement
		if(input.isKeyDown(Input.KEY_A) && dominantX != 2) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(pressedX == 1) {
				speedX = -baseSpeed;
			}
			//Walking acceleration w/ speed cap
			if(sprint == false) {
				if(speedX <= -maxWalk) {
					speedX = -maxWalk;
				}
				if(speedX > -maxWalk) {
					speedX -= walkAccel*delta;
				}
			}
			//Sprinting acceleration w/ speed cap
			if(sprint == true) {
				if(speedX <= -maxSprint) {
					speedX = -maxSprint;
				}
				if(speedY > -maxSprint) {
					speedX -= sprintAccel*delta;
				}
			}
		}
		//Right movement
		else if(input.isKeyDown(Input.KEY_D) && dominantX != 1) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(pressedX == 2) {
				speedX = baseSpeed;
			}
			//Walking acceleration w/ speed cap
			if(sprint == false) {
				if(speedX >= maxWalk) {
					speedX = maxWalk;
				}
				if(speedX < maxWalk) {
					speedX += walkAccel*delta;
				}
			}
			//Sprinting acceleration w/ speed cap
			if(sprint == true) {
				if(speedX >= maxSprint) {
					speedX = maxSprint;
				}
				if(speedX < maxSprint) {
					speedX += sprintAccel*delta;
				}
			}
		}
		//Horizontal Friction
		else {
			//For right movement
			if(speedX > 0) {
				//Prevents overshoot
				if((speedX -= friction*delta) < 0) {
					speedX = 0;
				}
				else {
					speedX -= friction*delta;
				}
			}
			//For left movement
			if(speedX < 0) {
				//Prevents overshoot
				if((speedX += friction*delta) > 0) {
					speedX = 0;
				}
				else {
					speedX += friction*delta;
				}
			}
		}
		//Establish position
		owner.addX(speedX*delta);
		owner.addY(speedY*delta);
	}

}
