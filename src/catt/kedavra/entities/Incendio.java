package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import catt.kedavra.components.CoMoveLinear;
import catt.kedavra.components.CoRender;

public class Incendio extends Entity {
	
	float rotation;
	
	/**
	 * Creates a new Incendio.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 * @param rotation This Entity's orientation (in degrees).
	 */
	public Incendio(int x, int y, int id, float rotation) {
		super(x, y, id, Collidable.CT_CIRCLE);
		
		try {
			addComponent(new CoRender(0, new Image("img/incendio.png")));
		} catch (SlickException e) {
			System.out.println("Could not load img/incendio.png");
		}
		this.rotation = rotation;
		//Add movement.
		addComponent(new CoMoveLinear(1, .1f));
		//Set the bounding circle's size.
		collisionRadii[0] = 15;
	}

	public void collision(Collidable other, Vector2f offset) {
		
	}

}
