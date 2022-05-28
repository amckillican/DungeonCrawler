package dungeoncrawler.game.states;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;
import dungeoncrawler.framework.resources.Resources;
import dungeoncrawler.game.entities.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
//Create array with options
public class Upgrade extends GameState {
    private final String[] upgradeMenu;
    private static final String BACK = "Back";
    private static final String HEALTH = "Health";
    private static final String ATTACK = "Attack Speed - Only Upgradable 4 Times";
    private int selected;
    //Add options to array
    protected Upgrade(GameStateManager manager) {
        super(manager);
        this.upgradeMenu = new String[] {BACK, HEALTH, ATTACK};
        this.selected = 0;
    }

    @Override
    protected void loop() {

    }
    //Render in the menu, background and the amount of upgrade points player has
    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(Resources.TEXTURES.get(33), 0, 0, null);

        graphics.setFont(new Font("Araial", Font.PLAIN, 25));
        for(int i=0;i<this.upgradeMenu.length;i++) {
            if (i == this.selected) graphics.setColor(Color.GREEN);
            else graphics.setColor(Color.WHITE);
            graphics.drawString(this.upgradeMenu[i], 20, 50 + i * 40);
        }
        graphics.setColor(Color.WHITE);
        graphics.drawString("Upgrade Points: " + Player.getEXP(), 400,20);
    }

    //Go up when up arrow is pressed, go down when down arrow is pressed, enter when enter is pressed
    @Override
    protected void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_ESCAPE:
                super.gameStateManager.stackState(new MainMenu(gameStateManager));
                break;
            case KeyEvent.VK_W:
                if (this.selected > 0) this.selected--;
                break;
            case KeyEvent.VK_S:
                if (this.selected < this.upgradeMenu.length - 1) this.selected++;
                break;
            case KeyEvent.VK_ENTER:
                switch (this.upgradeMenu[selected]){
                    case HEALTH -> {
                        //If player doesn't have enough exp don't upgrade
                        if(Player.getEXP() > 0) {
                            Player.addHealth();
                            Player.removeEXP();
                        }
                    }
                    //If player has upgraded speed too much stop them or attacks don't work
                    case ATTACK -> {
                        if(Player.getEXP() > 0 && Player.getSpeed() < 8) {
                            Player.addSpeed();
                            Player.removeEXP();
                        }
                    }
                    //When back is pressed go back to the main menu
                    case BACK -> super.gameStateManager.stackState(new MainMenu(gameStateManager));
                }
                break;
        }
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
