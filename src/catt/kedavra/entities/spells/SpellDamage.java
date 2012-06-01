package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This class defines an interface that will be implemented for all spells that do damage.
 * @author AbsentMoniker
 *
 */
public interface SpellDamage{
	//The method in which a spell damages an Entity.
	public void damage(Entity recipient);
}
