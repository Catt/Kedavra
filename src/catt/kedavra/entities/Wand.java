package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.components.CoMoveWand;
import catt.kedavra.components.CoRender;

/**
 * This Entity represents the character's wand.
 * @author Zhengman777
 * @author Catt
 */
public class Wand extends Entity {
	
	/** The standard length of a wand. */
	public static final int LENGTH = 20;
	
	/**
	 * Creates a new Wand entity.
	 * @param x The entity's x position.
	 * @param y The entity's y position.
	 * @param id The entity's unique id.
	 * @param collisionType The entity's collision type.
	 * @param sprite An example of a wand attribute - in this case, the sprite.
	 */
	public Wand(int x, int y, int id, Image sprite, Entity caster) {
		super(x, y, id, Collidable.CT_NONE);
		addComponent(new CoRender(0, sprite));
		addComponent(new CoMoveWand(1, caster));
	}


	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {

		
	}

}
