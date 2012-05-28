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

import catt.kedavra.entities.Chicken;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Explosion_Small;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Rock;
import catt.kedavra.entities.Spark;
import catt.kedavra.entities.Crate_Wide;
import catt.kedavra.entities.Wand;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	private int stateID = -1;
	private Collidinator collidinator = new Collidinator();
	private int id_ent = 0; //Used to iterate the unique id for entities.
	private Player player;
	private Wand playerWand;
	private Spark spark;
	private Crate_Wide crate;
	private ArrayList<Rock> rocks = new ArrayList<Rock>();
	private Chicken chicken;
	private Explosion_Small explosion;
	//private Rock [] rocks = new Rock [5];
	private LinkedList<Entity> llRendered = new LinkedList<Entity>();
	private LinkedList<Entity> llUpdated = new LinkedList<Entity>(); 
	private LinkedList<Entity> queueRender = new LinkedList<Entity>();
	private LinkedList<Entity> queueUpdate = new LinkedList<Entity>(); 
	private LinkedList<Entity> queueRemoveRender = new LinkedList<Entity>();
	private LinkedList<Entity> queueRemoveUpdate = new LinkedList<Entity>();
	
	//-----SLICK METHODS BELOW---------//
	public GameplayState(int stateID){
		this.stateID = stateID;
	}
	
	@Override
	public int getID(){
		return stateID;
	}
	
	public int getID_ent(){
		return id_ent;
	}
	
	public void addRendered(Entity e) {
		queueRender.add(e);
	}
	
	public void addUpdated(Entity e) {
		queueUpdate.add(e);
	}
	
	public void addCollider(Entity e) {
		collidinator.add(e);
	}
	
	public void removeRendered(Entity e) {
		queueRemoveRender.add(e);
	}
	
	public void removeUpdated(Entity e) {
		queueRemoveUpdate.add(e);
	}
	
	public void removeCollider(Entity e){
		collidinator.remove(e);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Load the background image
		imgBackground = new Image("img/grass.png");
		//c//Populate the stage.
		player = new Player(700,500,id_ent++);
		llUpdated.add(player);
		collidinator.add(player);
		playerWand = new Wand(600,500,id_ent++,new Image("img/wand_brown.png"),player);
		llRendered.add(playerWand);
		llRendered.add(player); //Render the player over the wand
		llUpdated.add(playerWand);
		crate = new Crate_Wide(500,500,id_ent++);
		llRendered.add(crate);
		llUpdated.add(crate);
		collidinator.add(crate);
		rocks.add(new Rock(100,100,id_ent++));
		rocks.add(new Rock(250,110,id_ent++));
		rocks.add(new Rock(90,400,id_ent++));
		rocks.add(new Rock(400,330,id_ent++));
		rocks.add(new Rock(650,330,id_ent++));
		llRendered.addAll(rocks);
		llUpdated.addAll(rocks);
		for(Rock rock : rocks)
			collidinator.add(rock);
		chicken = new Chicken(550,400,id_ent++,0);
		llUpdated.add(chicken);
		collidinator.add(chicken);
		llRendered.add(chicken);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//c//Add the new renderable Entities to the list before rendering.
		llRendered.addAll(queueRender);
		queueRender.clear();
		llRendered.removeAll(queueRemoveRender);
		queueRemoveRender.clear();
		imgBackground.draw(0,0);
		for(Entity e: llRendered)
			e.render(gc, sbg, g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		//c//Add the new renderable Entities to the list before rendering.
		llUpdated.addAll(queueUpdate);
		queueUpdate.clear();
		llUpdated.removeAll(queueRemoveUpdate);
		queueRemoveUpdate.clear();
		for(Entity e: llUpdated)
			e.update(gc, sbg, delta);
		collidinator.update(gc, sbg, delta);
	}

	//-----CUSTOM METHODS BELOW-------//	

	
}