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

import catt.kedavra.entities.Player;
import catt.kedavra.entities.Rock;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	private int stateID = -1;
	private Collidinator collidinator = new Collidinator();
	private int id_ent = 0; //Used to iterate the unique id for entities.
	private Player player;
	private Rock [] rocks = new Rock [5];
	
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
		imgBackground = new Image("img/grass.png");
		//c//Populate the stage.
		player = new Player(700,500,id_ent++);
		collidinator.add(player);
		rocks[0] = new Rock(100,100,id_ent++);
		rocks[1] = new Rock(250,110,id_ent++);
		rocks[2] = new Rock(90,400,id_ent++);
		rocks[3] = new Rock(300,330,id_ent++);
		rocks[4] = new Rock(600,25,id_ent++);
		for(Rock rock: rocks)
			collidinator.add(rock);
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		imgBackground.draw(0,0);
		for(Rock rock: rocks)
			rock.render(gc, sbg, g);
		player.render(gc, sbg, g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		for(Rock rock: rocks)
			rock.update(gc, sbg, delta);
		player.update(gc, sbg, delta);
		collidinator.update(gc, sbg, delta);
	}

	//-----CUSTOM METHODS BELOW-------//	

	
}