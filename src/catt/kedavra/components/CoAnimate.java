package catt.kedavra.components;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


public class CoAnimate extends Component implements Renderable, Updatable{

	private ArrayList<Animation> animations = new ArrayList<Animation>();
	private Animation current;
	
	public CoAnimate(int id, Image spriteStrip, int tileSizeX, int tileSizeY, int duration){
		SpriteSheet ss = new SpriteSheet(spriteStrip,tileSizeX, tileSizeY);
		Animation animation = new Animation(ss,duration);
		this.id = id;
		animation.setAutoUpdate(false);
		animations.add(animation);
		current = animation;
	}

	public void setAnimation(int index) {
		current = animations.get(index);
	}
	public void addAnimation(Animation animation){
		animations.add(animation);
	}
	public void removeAnimation(int index){
		animations.remove(index);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		Vector2f pos = owner.getPosition();
		Image frame = current.getCurrentFrame();
		frame.setRotation(owner.getRotation());
		frame.draw(pos.x-frame.getWidth()/2,pos.y-frame.getHeight()/2);
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta){
		current.update(delta);
	}
	
}
