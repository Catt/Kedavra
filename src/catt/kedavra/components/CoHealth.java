package catt.kedavra.components;

/**
 * This component keeps track of the current health of any entity that has health and can be damaged. Any entity
 * that contains this component must implement the Damageable interface.
 * @author AbsentMoniker
 *
 */
public class CoHealth extends Component {
	private int health;
	private int maxHealth;
	private boolean invincible;
	
	/**
	 * 
	 * @param id this component's unique id
	 * @param startHealth The maximum health of the entity. The current health will begin at maximum.
	 */
	public CoHealth(String id, int maxHealth){
		this.id = id;
		this.health = maxHealth;
		this.maxHealth = maxHealth;
	}
	
	/**
	 * Determines whether or not the entity is currently invincible
	 */
	public boolean isInvincible(){
		return invincible;
	}
	
	public void setInvincible(boolean condition){
		invincible = condition;
	}
	/**
	 * Adds health. Health cannot be higher than the specified maximum.
	 * @param addition The amount of health to add.
	 */
	public void addHealth(int addition){
		health += addition;
		if (health > maxHealth)
			health = maxHealth;
	}
	
	/**
	 * Removes health. If health is reduced to zero or lower, the entity "dies."
	 * @param subtraction The amount of health to remove.
	 */
	public void removeHealth(int subtraction){
		if (!invincible)
			health -= subtraction;
		if (health <= 0)
			owner.kill();
	}
}
