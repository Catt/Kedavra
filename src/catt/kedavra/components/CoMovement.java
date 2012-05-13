package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class CoMovement extends Component implements Updatable {
	
	private int id;
	private float speedX;
	private float speedY;
	private float maxWalk = .2f;
	private float maxRun = .5f;
	private float walkAccel;
	private float runAccel;
	private boolean running;
	
	public CoMovement(int id, float walkAccel, float runAccel) {
		this.id = id;
		this.walkAccel = walkAccel;
		this.runAccel = runAccel;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Vector2f position = owner.getPosition();
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_LSHIFT)) {
			running = true;
		}
		if(input.isKeyDown(Input.KEY_W)) {
			speedY -= walkAccel*delta;
		}
		else if(input.isKeyDown(Input.KEY_S)) {
			speedY += walkAccel*delta;
		}
		else {
			if(speedY < 0) {
				speedY = 0;
			}
			if(speedY > 0) {
				speedY = 0;
			}
		}
		if(input.isKeyDown(Input.KEY_A)) {
			speedX -= walkAccel*delta;
		}
		else if(input.isKeyDown(Input.KEY_D)) {
			speedX += walkAccel*delta;
		}
		else {
			if(speedX > 0) {
				speedX = 0;
			}
			if(speedX < 0) {
				speedX = 0;
			}
		}
		position.y += speedY*delta;
		position.x += speedX*delta;
		owner.setPosition(position);
	}

}
