package catt.kedavra.characters;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.Component;
import catt.kedavra.components.Renderable;
import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;


public class Player extends Entity {
	
	int id;
	int collisionType;
	ArrayList<Component> components;
	Vector2f position = new Vector2f(0,0);
	
	public Player(int id, int collisionType) {
		super(id, collisionType);
		this.id = id;
		this.collisionType = collisionType;
	}
	
	public void collision(Collidable other) {
		
	}

}
