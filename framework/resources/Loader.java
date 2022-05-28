package dungeoncrawler.framework.resources;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class Loader {
	//Attempt to load all the files in rooms folder
	public static void load() {
		try {
			File texturesFolder = new File("res/rooms");
			for(File imgFile : Objects.requireNonNull(texturesFolder.listFiles())) {
					Resources.ROOMS.put(imgFile.getName(), ImageIO.read(imgFile));
			}
			//Load all texture files from textures folder
			Resources.TEXTURES.add(Resources.FLOOR, ImageIO.read(new File("res/textures/floor.png")));
			Resources.TEXTURES.add(Resources.STONE, ImageIO.read(new File("res/textures/stone.png")));
			Resources.TEXTURES.add(Resources.WALL, ImageIO.read(new File("res/textures/wall.png")));
			Resources.TEXTURES.add(Resources.TILE, ImageIO.read(new File("res/textures/tile.png")));
			Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("res/textures/grass.png")));
			Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("res/textures/player.png")));
			Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(new File("res/textures/player_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(new File("res/textures/player_left.png")));
			Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(new File("res/textures/player_left_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(new File("res/textures/player_right.png")));
			Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(new File("res/textures/player_right_2.png")));
			Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(new File("res/textures/player_back.png")));
			Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(new File("res/textures/player_back_2.png")));
			Resources.TEXTURES.add(Resources.STAIRS, ImageIO.read(new File("res/textures/stairs.png")));
			Resources.TEXTURES.add(Resources.CHEST, ImageIO.read(new File("res/textures/chest.png")));
			Resources.TEXTURES.add(Resources.ENEMY, ImageIO.read(new File("res/textures/clinton.png")));
			Resources.TEXTURES.add(Resources.ENEMY_2, ImageIO.read(new File("res/textures/clinton.png")));
			Resources.TEXTURES.add(Resources.ATTACK, ImageIO.read(new File("res/textures/attack.png")));
			Resources.TEXTURES.add(Resources.HEART, ImageIO.read(new File("res/textures/heart.png")));
			Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(new File("res/textures/armor.png")));
			Resources.TEXTURES.add(Resources.GOLD, ImageIO.read(new File("res/textures/gold.png")));
			Resources.TEXTURES.add(Resources.SPLASH, ImageIO.read(new File("res/textures/splash.png")));
			Resources.TEXTURES.add(Resources.SHU, ImageIO.read(new File("res/textures/shu.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
