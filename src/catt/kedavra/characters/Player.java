package catt.kedavra.characters;

import java.util.ArrayList;
import org.newdawn.slick.geom.Vector2f;
import catt.kedavra.components.Component;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;


public class Player extends Entity {
	
	int id;
	int collisionType;
	ArrayList<Component> components;
	public Vector2f position;
	
	public Player(int id, int collisionType) {
		super(id, collisionType);
		this.id = id;
		this.collisionType = collisionType;
	}
	
	public void collision(Collidable other) {
		
	}

}
