package catt.kedavra.entities;

import org.newdawn.slick.geom.Vector2f;

/**
 * The Collidable interface is implemented by all Entities and allows them to be handled by the Great and Powerful Collidinator.
 * All Collidable Entities must adopt one of three collision types: NONE, which exempts the entity from collision checks; CIRCLE, 
 * which uses a bounding circle and works well with round objects; and RECTANGLE, which uses a bounding rectangle and works well
 * with end tables, sharp corners, companion cubes and the like.
 * @author Catt
 *
 */
public interface Collidable {
	
	/** Exempts the entity from collision checks. */
	public static final int CT_NONE = 0;
	/** Uses a bounding circle and works well with round objects. */
	public static final int CT_CIRCLE = 1;
	/** uses a bounding rectangle and works well with end tables, sharp corners, companion cubes and the like. */
	public static final int CT_RECTANGLE = 2;
	
	/**
	 * Fetches the collision type for this object.
	 * @return collisionType
	 */
	public int getCollisionType();
	
	/**
	 * Fetches the collision radii of this object.
	 * @return collisionRadii
	 */
	public int [] getCollisionRadii();
	
	/**
	 * Fetches a copy of this object's position vector.
	 * @return A copy of this object's position vector.
	 */
	public Vector2f getPosition();
	
	/**
	 * This method is called automatically by the Great and Powerful Collidinator, after its Most Righteous Judgment has been exacted.
	 * @param other The other Collidable object responsible this collision.
	 */
	public void collision(Collidable other, Vector2f offset);

}
