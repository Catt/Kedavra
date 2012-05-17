package catt.kedavra;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.Updatable;
import catt.kedavra.entities.Collidable;

/**
 * The Great and Powerful Collidinator, as told in legend, enacts judgment on all the Entities in the game world, deciding
 * whether or not they collide at any given moment.  The methods through which this occurs are poorly understood, but physicists
 * and philosophers alike are scrambling to better understand its mysterious ways.
 * @author Catt
 *
 */
public class Collidinator implements Updatable {
	
	private ArrayList<Collidable> collisionRoll = new ArrayList<Collidable>();
	
	/**
	 * Adds the specified Collidable Entity to the collision roll.
	 * @param collidee The specified Collidable Entity.
	 */
	public void add(Collidable collidee){
		collisionRoll.add(collidee);
	}
	
	/**
	 * Removes the specified Collidable Entity from the collision roll.
	 * @param collidee The specified Collidable Entity.
	 */
	public void remove(Collidable collidee){
		collisionRoll.remove(collidee);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		//c//Check each Entity for collisions in the slowest, most straight-forward way. (Optimizations to come.)
		//System.out.println("STEP");
		for(int i = 0; i < collisionRoll.size(); ++i){
			Collidable a = collisionRoll.get(i);
			if (a.getCollisionType() != Collidable.CT_NONE)
				for(int j = i+1; j < collisionRoll.size(); ++j){
					Collidable b = collisionRoll.get(j);
					if (b.getCollisionType() != Collidable.CT_NONE){
						Collidinator.collide(a, b);
						//System.out.print(a.toString());System.out.print(" , ");System.out.println(b.toString());
					}
				}	
		}	
	}
	
	/**
	 * Enacts judgment on two Collidable objects, a and b.  If the objects collide, their collision methods will be called.
	 * @param a A Collidable object
	 * @param b Another Collidable object
	 */
	public static void collide(Collidable a, Collidable b){
		
		//c//If either Collidable has collisions disabled, do nothing.
		if (a.getCollisionType() == Collidable.CT_NONE || b.getCollisionType() == Collidable.CT_NONE)
			return;
		
		//c//If both Collidables have bounding circles, use circular radii to find overlap.
		if (a.getCollisionType() == Collidable.CT_CIRCLE && b.getCollisionType() == Collidable.CT_CIRCLE){
			int radA = a.getCollisionRadii()[0];
			int radB = b.getCollisionRadii()[0];
			float distance = Math.abs(a.getPosition().distance(b.getPosition()));
			float offset = distance - (radA + radB);
			if(offset < 0){
				//c//Find the offset vector.
				Vector2f vecA = new Vector2f();
				Vector2f vecB = new Vector2f();
				vecA.set(Math.abs(offset), 0);
				vecA.setTheta(Math.toDegrees(Math.atan2((a.getPosition().y-b.getPosition().y),(a.getPosition().x-b.getPosition().x))));
				vecB.set(Math.abs(offset), 0);
				vecB.setTheta(Math.toDegrees(Math.atan2((b.getPosition().y-a.getPosition().y),(b.getPosition().x-a.getPosition().x))));
				//c//Collide!
				a.collision(b,vecA);
				b.collision(a,vecB);
			}
			
		}
	}

}
