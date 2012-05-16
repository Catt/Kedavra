package catt.kedavra.characters;

import java.util.ArrayList;
import catt.kedavra.components.Component;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;


public class Player extends Entity {
	
	private int id;
	private int collisionType;
	private float baseSpeed = .2f;
	//Speed caps
	private float maxWalk = .3f;
	private float maxSprint = .7f;
	//Acceleration values
	private float walkAccel;
	private float sprintAccel;
	ArrayList<Component> components;
	
	public Player(int id, int collisionType, float baseSpeed, float maxWalk, float maxSprint, float walkAccel, float sprintAccel) {
		super(id, collisionType);
		this.id = id;
		this.collisionType = collisionType;
		this.baseSpeed = baseSpeed;
		this.maxWalk = maxWalk;
		this.maxSprint = maxSprint;
		this.walkAccel = walkAccel;
		this.sprintAccel = sprintAccel;
	}
	
	public float getBaseSpeed() {
		return baseSpeed;
	}
	
	public float getMaxWalk() {
		return maxWalk;
	}
	
	public float getWalkAccel() {
		return walkAccel;
	}
	
	public float getMaxSprint() {
		return maxSprint;
	}
	
	public float getSprintAccel() {
		return sprintAccel;
	}
	
	public void collision(Collidable other) {
		
	}

}
