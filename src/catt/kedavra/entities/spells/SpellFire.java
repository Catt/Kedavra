package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This defines an interface implemented by any spell that has fire-based properties.
 * @author AbsentMoniker
 *
 */
public interface SpellFire {
	public void burn(Entity recipient);
}
