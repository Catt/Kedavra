package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class CoRender extends Component implements Renderable {
	
	int id;
	Image image;
	
	public CoRender(int id, Image image) {
		this.id = id;
		this.image = image;
		this.image.setCenterOfRotation(image.getWidth()/2.0f, image.getHeight()/2.0f);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		image.setRotation(owner.getRotation());
		image.draw(owner.getPosition().x, owner.getPosition().y);
	}

}
