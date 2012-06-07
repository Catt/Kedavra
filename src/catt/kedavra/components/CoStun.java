package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoStun extends Component implements Updatable{
	private int time;
	private int counter = 0;
	
	public CoStun(String id, int time){
		this.id = id;
		this.time = time;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		((CoMove)owner.getComponent("Motion")).setStunned(true);
		if (counter >= time){
			((CoMove)owner.getComponent("Motion")).setStunned(false);
			owner.removeComponent(this);
			return;
		}
		counter += delta;
		
	}
	
	
}
