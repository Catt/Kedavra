package catt.kedavra.entities;

/**
 * This interface specifies the methods that any entity with health uses to manipulate its health. Works in
 * tandem with the CoHealth component. 
 * @author AbsentMoniker
 *
 */
public interface Damageable {
	public void damage(int amount);
	public void heal(int amount);
	public void makeInvincible();
	public void removeInvincible();
}
