package catt.kedavra.entities.Spells;

import catt.kedavra.entities.Entity;

/**
 * This is the base for all spells that will be created in the game. Different spell categories will extend this class, and
 * every single spell in the game will extend one of those classes. All of this will allow for standardized 
 * response to spells should it be desired; e.g. if an entity were to react in the same manner towards every single spell, it 
 * would only need to check that it collided with a Spell rather than checking for every single type of spell.
 * @author AbsentMoniker
 *
 */
public abstract class Spell extends Entity{
	//Every spell will have a "Power level"; what this specifically defines depends on the spell category
	protected int power;
	
	public Spell(int x, int y, int id, int collisionType){
		super(x,y,id,collisionType);
	}
	
	public int getPower(){
		return power;
	}
	
}
