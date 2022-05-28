package dungeoncrawler.game.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serial;

import dungeoncrawler.framework.resources.Resources;
import dungeoncrawler.framework.utils.FunctionalInterface;
import dungeoncrawler.framework.utils.MathHelper;

public class Feature extends Tile {

	@Serial
	private static final long serialVersionUID = 1L;

	private final FunctionalInterface action;
	//Creates a random feature
	public Feature(byte id, FunctionalInterface action) {
		super(id, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7), false);
		this.action = action;
	}
	//Creates a copy of that feature
	public Feature(Feature copy) {
		this(copy.getID(), copy.action);
	}
	//Makes sure feature isn't being placed on a wall
	@Override
	public boolean intersects(Rectangle r) {
		if(super.intersects(r)) {
			this.action.action();
			return true;
		}
		return false;
	}
	//Renders in the feature
	public void render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(super.getID()), super.x, super.y, super.width, super.height, null);
	}
}
