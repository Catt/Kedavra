package catt.kedavra;

import catt.kedavra.entities.Collidable;

/**
 * The Great and Powerful Collidinator, as told in legend, enacts judgment on all the Entities in the game world, deciding
 * whether or not they collide at any given moment.  The methods through which this occurs are poorly understood, but physicists
 * and philosophers alike are scrambling to better understand its mysterious ways.
 * @author Catt
 *
 */
public class Collidinator {
	
	/**
	 * Enacts judgment on two Collidable objects, a and b.  If the objects collide, their collision methods will be called.
	 * @param a A Collidable object
	 * @param b Another Collidable object
	 */
	public static void collide(Collidable a, Collidable b){
		
		//If either Collidable has collisions disabled, do nothing.
		if (a.getCollisionType() == Collidable.CT_NONE || b.getCollisionType() == Collidable.CT_NONE)
			return;
		
		//If both Collidables have bounding circles, use circular radii to find overlap.
		if (a.getCollisionType() == Collidable.CT_CIRCLE || b.getCollisionType() == Collidable.CT_CIRCLE){
			int radA = a.getCollisionRadii()[0];
			int radB = b.getCollisionRadii()[0];
			float distance = Math.abs(a.getPosition().distance(b.getPosition()));
			if(distance < radA + radB){
				a.collision(b);
				b.collision(a);
			}
			
		}
	}

}
