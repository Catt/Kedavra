package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.entities.Entity;

public class CoStun extends Component implements Updatable{
	private int time;
	private int counter = 0;
	
	public CoStun(int id, int time){
		this.id = id;
		this.time = time;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		((CoMove)owner.getComponent(Entity.ID_MOVEMENT)).setStunned(true);
		if (counter >= time){
			((CoMove)owner.getComponent(Entity.ID_MOVEMENT)).setStunned(false);
			owner.setRemove(this);
			return;
		}
		counter += delta;
		
	}
	
	
}
