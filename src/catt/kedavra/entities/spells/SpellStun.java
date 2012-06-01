package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This interface should be implemented by any spell that has the ability to stun things.
 * @author AbsentMoniker
 *
 */
public interface SpellStun {
	public void stun(Entity recipient);
}
