/**
 *
 * @author Catt
 * @author Zhengman777
 *
 **/
package catt.kedavra;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.font.effects.OutlineWobbleEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import catt.kedavra.entities.Chicken;
import catt.kedavra.entities.Crate;
import catt.kedavra.entities.Entity;
import catt.kedavra.entities.Player;
import catt.kedavra.entities.Rock;
import catt.kedavra.entities.Wand;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	public Data data;
	UnicodeFont text;
	private float camX = 0;
	private float camY = 0;
	private int stateID = -1;
	private Collidinator collidinator = new Collidinator();
	private Chickenator chickenator = new Chickenator();
	private int id_ent = 0; //Used to iterate the unique id for entities.
	private Player player;
	private Wand playerWand;
	private ArrayList<Entity> clutter = new ArrayList<Entity>();
	private Chicken chicken;
	private TiledMap grass;
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
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//c//Initialize a nice font to use.
		text = new UnicodeFont(new Font(null,0,15));
		text.addAsciiGlyphs();
		text.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		text.loadGlyphs();
		//c//Load resources.
		data = new Data();
		data.initialize();
		//Load the background image
		imgBackground = data.getImage("sky");
		grass = data.getMap("grass");
		//c//Populate the stage.
		player = new Player(this, nextID_ent(), 400,300);
		chicken = new Chicken(this, nextID_ent(), 550,400);
		playerWand = new Wand(this, nextID_ent(),600,500,data.getImage("wand_brown"),player);
		//c//Clutter the garden.
		float decay = 50;
		while(decay > 0){
			clutter.add(new Rock(this, id_ent++,(int)(Math.random()*4900),(int)(Math.random()*4900)));
			decay -= Math.random();
		}
		decay = 50;
		while(decay > 0){
			clutter.add(new Crate(this, id_ent++,(int)(Math.random()*4900),(int)(Math.random()*4900)));
			decay -= Math.random();
		}
		//c//Prevent escape.
		for(int i = 0; i < 5000; i+= 50){
			clutter.add(new Crate(this,id_ent++,0,i));
			clutter.add(new Crate(this,id_ent++,5000,i));
			clutter.add(new Crate(this,id_ent++,i,0));
			clutter.add(new Crate(this,id_ent++,i,5000));
		}
		//c//Spawn everything!
		for(Entity e : clutter)
			e.spawn();
		chicken.spawn();
		playerWand.spawn();
		player.spawn();
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//c//Add the new renderable Entities to the list before rendering.
		llRendered.addAll(queueRender);
		queueRender.clear();
		llRendered.removeAll(queueRemoveRender);
		queueRemoveRender.clear();
		//c//Draw the sky.
		imgBackground.draw(0,0);
		//c//Render the map.
		grass.render((int)-camX, (int)-camY);
		//c//Render the Entities.
		for(Entity e: llRendered)
			e.render(gc, sbg, g);
		//c//Display entity count.
		text.drawString(100.f, 10.f, "Entities: " + Integer.toString(id_ent), new Color(255,255,255));
		
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
		chickenator.update(gc, sbg, delta);
	}

	//-----CUSTOM METHODS BELOW-------//	

	public int getID_ent(){
		return id_ent;
	}
	
	public int nextID_ent(){
		return id_ent++;
	}
	
	public void setID_ent(int id){
		id_ent = id;
	}
	
	public float getCamX(){
		return camX;
	}
	
	public float getCamY(){
		return camY;
	}
	
	public void addCamX(float x){
		camX += x;
	}
	
	public void addCamY(float y){
		camY += y;
	}
	
	public void setCamX(float x){
		camX = x;
	}
	
	public void setCamY(float y){
		camY = y;
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
	
}