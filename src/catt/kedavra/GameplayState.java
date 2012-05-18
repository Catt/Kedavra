/**
 *
 * @author Catt
 * @author Zhengman777
 *
 **/
package catt.kedavra;

import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Rock;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	private int stateID = -1;
	private Collidinator collidinator = new Collidinator();
	private int id_ent = 0; //Used to iterate the unique id for entities.
	private Player player;
	private ArrayList<Rock> rocks = new ArrayList<Rock>();
	//private Rock [] rocks = new Rock [5];
	private LinkedList<Entity> llRendered = new LinkedList<Entity>();
	private LinkedList<Entity> llUpdated = new LinkedList<Entity>(); 
	
	//-----SLICK METHODS BELOW---------//
	public GameplayState(int stateID){
		this.stateID = stateID;
	}
	
	@Override
	public int getID(){
		return stateID;
	}
	
	public void addRendered(Entity e) {
		llRendered.add(e);
	}
	
	public void addUpdated(Entity e) {
		llUpdated.add(e);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Load the background image
		imgBackground = new Image("img/grass.png");
		//c//Populate the stage.
		player = new Player(700,500,id_ent++);
		llRendered.add(player);
		llUpdated.add(player);
		collidinator.add(player);
		rocks.add(new Rock(100,100,id_ent++));
		rocks.add(new Rock(250,110,id_ent++));
		rocks.add(new Rock(90,400,id_ent++));
		rocks.add(new Rock(300,330,id_ent++));
		rocks.add(new Rock(600,25,id_ent++));
		llRendered.addAll(rocks);
		llUpdated.addAll(rocks);
		collidinator.collisionRoll.addAll(rocks);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		imgBackground.draw(0,0);
		for(Entity e: llRendered)
			e.render(gc, sbg, g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		for(Entity e: llUpdated)
			e.update(gc, sbg, delta);
		collidinator.update(gc, sbg, delta);
	}

	//-----CUSTOM METHODS BELOW-------//	

	
}