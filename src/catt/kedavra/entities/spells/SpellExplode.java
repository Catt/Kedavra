package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This interface should be implemented by any spell that creates explosions.
 * @author AbsentMoniker
 *
 */
public interface SpellExplode {
	public void explode(Entity recipient);
}
