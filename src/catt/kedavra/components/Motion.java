package catt.kedavra.components;

/**
 * The Motion Interface is suitable for Components that are intended to work as a remote control for motion. 
 * It provides essential commands for motion.
 * @author Catt
 */
public interface Motion {
	public static final int STOP = 0;
	public static final int FORWARD = 1;
	public static final int BACKWARD = 2;
	public static final int TURN = 3;
	public static final int STRAFE_LEFT = 4;
	public static final int STRAFE_RIGHT = 5;
	
	public void forward();
	public void backward();
	public void turn(float degrees);
	public void strafe_left();
	public void strafe_right();
	public void setAcceleration(float acceleration);
	public void setSpeed(float speed);
	public void setTurnSpeed(float turnSpeed);
	public void setFriction(float friction);

}
