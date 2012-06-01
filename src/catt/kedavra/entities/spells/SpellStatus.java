package catt.kedavra.entities.spells;

import catt.kedavra.entities.Entity;

/**
 * This interface should be implemented by any spell that imposes some sort of status effect. Status effects will be
 * wrapped up in components.
 * @author AbsentMoniker
 *
 */
public interface SpellStatus {
	public void imposeStatus(Entity recipient);
}
