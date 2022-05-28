package dungeoncrawler.framework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;

import javax.swing.JPanel;
import javax.swing.Timer;

import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;
import dungeoncrawler.game.states.Splash;

public class Engine {
	//Initialize variables
	private static GameStateManager gameStateManager;
	
	private static WindowManager windowManager;
	private static Timer timer;
	//Initialize for running game
	public static void init() {
		gameStateManager = new GameStateManager();
		windowManager = new WindowManager();
		timer = new Timer(20, new MainGameLoop());
	}
	//On start create game state, screen, input listener
	public static void start() {
		gameStateManager.stackState(new Splash(gameStateManager));
		windowManager.addPanel(new GameScreen());
		windowManager.addKeyListener(new Keyboard());
		windowManager.createWindow();
		timer.start();
	}
	
	private static class MainGameLoop implements ActionListener {
		//When an action is performed check what action was done
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gameStateManager.loop();
		}
		
	}
	
	private static class GameScreen extends JPanel {
		
		@Serial
		private static final long serialVersionUID = 1L;
		//Render and repaint screen
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			gameStateManager.render(g);
			repaint();
		}
	}
	//When a key is pressed and released check which key it was
	private static class Keyboard implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			gameStateManager.keyPressed(key.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent key) {
			gameStateManager.keyReleased(key.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
}
