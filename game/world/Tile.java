package dungeoncrawler.game.world;

import java.awt.Rectangle;
import java.io.Serial;

public class Tile extends Rectangle {

	@Serial
	private static final long serialVersionUID = 1L;
	
	public static final int SIZE = 50;
	
	private final byte tileID;
	private final boolean wall;
	
	public Tile(byte id, int posXinRoom, int posYinRoom, boolean isWall) {
		super(posXinRoom * SIZE, posYinRoom * SIZE, SIZE, SIZE);
		this.tileID = id;
		this.wall = isWall;
	}
	
	public byte getID() {
		return tileID;
	}
	
	public boolean isWall() {
		return wall;
	}
}
