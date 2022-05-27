package dungeoncrawler.framework.gui;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowManager {
	//Set frame to show video and panel for boarder size
	private final JFrame frame;
	private JPanel panel;
	//Set boarder size to 800 by 450
	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	//Add none resizable frame
	public WindowManager() {
		this.frame = new JFrame("Dungeon Crawler");
		this.frame.setBounds(70, 70, 0, 0);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
	}
	//Add screen
	public void addPanel(JPanel panel) {
		this.panel = panel;
		this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.panel.setFocusable(true);
		this.panel.requestFocusInWindow();
	}
	//Creates KeyListener which takes input from keyboard
	public void addKeyListener(KeyListener listener) {
		try {
			this.panel.addKeyListener(listener);
		} catch(NullPointerException e) {
			System.err.println("[WindowManager]: Error! Tried to add KeyListener before JPanel");
			System.exit(-1);
		}
	}
	//Create the game window
	public void createWindow() {
		this.frame.setContentPane(panel);
		this.frame.pack();
		this.frame.setVisible(true);
	}
}
