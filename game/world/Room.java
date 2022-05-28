package dungeoncrawler.game.world;

import java.awt.Graphics;
import java.util.ArrayList;

import dungeoncrawler.framework.resources.Resources;
import dungeoncrawler.game.entities.Enemy;
import dungeoncrawler.game.entities.Player;
import dungeoncrawler.game.world.generator.RoomData;

public class Room {

	private final RoomData data;
	private final ArrayList<Feature> features;
	private final ArrayList<Enemy> enemies;
	//Creates arrays with feature and enemy placement data
	public Room(RoomData data) {
		this.data = data;
		this.features = new ArrayList<>();
		this.enemies = new ArrayList<>();
	}
	//Returns the data of a room
	public RoomData getData() {
		return data;
	}
	//Places a feature on top of different textures
	public void placeFeature(Feature feature) {
		if(data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.FLOOR ||
			data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.GRASS ||
			data.getTileAt(feature.x / Tile.SIZE, feature.y / Tile.SIZE).getID() == Resources.TILE)
			this.features.add(feature);
		else
			this.placeFeature(new Feature(feature));
	}
	//When player walks over feature, feature activates
	public void featureInteraction(Player player) {
		for(int i=0;i<this.features.size();i++) {
			if(this.features.get(i).intersects(player))
				this.features.remove(i);
		}
	}
	//Returns the arraylist of enemies
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	//Spawns enemies over the map
	public void spawnEnemy(Enemy enemy) {
		if(data.getTileAt(enemy.x / Tile.SIZE, enemy.y / Tile.SIZE).getID() == Resources.FLOOR)
			this.enemies.add(enemy);
		else
			this.spawnEnemy(new Enemy(enemy));
	}
	//Renders the enemies and features
	public void render(Graphics graphics) {
		this.data.render(graphics);
		for(Feature feature : features) {
			feature.render(graphics);
		}
		for(Enemy enemy : enemies) {
			enemy.render(graphics);
		}
	}
}
