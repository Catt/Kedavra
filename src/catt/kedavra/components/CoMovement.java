package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.characters.*;

public class CoMovement extends Component implements Updatable {
	
	private int id;
	private float speedX;
	public float speedY;
	private float friction = .0015f;
	private boolean sprint;
	private float direction;
	
	public CoMovement(int id) {
		this.id = id;
	}
	
	public float getSpeedX() {
		return speedX;
	}
	
	public float getSpeedY() {
		return speedY;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Vector2f position = owner.getPosition();
		Player player = (Player)owner;
		float maxWalk = player.getMaxWalk();
		float walkAccel = player.getWalkAccel();
		float maxSprint = player.getMaxSprint();
		float sprintAccel = player.getSprintAccel();
		float baseSpeed = player.getBaseSpeed();
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_LSHIFT)) {
			sprint = true;
		}
		else {
			sprint = false;
		}
		//Upwards movement
		if(input.isKeyDown(Input.KEY_W)) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(input.isKeyPressed(Input.KEY_W)) {
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
			if(sprint == true) {
				if(speedY <= -maxSprint) {
					speedY = -maxSprint;
				}
				if(speedY > -maxSprint) {
					speedY -= sprintAccel*delta;
				}
			}
		}
		//Downwards movement
		else if(input.isKeyDown(Input.KEY_S)) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(input.isKeyPressed(Input.KEY_S)) {
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
		if(input.isKeyDown(Input.KEY_A)) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(input.isKeyPressed(Input.KEY_A)) {
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
		else if(input.isKeyDown(Input.KEY_D)) {
			//If the player is starting from rest, he is given an immediate burst of speed
			if(input.isKeyPressed(Input.KEY_D)) {
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
		position.y += speedY*delta;
		position.x += speedX*delta;
		owner.setPosition(position);
		//Rotation
		direction = (float)Math.toDegrees(Math.atan2((input.getMouseY()-(owner.getY()+25)), (input.getMouseX()-(owner.getX()+25))))+90;
		owner.setRotation(direction);
	}

}
