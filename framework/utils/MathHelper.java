package dungeoncrawler.framework.utils;

import java.util.Random;

public class MathHelper {
	//Initialize random for use throughout game
	private static final Random rand = new Random();
	//Returns a random integer with an upper limit
	public static int randomInt(int upperBound) {
		return rand.nextInt(upperBound);
	}
	//Returns a random integer with an upper and lower limit
	public static int randomInt(int lowerBound, int upperBound) {
		return rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
	}
	//Returns directional values
	public static Direction randomDirection() {
		return Direction.values()[rand.nextInt(Direction.values().length)];
	}
	//Initializes directions
	public enum Direction {
		NORTH(0, -1),
		SOUTH(0, 1),
		WEST(-1, 0),
		EAST(1, 0);
		
		public final int dirX;
		public final int dirY;
		public Direction opposite;
		//Creates opposite directions
		static {
			NORTH.opposite = SOUTH;
			SOUTH.opposite = NORTH;
			WEST.opposite = EAST;
			EAST.opposite = WEST;
		}
		//Sets direction
		Direction(int dirX, int dirY) {
			this.dirX = dirX;
			this.dirY = dirY;
		}
	}
}
