package dungeoncrawler.game.states;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;
import dungeoncrawler.game.entities.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Upgrade extends GameState {
    private final String[] upgradeMenu;
    private static final String BACK = "Back";
    private static final String HEALTH = "Health";
    private static final String DAMAGE = "Damage";
    private int selected;

    protected Upgrade(GameStateManager manager) {
        super(manager);
        this.upgradeMenu = new String[] {BACK, HEALTH, DAMAGE};
        this.selected = 0;
    }

    @Override
    protected void loop() {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.setColor(new Color(30, 30, 70));
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

        graphics.setFont(new Font("Araial", Font.PLAIN, 25));
        for(int i=0;i<this.upgradeMenu.length;i++) {
            if (i == this.selected) graphics.setColor(Color.GREEN);
            else graphics.setColor(Color.WHITE);
            graphics.drawString(this.upgradeMenu[i], 20, 50 + i * 40);
        }
    }


    @Override
    protected void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_UP:
                if (this.selected > 0) this.selected--;
                break;
            case KeyEvent.VK_DOWN:
                if (this.selected < this.upgradeMenu.length - 1) this.selected++;
                break;
            case KeyEvent.VK_ENTER:
                switch (this.upgradeMenu[selected]){
                    case HEALTH -> Player.addHealth();
                    case DAMAGE -> Player.addDamage();
                    case BACK -> super.gameStateManager.stackState(new MainMenu(gameStateManager));
                }
                break;
        }
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
