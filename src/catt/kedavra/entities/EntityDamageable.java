package catt.kedavra.entities;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoHealth;

/**
 * This class provides a base for a Damageable Entity with basic health function already built in.
 * @author AbsentMoniker
 *
 */
public abstract class EntityDamageable extends Entity implements Damageable{
	CoHealth health;
	
	public EntityDamageable(GameplayState gameplayState, int id, int x, int y, int collisionType, int maxHealth){
		super(gameplayState, id, x, y, collisionType);
		health = new CoHealth(0, maxHealth);
	}
	
	public void damage(int amount){
		health.removeHealth(amount);
	}
	public void heal(int amount){
		health.addHealth(amount);
	}
	public void makeInvincible(){
		health.setInvincible(true);
	}
	public void removeInvincible(){
		health.setInvincible(false);
	}
	
}
