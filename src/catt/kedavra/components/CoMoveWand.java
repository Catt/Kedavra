package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.entities.Entity;

/**
 * This component controls how Wand moves around the screen.
 * @author Zhengman777
 * @author Catt
 */
public class CoMoveWand extends CoMove implements Updatable {
	
	Entity caster;
	
	/**
	 * Creates a CoMoveWand component.
	 * @param id This component's unique id.
	 * @param caster The entity that owns the wand.
	 */
	public CoMoveWand(int id, Entity caster) {
		this.id = id;
		this.caster = caster;
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(!getStunned()){
			owner.setX((float)(caster.getX()+caster.getCollisionRadii()[0]*Math.cos(Math.toRadians(caster.getRotation()))));
			owner.setY((float)(caster.getY()+caster.getCollisionRadii()[0]*Math.sin(Math.toRadians(caster.getRotation()))));
			owner.setRotation(caster.getRotation());
		}
	}

}
