package catt.kedavra.characters;

import catt.kedavra.entities.Collidable;
import catt.kedavra.entities.Entity;

/**
 * This Entity represents the user's player character.
 * @author Catt
 * @author Zhengman777
 *
 */
public class Player extends Entity {
	
	/**
	 * Creates a new Player Entity with the specified id and collisionType.
	 * @param id This Entity's unique id.
	 * @param collisionType This entity's collision type.  (See Collidable for collision type constants.)
	 */
	public Player(int id, int collisionType) {
		super(id, collisionType);
	}
	
	public void collision(Collidable other) {
		//c//Do nothing for now.  Collision functionality to be implemented!
	}

}
