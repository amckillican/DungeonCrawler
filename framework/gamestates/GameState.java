package dungeoncrawler.framework.gamestates;

import java.awt.Graphics;

public abstract class GameState {
	//Create a game state manager to manage which screen, game, upgrade or main menu
	protected GameStateManager gameStateManager;
	//Create a game state
	protected GameState(GameStateManager manager) {
		this.gameStateManager = manager;
	}
	protected abstract void loop();
	
	protected abstract void render(Graphics graphics);
	
	protected abstract void keyPressed(int keyCode);
	
	protected abstract void keyReleased(int keyCode);
}

