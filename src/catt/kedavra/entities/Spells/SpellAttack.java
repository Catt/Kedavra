package catt.kedavra.entities.Spells;

/**
 * This class defines an interface that will be implemented for all spells that are used to attack.
 * @author AbsentMoniker
 *
 */
public interface SpellAttack{
	//Depending on the type of spell specified, response to collision can be customized.
	public static final int STUN = 0;
	public static final int DAMAGE = 1;
	public static final int KILL = 2;
	
	public int getAttackType();
}
