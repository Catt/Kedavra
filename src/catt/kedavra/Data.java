package catt.kedavra;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.tiled.TiledMap;

/**
 * The Data class loads the game resources and provides an interface by which they may be accessed.
 * @author Catt
 *
 */
public class Data {
	
	private HashMap<String, Sound> sounds = new HashMap<String, Sound>();
	private HashMap<String, Image> images = new HashMap<String, Image>();
	private HashMap<String, TiledMap> maps = new HashMap<String, TiledMap>();
	
	/**
	 * Initialize provides an easy place to do all the loading at once.
	 */
	public void initialize(){
		//c//Add images.
		addImage("sky", "img/sky.png");
		addImage("chicken_top", "img/chicken_top.png");
		addImage("wand_brown", "img/wand_brown.png");
		addImage("crate", "img/crate.png");
		addImage("crate_wide", "img/crate_wide.png");
		addImage("explosion_small", "img/explosion_small.png");
		addImage("player", "img/player.png");
		addImage("rock", "img/rock.png");
		addImage("aniSpark", "img/aniSpark.png");
		addImage("aniIncendio","img/aniIncendio.png");
		
		//c//Add sounds.
		addSound("chickenDeath", "snd/ChickenDeath.wav");
		addSound("explosion_small", "snd/explosion_small.wav");
		addSound("incendio", "snd/incendio.wav");
		addSound("ping", "snd/ping.wav");
		
		//c//Add maps.
		addMap("grass", "maps/grass.tmx");
	}
	
	public void addSound(String name, String path){
		try{
			sounds.put(name, new Sound(path));
		} catch (SlickException e){
			System.out.println("ERROR! Could not load sound: "+name+" at "+path);
		}
	}
	
	public void addImage(String name, String path){
		try{
			images.put(name, new Image(path));
		} catch (SlickException e){
			System.out.println("ERROR! Could not load image: "+name+" at "+path);
		}
	}
	
	public void addMap(String name, String path){
		try{
			maps.put(name, new TiledMap(path));
		} catch (SlickException e){
			System.out.println("ERROR! Could not load map: "+name+" at "+path);
		}
	}
	
	public void playSound(String name){
		sounds.get(name).play();
	}
	
	public void playSound(String name, float x, float y){
		sounds.get(name).playAt(x, y, 0);
	}
	
	public void playSound(String name, float x, float y, float z){
		sounds.get(name).playAt(x, y, z);
	}
	
	public Sound getSound(String name){
		return sounds.get(name);
	}
	
	public Image getImage(String name){
		return images.get(name);
	}
	
	public TiledMap getMap(String name){
		return maps.get(name);
	}
}
