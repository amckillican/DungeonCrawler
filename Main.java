package dungeoncrawler;

import javax.swing.SwingUtilities;

import dungeoncrawler.framework.Engine;
import dungeoncrawler.framework.resources.Loader;

public class Main {

	public static void main(String[] args) {
		//Load all textures and start the engine to start the game
		SwingUtilities.invokeLater(() -> {
			Loader.load();
			Engine.init();
			Engine.start();
		});
	}
}