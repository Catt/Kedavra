package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoCam_PlayerCenter extends Component implements Updatable {

	public CoCam_PlayerCenter(String id){
		this.id = id;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		owner.getGame().setCamX(owner.getX() - gc.getWidth()/2);
		owner.getGame().setCamY(owner.getY() - gc.getHeight()/2);

	}

}
