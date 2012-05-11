package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The Updatable interface is implemented by Components which require access to the game's update method.  The update method of
 * any Component which implements this interface will be called automatically by its owner Entity at the proper time.
 * @author Catt
 *
 */
public interface Updatable {
	
	/**
	 * The update method.  Use this to perform most game calculations before rendering each frame.  An Entity usually calls this
	 * method and feeds it the appropriate parameters automatically.
	 * @param gc The GameContainer in which drawing is to be done.  
	 * @param sbg The StateBasedGame in which drawing is to be done.
	 * @param delta The time between calls of update (in milliseconds).  This can be used to adjust game mechanics based on FPS.
	 */
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);

}
