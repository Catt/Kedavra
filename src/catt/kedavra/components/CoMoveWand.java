package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Wand;

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
	public CoMoveWand(String id, Entity caster) {
		this.id = id;
		this.caster = caster;
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if(!getStunned()){
			owner.setRotation(caster.getRotation());
			owner.setX((float)(caster.getX()+caster.getSpeedX()*delta+(caster.getCollisionRadii()[0]+Wand.LENGTH/2-4)*Math.cos(Math.toRadians(owner.getRotation()))));
			owner.setY((float)(caster.getY()+caster.getSpeedY()*delta+(caster.getCollisionRadii()[0]+Wand.LENGTH/2-4)*Math.sin(Math.toRadians(owner.getRotation()))));
		}
	}

}
