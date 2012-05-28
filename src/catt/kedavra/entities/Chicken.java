package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoMoveLinearPath;
import catt.kedavra.components.CoTimedRemoval;

/**
 * This entity represents a chicken best used for target practice.
 * @author AbsentMoniker
 *
 */
public class Chicken extends Entity {
	/**
	 * Creates a new Chicken.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Chicken(int x, int y, int id, float rotation){
		super(x,y,id, Collidable.CT_CIRCLE);
		try{
			addComponent(new CoAnimate(0, new Image("img/chicken.png"), 40,40, 200));
		} catch (SlickException e){
			System.out.println("Could not load img/chicken.png");
		}
		this.rotation = rotation;
		addComponent(new CoMoveLinearPath(1, .1f, rotation, 250));
		collisionRadii[0] = 10;
	}
	
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		GameplayState gps = (GameplayState)sbg.getCurrentState();
		// If the chicken is hit with the incendio spell, it explodes.
		if(Incendio.class.isInstance(other)){
			try{
				Sound death = new Sound("snd/ChickenDeath.wav");
				death.play();
			} catch (SlickException e){
				System.out.println("Could not load snd/ChickenDeath.wav");
			}
			Explosion_Small explosion = new Explosion_Small((int)this.getX(), (int)this.getY(),2);
			gps.addUpdated(explosion);
			gps.addRendered(explosion);
			addComponent(new CoTimedRemoval(2,0));
		}
	}

}
