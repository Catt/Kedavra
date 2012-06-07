package catt.kedavra.entities;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.components.CoAnimate;
import catt.kedavra.components.CoCull;
import catt.kedavra.components.CoMove_Saunter;
import catt.kedavra.entities.spells.SpellDamage;
import catt.kedavra.entities.spells.SpellStun;

/**
 * This entity represents a chicken best used for target practice.
 * @author AbsentMoniker
 * @author Catt
 *
 */
public class Chicken extends EntityDamageable {
	private static final int HEALTH = 1;
	/**
	 * Creates a new Chicken.
	 * @param x This Entity's x position.
	 * @param y This Entity's y position.
	 * @param id This Entity's unique id.
	 */
	public Chicken(GameplayState gameState, int id, int x, int y){
		super(gameState, id, x, y, Collidable.CT_CIRCLE, HEALTH);
		addComponent(new CoAnimate("Animate", gameState.data.getImage("chicken_top"), 50, 40, 200));
		addComponent(new CoMove_Saunter("Move_Saunter", 0.2f, 0.05f));
		addComponent(new CoCull("Cull",Input.KEY_DELETE));
		collisionRadii[0] = 20;
	}
	
	@Override
	public void collision(StateBasedGame sbg, Collidable other, Vector2f offset) {
		// If the chicken is hit with a damage spell, it explodes.
		if(SpellDamage.class.isInstance(other)){
			((SpellDamage)other).damage(this);
		}
		// If the chicken is hit with a stun spell, it gets stunned (what a surprise)
		else if(SpellStun.class.isInstance(other)){
			((SpellStun)other).stun(this);
		}
		else{
			//c//Path finding AI goes here...
		}
	}
	
	@Override
	public void kill(){
		super.kill();
		game.data.playSound("chickenDeath",(getX()-game.getCamX()-400)/20,(getY()-game.getCamY()-300)/20);
		Explosion_Small explosion = new Explosion_Small(game, game.getID_ent(),(int)this.getX(), (int)this.getY());
		explosion.spawn();
	}

}
