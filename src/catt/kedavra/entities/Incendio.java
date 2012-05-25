package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoMoveLinear;
import catt.kedavra.components.CoRender;

/**
 * This Entity is a missile spell which sets things on fire.
 * @author Zhengman777
 * @author Catt
 */

public class Incendio extends Entity {
	
	
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
			Sound sndIncendio = new Sound("snd/incendio.wav");
			sndIncendio.play();
		} catch (SlickException e) {
			System.out.println("Could not load img/incendio.png");
		}
		this.rotation = rotation;
		//Add movement.
		addComponent(new CoMoveLinear(1, .5f, rotation, 400));
		//Set the bounding circle's size.
		collisionRadii[0] = 15;
	}

	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		GameplayState gps = (GameplayState)sbg.getCurrentState();
		if (!Player.class.isInstance(other)){
			addPosition(offset);
			Spark spark = new Spark((int)(getX()), (int)(getY()), gps.getID_ent());
			gps.addRendered(spark);
			gps.addUpdated(spark);
			gps.removeRendered((Entity)this);
			gps.removeUpdated((Entity)this);
			gps.removeCollider((Entity)this);
		}
		
	}

}
