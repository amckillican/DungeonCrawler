package dungeoncrawler.game.world.generator;

import java.util.HashSet;

import dungeoncrawler.framework.utils.MathHelper;
import dungeoncrawler.game.states.PlayingState;

public class LevelGenerator {

	public static final int WORLD_SIZE = 5;
	
	private int posX;
	private int posY;
	
	private HashSet<MathHelper.Direction>[][] roomsData;
	private boolean[][] generated;
	//Create a room by using one of the hash sets and take in all the bytes equaling different textures
	@SuppressWarnings("unchecked")
	public void reset() {
		this.roomsData = new HashSet[WORLD_SIZE][WORLD_SIZE];
		this.generated = new boolean[WORLD_SIZE][WORLD_SIZE];
		for(int i=0;i<this.roomsData.length;i++) {
			for(int j=0;j<this.roomsData[i].length;j++) {
				this.roomsData[i][j] = new HashSet<>();
				this.generated[i][j] = false;
			}
		}
		this.setRandomPosition();
		PlayingState.Level++;
	}
	//Using the bytes generate the objects in the correct order
	public void generate() {
		MathHelper.Direction direction = MathHelper.randomDirection();
		if(this.isValidPosition(posX + direction.dirX, posY + direction.dirY)) {
			if(!this.generated[posX + direction.dirX][posY + direction.dirY]) {
				this.roomsData[posX][posY].add(direction);
				this.roomsData[posX + direction.dirX][posY + direction.dirY].add(direction.opposite);
			}
			this.posX += direction.dirX;
			this.posY += direction.dirY;
			this.generated[posX][posY] = true;
		}
		else {
			this.generate();
		}
	}
	//Set a random position for blocks to go
	private void setRandomPosition() {
		this.posX = MathHelper.randomInt(WORLD_SIZE);
		this.posY = MathHelper.randomInt(WORLD_SIZE);
		this.generated[posX][posY] = true;
	}
	//Check if place texture wants to place it real and unused
	private boolean isValidPosition(int x, int y) {
		return x >= 0 && y >= 0 && x < WORLD_SIZE && y < WORLD_SIZE;
	}
	//Checks if all the blocks have been placed
	public boolean finished() {
		for (boolean[] booleans : this.generated) {
			for (boolean aBoolean : booleans) {
				if (!aBoolean) return false;
			}
		}
		return true;
	}
	//Returns room data
	public HashSet<MathHelper.Direction>[][] getRoomsData() {
		return roomsData;
	}
}
