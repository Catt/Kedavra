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
import org.newdawn.slick.Sound;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MainMenuState extends BasicGameState {
	
	Image imgBackground = null;
	//Variables for the menu options.
	float scaleStep = 0.0005f;
	Sound sndMenuSelect = null;
	Image imgBtnPlay = null;
	Image imgBtnQuit = null;
	float imgBtnPlay_scale = 1;
	float imgBtnQuit_scale = 1;
	float imgBtnPlay_x = 50;
	float imgBtnPlay_y = 100;
	float imgBtnQuit_x = 50;
	float imgBtnQuit_y = 150;
	boolean imgBtnPlay_in = false;
	boolean imgBtnQuit_in = false;
	
	int stateID = -1;
	MainMenuState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public int getID() {
		return stateID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		imgBackground = new Image("img/mnu_background.png");
		//Load the sound that will play on button select.
		sndMenuSelect = new Sound("snd/menuSelect.wav");
		
		//Load the menu images.
		Image menuOptions = new Image("img/mnu_options.png");
		imgBtnPlay = menuOptions.getSubImage(0, 0, 128, 32);
		imgBtnQuit = menuOptions.getSubImage(0, 32, 128, 32);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//Draw the background.
		imgBackground.draw(0,0);
		//Draw the menu.
		imgBtnPlay.draw(imgBtnPlay_x,imgBtnPlay_y,imgBtnPlay_scale);
		imgBtnQuit.draw(imgBtnQuit_x,imgBtnQuit_y,imgBtnQuit_scale);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		if( (mouseX >= imgBtnPlay_x && mouseX <= imgBtnPlay_x+imgBtnPlay.getWidth()) &&
			(mouseY >= imgBtnPlay_y && mouseY <= imgBtnPlay_y+imgBtnPlay.getHeight())){
			if(!imgBtnPlay_in)
				sndMenuSelect.play();
			imgBtnPlay_in = true;
		}
		else {imgBtnPlay_in = false;}
		if( (mouseX >= imgBtnQuit_x && mouseX <= imgBtnQuit_x+imgBtnQuit.getWidth()) &&
			(mouseY >= imgBtnQuit_y && mouseY <= imgBtnQuit_y+imgBtnQuit.getHeight())){
			if(!imgBtnQuit_in)
				sndMenuSelect.play();
			imgBtnQuit_in = true;
		}
		else {imgBtnQuit_in = false;}
		if(imgBtnPlay_in){
			imgBtnPlay_scale += (imgBtnPlay_scale < 1.05f) ? scaleStep * delta : 0;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				sndMenuSelect.play();
				sbg.enterState(Kedavra.GAMEPLAYSTATE);
			}
		}
		else {imgBtnPlay_scale -= (imgBtnPlay_scale > 1.0f) ? scaleStep * delta : 0;}
		if(imgBtnQuit_in){
			imgBtnQuit_scale += (imgBtnQuit_scale < 1.05f) ? scaleStep * delta : 0;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				gc.exit();
			}
		}
		else {imgBtnQuit_scale -= (imgBtnQuit_scale > 1.0f) ? scaleStep * delta : 0;}
		
	}
}
