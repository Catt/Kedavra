package catt.kedavra.components;

import catt.kedavra.entities.Entity;

/**
 * Components can be added to entity classes to extend their functionality.  This allows for any game dynamic (such as movement,
 * enemy AI, or spell effects) to be modularized and reused.  Components should implement one of or both the Renderable and Updatable
 * interface to be used in the game's render and update methods, respectively.
 * @author Catt
 * 
 **/
public abstract class Component {

	/** This Component's unique id. */
	protected int id;
	/** The Entity to which this Component belongs. */
	protected Entity owner;
	
	/**
	 * Fetches this components unique id.
	 * @return id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Sets the Entity to which this Component belongs.  This method is automatically used by any Entity class to which the
	 * Component has been added.
	 * @param owner
	 */
	public void setOwner(Entity owner){
		this.owner = owner;
	}
}
