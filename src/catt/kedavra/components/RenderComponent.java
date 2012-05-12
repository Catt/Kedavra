package catt.kedavra.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class RenderComponent extends Component implements Renderable {
	
	int id;
	Image image;
	Vector2f pos;
	
	public RenderComponent(int id, Image image) {
		this.id = id;
		this.image = image;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		pos = owner.getPosition();
		image.draw(pos.x, pos.y);
	}

}
