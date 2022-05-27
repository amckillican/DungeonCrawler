package dungeoncrawler;

import javax.swing.SwingUtilities;

import dungeoncrawler.framework.Engine;
import dungeoncrawler.framework.resources.Loader;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Loader.load();
			Engine.init();
			Engine.start();
		});
	}
}
//Harder enemies for lower levels
//You can use the money to upgrade health and damage
//