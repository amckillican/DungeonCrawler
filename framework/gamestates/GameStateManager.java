package dungeoncrawler.framework.gamestates;

import java.awt.Graphics;
import java.util.EmptyStackException;
import java.util.Stack;

public class GameStateManager {
	//Initialize game states
	private final Stack<GameState> states;
	//Keep track of game state
	public GameStateManager() {
		this.states = new Stack<>();
	}
	//Make it so that you can put one state over another to change screens
	public void stackState(GameState state) {
		this.states.add(state);
	}
	
	@SuppressWarnings("unused")
	public void backToPreviousState() {
		this.states.pop();
	}
	
	@SuppressWarnings("unused")
	public void clearStack() {
		this.states.clear();
	}
	//Set the game state, if there is none send error message
	public void loop() {
		try {
			this.states.peek().loop();
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	//Render the game state, if there is none send error message
	public void render(Graphics graphics) {
		try {
			this.states.peek().render(graphics);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	//If a key is pressed check if game state needs to be changed
	public void keyPressed(int keyCode) {
		try {
			this.states.peek().keyPressed(keyCode);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	//If a key is released check if game state needs to be changed
	public void keyReleased(int keyCode) {
		try {
			this.states.peek().keyReleased(keyCode);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
}
