/**
 *
 * @author Catt
 * @author Zhengman777
 *
 **/
package catt.kedavra;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	private int stateID = -1;
	
	//-----SLICK METHODS BELOW---------//
	public GameplayState(int stateID){
		this.stateID = stateID;
	}
	
	@Override
	public int getID(){
		return stateID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Load the background image
		imgBackground = new Image("img/sky.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException{
		imgBackground.draw(0,0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}

	//-----CUSTOM METHODS BELOW-------//	

	
}