package catt.kedavra.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoTimedRemoval;

/**
 * A small explosion.
 * @author AbsentMoniker
 *
 */
public class Explosion_Small extends Entity {
	/**
	 * Creates a new Explosion with specified position
	 * @param x the x position
	 * @param y the y position
	 * @param id the unique id
	 */
	public Explosion_Small(int x, int y, int id){
		super(x,y,id, Collidable.CT_NONE);
		try{
			addComponent(new CoAnimate(0,new Image("img/smallExplosion.png"), 80, 80,50));
			addComponent(new CoTimedRemoval(1, 240));
		} catch (SlickException e){
			System.out.println("Could not load img/smallExplosion.png");
		}
	}
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
	}

}
