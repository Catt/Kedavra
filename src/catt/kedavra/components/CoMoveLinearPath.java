package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This component causes an entity to move on a specified linear path indefinitely.
 * @author AbsentMoniker
 *
 */
public class CoMoveLinearPath extends CoMove implements Updatable{
	/** The owner's speed. **/
	private float speed;
	/** The owner's orientation (in degrees). **/
	private float rotation;
	/** The path length traveled. **/
	private int range;
	/** The owner's traveled distance. **/
	private float distance;
	/** Specifies the owner's current direction. **/
	private boolean isForward;
	
	/**
	 * Initialize a new CoMoveLinearPath Component, given movement specifications.
	 * @param id The unique id for this Component.
	 * @param speed The speed at which the Entity moves.
	 * @param rotation The owner's orientation (in degrees).
	 * @param range The length of the path that the Entity follows.
	 * @param start The location along the path where the Entity will begin its movement.
	 * @param direction The direction the Entity will begin moving.
	 */
	public CoMoveLinearPath(int id, float speed, float rotation, int range, float start, boolean direction) {
		this.id = id;
		this.speed = speed;
		this.rotation = rotation;
		this.range = range;
		if (direction == true){
			this.distance = start;
		}else{
			this.distance = range-start;
		}
		this.isForward = direction;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(!getStunned()){
			//Checks to see whether owner has reached end of path and needs to turn around.
			distance += speed*delta;
			if (distance > range){
				distance = 0;
				isForward = !isForward;
			}
			//Updates position based on current travel path.
			if (isForward){
				owner.addX((float)Math.cos(Math.toRadians(rotation))*speed*delta);
				owner.addY((float)Math.sin(Math.toRadians(rotation))*speed*delta);
			}
			else{
				owner.addX((float)Math.cos(Math.toRadians(rotation))*speed*delta*-1);
				owner.addY((float)Math.sin(Math.toRadians(rotation))*speed*delta*-1);
			}
		}
	}
	
	public boolean getDirection(){
		return isForward;
	}
	
	/**
	 * Gives distance from the beginning of the path.
	 * @return distance
	 */
	public float getDistance(){
		if (isForward == true)
			return distance;
		else
			return range-distance;
	}
	
	public int getRange(){
		return range;
	}
}
