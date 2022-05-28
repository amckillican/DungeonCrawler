package dungeoncrawler;

import javax.swing.SwingUtilities;

import dungeoncrawler.framework.Engine;
import dungeoncrawler.framework.resources.Loader;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			//Load all textures and start the engine to start the game
			@Override
			public void run() {
				Loader.load();
				Engine.init();
				Engine.start();
			}
		});
	}
}