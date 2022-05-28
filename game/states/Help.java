package dungeoncrawler.game.states;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Help extends GameState {
    protected Help(GameStateManager manager) {
        super(manager);
    }

    @Override
    protected void loop() {

    }
    //Render background and text explaining game
    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(Resources.TEXTURES.get(30), 0,0, null);
        graphics.setFont(new Font("Araial", Font.PLAIN, 17));
        graphics.setColor(Color.WHITE);
        graphics.drawString("Health^  Armour^  Gold^  Current Level^", 0, 50);
        graphics.drawString("In the dungeon you must search for the ladder to bring you down further into the game", 0, 300);
        graphics.drawString("Open chests for gold and armour", 450, 265);
        graphics.drawString("W" , 400, 50);
        graphics.drawString("A S D to move", 387, 65);
        graphics.drawString("Press enter to attack bad guys" , 350, 200);
        graphics.drawString("Press Esc at any time to enter main menu" , 490, 15);
        graphics.drawString("When health reaches 0 you die", 0, 75);
        graphics.drawString("Armour blocks incoming damage but breaks afterwords" , 0, 100);
        graphics.drawString("Gold is your score for that dungeon dive", 0, 125);
        graphics.drawString("Level shows what floor of the dungeon you are on", 0, 150);
        graphics.drawString("At the end of every dungeon dive you are given" , 0, 175);
        graphics.drawString("1 upgrade point", 0, 200);
        graphics.drawString("You can use them to upgrade max health and attack speed", 0, 225);
    }
    //When Esc is pressed go back to main menu
    @Override
    protected void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE)
            super.gameStateManager.stackState(new MainMenu(gameStateManager));
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
