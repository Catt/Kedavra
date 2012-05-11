package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The Renderable interface is implemented by Components which require access to the game's render method.  The render method of
 * any Component which implements this interface will be called automatically by its owner Entity at the proper time.
 * @author Catt
 *
 */
public interface Renderable {
	
	/**
	 * The render method.  Use this to draw stuff. An Entity usually calls this method and feeds it the appropriate 
	 * parameters automatically.
	 * @param gc The GameContainer in which drawing is to be done.
	 * @param sbg The StateBasedGame in which drawing is to be done.
	 * @param g The Graphics used to draw. This parameter can be casted to Graphics2D for additional features.
	 */
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g);

}
