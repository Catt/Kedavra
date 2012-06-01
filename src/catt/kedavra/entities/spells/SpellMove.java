package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This interface should be implemented by any spell that causes things to move.
 * @author AbsentMoniker
 *
 */
public interface SpellMove {
	public void move(Entity recipient);
}
