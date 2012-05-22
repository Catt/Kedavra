package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;

public class CoTimedRemoval extends Component implements Updatable {

	private int time = 0;
	private int counter= 0;
	
	public CoTimedRemoval(int id, int time){
		this.id = id;
		this.time = time;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		if (counter >= time){
			GameplayState gps = ((GameplayState)sbg.getCurrentState());
			gps.removeRendered(owner);
			gps.removeUpdated(owner);
			gps.removeCollider(owner);
			return;
		}
		counter += delta;
		
		
	}

}
