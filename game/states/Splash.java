package dungeoncrawler.game.states;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Splash extends GameState {

    public Splash(GameStateManager manager) {
        super(manager);
    }

    @Override
    protected void loop() {

    }
    //Render splashscreen image and text
    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(Resources.TEXTURES.get(21), 0, 0, null);
        graphics.setFont(new Font("Araial", Font.BOLD, 40));
        graphics.drawString("The Dropped Dungeon", 200, 225);
        graphics.setFont(new Font("Araial", Font.PLAIN, 25));
        graphics.drawString("Press Enter To Begin", 300, 275);
        graphics.drawString("By: Adam Fischer, Alex McKillican and Ben Smith", 10, 425);
    }
    //When enter is pressed go to main menu
    @Override
    protected void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_ENTER) {
            super.gameStateManager.stackState(new MainMenu(gameStateManager));
        }
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
