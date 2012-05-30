package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import catt.kedavra.GameplayState;
import catt.kedavra.entities.Chicken;

/**
 * The great Chickenator is the answer to the age-old question, "which came first, the chicken or the egg?" However, it
 * begs a greater question: "which came first, God or the Chickenator?"
 * @author Catt
 *
 */
public class Chickenator implements Updatable {
	
	private int x;
	private int y;
	private int frequency;
	private int ticker = 0;
	
	/**
	 * Let fate control the Chickenator.
	 * @param x
	 * @param y
	 * @param frequency
	 */
	public Chickenator(){
		this.x = -1;
		this.frequency = (int)(Math.random()*500);
	}
	
	/**
	 * Take control of the Chickenator.
	 * @param x
	 * @param y
	 * @param frequency
	 */
	public Chickenator(int x, int y, int frequency){
		this.frequency = frequency;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		//c//Calibrate.
		if(this.x == -1){
			this.x = (int)(Math.random()*gc.getWidth());
			this.y = (int)(Math.random()*gc.getHeight());
		}
		//c//Tick.
		ticker += delta;
		//c//Make chickens.
		if(ticker >= frequency){
			GameplayState gps = (GameplayState)sbg.getCurrentState();
			int id = gps.getID_ent();
			Chicken chick = new Chicken(x, y, id++);
			gps.addCollider(chick);
			gps.addRendered(chick);
			gps.addUpdated(chick);
			gps.setID_ent(id);
			
			ticker = 0;
		}

	}

}
