package dungeoncrawler.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;

public class MainMenu extends GameState {
	//Set up an array with strings to display options
	private final String[] optionsMenu;
	private static final String START_GAME = "Start Game!";
	private static final String QUIT_GAME = "Quit game";
	private static final String UPGRADES = "Upgrades";
	private static final String HELP = "How To Play";
	private int selected;
		
	public MainMenu(GameStateManager manager) {
		super(manager);
		this.optionsMenu = new String[] {START_GAME, UPGRADES, HELP, QUIT_GAME};
		this.selected = 0;
	}

	@Override
	protected void loop() {
	}
	//Set a background colour and print out the array with menu options
	@Override
	protected void render(Graphics graphics) {
		graphics.setColor(new Color(30, 30, 70));
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
		
		graphics.setFont(new Font("Araial", Font.PLAIN, 25));
		for(int i=0;i<this.optionsMenu.length;i++) {
			if(i==this.selected) graphics.setColor(Color.GREEN);
			else graphics.setColor(Color.WHITE);
			graphics.drawString(this.optionsMenu[i], 20, 50 + i * 40);
		}
	}
	//If up is pressed move up 1 on the menu same for down and if enter is pressed check which option was selected and change the game state to it
	@Override
	protected void keyPressed(int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_W:
			if(this.selected > 0) this.selected--;
			break;
		case KeyEvent.VK_S:
			if(this.selected < this.optionsMenu.length-1) this.selected++;
			break;
		case KeyEvent.VK_ENTER:
			switch (this.optionsMenu[selected]) {
				case START_GAME -> super.gameStateManager.stackState(new PlayingState(gameStateManager));
				case QUIT_GAME -> System.exit(0);
				case UPGRADES -> super.gameStateManager.stackState(new Upgrade(gameStateManager));
				case HELP -> super.gameStateManager.stackState(new Help(gameStateManager));
			}
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
	}

	@Override
	protected void keyReleased(int keyCode) {}
}
