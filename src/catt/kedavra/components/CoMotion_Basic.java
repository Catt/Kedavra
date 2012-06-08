package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoMotion_Basic extends Component implements Motion, Updatable {
	private float acceleration = 0.f;
	private int cmdMotion = STOP;
	private int cmdTurn = STOP;
	private int cmdStrafe = STOP;
	private float friction = 0.f;
	private double rotation = 0.d;
	private float speed_current = 0.f;
	private float speed_max = 0.f;
	private float speed_strafe = 0.f;
	private float speed_turn = 0.f;
	private float turn = 0.f;

	public CoMotion_Basic(String id){
		this.id = id;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		switch(cmdMotion){
		case STOP:
			if(cmdStrafe == STOP)
				speed_current *= friction;
			break;	
		case FORWARD:
			if(speed_current < speed_max)
				speed_current += acceleration;
			else
				speed_current = speed_max;
			break;
			
		case BACKWARD:
			if(speed_current > -speed_max)
				speed_current -= acceleration;
			else
				speed_current = -speed_max;
			break;
		}
		
		switch(cmdStrafe){
			case STRAFE_LEFT:
				rotation = owner.getPosition().getTheta()+90;
				owner.addInDirection(speed_max*speed_strafe, rotation);
				break;
				
			case STRAFE_RIGHT:
				rotation = owner.getPosition().getTheta()-90;
				owner.addInDirection(speed_max*speed_strafe, rotation);
				break;
		}
		
		switch (cmdTurn) {
		case TURN:
			System.out.println(turn);
			if (turn > 0 && turn > speed_turn) {
				turn -= speed_turn;
				owner.addRotation(speed_turn);
			} else if (turn < 0 && Math.abs(turn) > speed_turn) {
				turn += speed_turn;
				owner.addRotation(-speed_turn);
			} else {
				owner.addRotation(turn);
				turn = 0;
				cmdTurn = STOP;
			}
			break;
		}
		
		owner.addInDirection(speed_current);

	}

	@Override
	public void forward() {
		cmdMotion = FORWARD;
	}

	@Override
	public void backward() {
		cmdMotion = BACKWARD;
	}

	@Override
	public void turn(float degrees) {
		cmdTurn = TURN;
		turn = degrees-owner.getRotation();
	}

	@Override
	public void strafe_left() {
		cmdStrafe = STRAFE_LEFT;
	}

	@Override
	public void strafe_right() {
		cmdStrafe = STRAFE_RIGHT;
	}
	
	@Override
	public void stop_motion() {
		cmdMotion = STOP;
	}
	
	@Override
	public void stop_turn() {
		cmdTurn = STOP;
	}
	
	@Override
	public void stop_strafe() {
		cmdStrafe = STOP;
	}

	@Override
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	@Override
	public void setSpeed(float speed) {
		this.speed_max = speed;
		this.speed_strafe = speed*0.6f;
	}

	@Override
	public void setTurnSpeed(float turnSpeed) {
		this.speed_turn = turnSpeed;
	}
	
	@Override
	public void setFriction(float friction) {
		this.friction = friction;
	}
	

}
