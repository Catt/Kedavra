package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoStun extends Component implements Updatable{
	private int time;
	private int counter = 0;
	
	public CoStun(int id, int time){
		this.id = id;
		this.time = time;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		owner.getMove().setStunned(true);
		if (counter >= time){
			owner.getMove().setStunned(false);
			owner.setRemove(this);
			return;
		}
		counter += delta;
		
	}
	
	
}
