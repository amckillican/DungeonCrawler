package dungeoncrawler.game.states;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Dead extends GameState {
    protected Dead(GameStateManager manager) {
        super(manager);
    }

    @Override
    protected void loop() {

    }
    //Render in the death screen and text
    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(Resources.TEXTURES.get(31), 0, 0, null);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Araial", Font.BOLD, 25));
        graphics.drawString("Press Enter To Continue", 260, 400);
    }
    //When Esc or enter is pressed go to main menu
    @Override
    protected void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE)
            super.gameStateManager.stackState(new MainMenu(gameStateManager));
        if (keyCode == KeyEvent.VK_ENTER){
            super.gameStateManager.stackState(new MainMenu(gameStateManager));
        }
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
