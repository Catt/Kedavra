package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The CoRender component provides basic rendering of an Entity by drawing the specified image at the Entity's position.
 * @author Zhengman777
 * @author Catt
 *
 */
public class CoRender extends Component implements Renderable {
	
	/** The image to be drawn. */
	private Image image;
	
	/**
	 * Initializes this CoRender Component with the specified id and image.
	 * @param id The unique id.
	 * @param image The image to be drawn.
	 */
	public CoRender(int id, Image image) {
		this.id = id;
		this.image = image;
		this.image.setCenterOfRotation(image.getWidth()/2.0f, image.getHeight()/2.0f);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		image.setRotation(owner.getRotation());
		image.draw(owner.getPosition().x - image.getWidth()/2, owner.getPosition().y - image.getHeight()/2);
	}

}
