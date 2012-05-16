package catt.kedavra.entities;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.Component;
import catt.kedavra.components.Renderable;
import catt.kedavra.components.Updatable;

/**
 * Entities are the backbone of this game.  Any witch, wizard, creature, wand, spell, top hat, or bad pun which intends to make a 
 * physical manifestation in (or impression upon) the game-world must extend this class.  At its heart, an Entity consists of a
 * unique (yet mostly worthless) id, a position vector, and a list of components.  Components are added via addComponent(), can be
 * either renderers or updaters, and provide Entities with most all of their functionality.
 * @author Catt
 *
 */
public abstract class Entity implements Collidable{
	
	/** The unique id for this entity. */
	private int id;
	/** This entity's position, given in the Vector2f format (specific to the Slick2D library). */
	private Vector2f position = new Vector2f(0,0);
	
	/** A list of all components added to this Entity. It's rarely used, as components are usually accessed as updaters or renderers. */
	private ArrayList<Component> components = new ArrayList<Component>();
	/** A list of all added components which have implemented the Updatable interface. */
	private ArrayList<Updatable> updaters = new ArrayList<Updatable>();
	/** A list of all added components which have implemented the Renderable interface. */
	private ArrayList<Renderable> renderers = new ArrayList<Renderable>();
	/** The type of collision used by the Great and Powerful Collidinator in its Most Righteous Judgement. See Collidable for types. */
	private int collisionType = 0;
	private int collisionRadii [] = null;
	private float rotation;
	
	/**
	 * Creates a new Entity with the specified id and collisionType.
	 * @param id This Entity's unique id.
	 * @param collisionType This entity's collision type.  (See Collidable for collision type constants.)
	 */
	public Entity(int id, int collisionType)
	{
		this.id = id;
		this.collisionType = collisionType;
		if (collisionType == Collidable.CT_CIRCLE)
			collisionRadii = new int[1];
		else if (collisionType == Collidable.CT_RECTANGLE){
			collisionRadii = new int[2];
		}
	}
	
	/**
	 * Fetches the unique id of this Entity.
	 * @return This Entity's unique id.
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Fetches the collision type of this Entity.
	 * @return collisionType
	 */
	public int getCollisionType(){
		return collisionType;
	}
	
	/**
	 * Fetches the collision radii of this Entity.
	 * @return collisionRadii
	 */
	public int [] getCollisionRadii(){
		return collisionRadii;
	}
	
	/**
	 * Adds the specified component to this entity.  If the component has implemented the Renderable or Updatable interface,
	 * it will be added to the respective lists for calling in the game's render and update methods. 
	 * @param component The component to be added.
	 */
	public void addComponent(Component component){		
		component.setOwner(this);
		components.add(component);
		if(Renderable.class.isInstance(component)){
			renderers.add((Renderable)component);
		}
		if(Updatable.class.isInstance(component)){
			updaters.add((Updatable)component);
		}
	}
	
	/**
	 * Fetches the component with the given id.
	 * @param id The id of the component to be retrieved.
	 * @return The component.
	 */
	public Component getComponent(int id)
	{
		return components.get(id);
	}
	
	/**
	 * Fetches a copy of this Entity's position vector.  (Modifying the returned position vector will not change this Entity's position
	 * unless used in conjunction with the setPosition() method)
	 * @return A copy of this Entity's position vector.
	 */
	public Vector2f getPosition(){
		return position.copy();
	}
	
	/**
	 * Sets this Entity's position vector, based on a specified vector.
	 * @param position The specified vector.
	 */
	public void setPosition(Vector2f position){
		this.position.set(position);
	}
	
	/**
	 * Adds the specified vector to the Entity's position vector.  For example, calling addPosition() with a vector <3,3> will change
	 * an Entity's position vector from <1,2> to <4,5>.
	 * @param addend The vector to be added.
	 */
	public void addPosition(Vector2f addend){
		this.position.add(addend);
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotate) {
		rotation = rotate;
	}
	
	/**
	 * Fetches the x coordinate of this Entity's position.
	 * @return The x coordinate.
	 */
	public float getX(){
		return position.getX();
	}
	
	/**
	 * Sets the x coordinate of this Entity's position.
	 * @param x
	 */
	public void setX(float x){
		this.position.set(x,position.getY());
	}
	
	/**
	 * Adds the specified amount to the x coordinate of this Entity's position.
	 * @param addend The amount to be added.
	 */
	public void addX(float addend){
		this.position.set(position.getX() + addend,position.getY());
	}
	
	/**
	 * Fetches the y coordinate of this Entity's position.
	 * @return The y coordinate.
	 */
	public float getY(){
		return position.getY();
	}
	
	/**
	 * Sets the y coordinate of this Entity's position.
	 * @param y
	 */
	public void setY(float y){
		this.position.set(position.getX(),y);
	}
	
	/**
	 * Adds the specified amount to the y coordinate of this Entity's position.
	 * @param addend The amount to be added.
	 */
	public void addY(float addend){
		this.position.set(position.getX(),position.getY() + addend);
	}
	
	/**
	 * The update method.  Use this to perform most game calculations before rendering each frame.  This method should be called
	 * in the game's update method, using its parameters.
	 * @param gc The GameContainer in which drawing is to be done.  
	 * @param sbg The StateBasedGame in which drawing is to be done.
	 * @param delta The time between calls of update (in milliseconds).  This can be used to adjust game mechanics based on FPS.
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta){
		for(Updatable updater : updaters)
			updater.update(gc, sbg, delta);
	}
	
	/**
	 * The render method.  Use this to draw stuff. This method should be called
	 * in the game's render method, using its parameters.
	 * @param gc The GameContainer in which drawing is to be done.
	 * @param sbg The StateBasedGame in which drawing is to be done.
	 * @param g The Graphics used to draw. This parameter can be casted to Graphics2D for additional features.
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		for(Renderable renderer : renderers)
			renderer.render(gc, sbg, g);
	}

}
