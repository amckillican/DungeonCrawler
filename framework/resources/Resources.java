package dungeoncrawler.framework.resources;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Resources {
	//Give each texture a byte value to place in certain spot on screen
	public static final byte FLOOR = 0;
	public static final byte STONE = 1;
	public static final byte WALL = 2;
	public static final byte TILE = 3;
	public static final byte GRASS = 4;
	public static final byte PLAYER = 5;
	public static final byte PLAYER_2 = 6;
	public static final byte PLAYER_LEFT = 7;
	public static final byte PLAYER_LEFT_2 = 8;
	public static final byte PLAYER_RIGHT = 9;
	public static final byte PLAYER_RIGHT_2 = 10;
	public static final byte PLAYER_BACK = 11;
	public static final byte PLAYER_BACK_2 = 12;
	public static final byte STAIRS = 13;
	public static final byte CHEST = 14;
	public static final byte ENEMY = 15;
	public static final byte ENEMY_2 = 16;
	public static final byte ATTACK = 17;
	public static final byte HEART = 18;
	public static final byte ARMOR = 19;
	public static final byte GOLD = 20;
	public static final byte SPLASH = 21;
	public static final byte SHU = 22;
	public static final byte SHU2 = 23;
	public static final byte AARON = 24;
	public static final byte AARON2 = 25;
	public static final byte TUSH = 26;
	public static final byte TUSH2 = 27;
	public static final byte GARNER = 28;
	public static final byte GARNER2 = 29;
	public static final byte TUT = 30;
	public static final byte DEAD = 31;
	public static final byte TITLE = 32;
	public static final byte UP = 33;


	//Create a hash map of the rooms and an arraylist of the textures
	public static final HashMap<String, BufferedImage> ROOMS = new HashMap<>();
	public static final ArrayList<BufferedImage> TEXTURES = new ArrayList<>();
}
