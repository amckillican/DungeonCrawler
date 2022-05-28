package dungeoncrawler.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serial;

import dungeoncrawler.framework.resources.Resources;
import dungeoncrawler.framework.utils.MathHelper;
import dungeoncrawler.game.world.Tile;

public class Entity extends Rectangle {

	@Serial
	private static final long serialVersionUID = 1L;
	//Initialize variables for use in constructor
	protected byte entityID;
	
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	
	protected int speed;
	
	protected MathHelper.Direction facing;
	
	protected byte animationFrame;
	protected byte animationDelay;
	//Set variable values
	public Entity(byte id, int posXinRoom, int posYinRoom) {
		super(posXinRoom*Tile.SIZE, posYinRoom*Tile.SIZE, Tile.SIZE, Tile.SIZE);
		this.entityID = id;
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
		this.speed = 5;
		facing = MathHelper.Direction.SOUTH;
		this.animationFrame = 0;
	}
	//Get the ID of the object
	public byte getID() {
		return entityID;
	}
	//Figure out which way the entity is moving
	public void move() {
		if(up) {
			super.y-=this.speed;
			facing = MathHelper.Direction.NORTH;
		}
		if(down) {
			super.y+=this.speed;
			facing = MathHelper.Direction.SOUTH;
		}
		if(left) {
			super.x-=this.speed;
			facing = MathHelper.Direction.WEST;
		}
		if(right) {
			super.x+=this.speed;
			facing = MathHelper.Direction.EAST;
		}
	}
	//Sets the way entity is moving to up
	public void setMovingUp(boolean up) {
		this.up = up;
	}
	//Sets the way entity is moving to down
	public void setMovingDown(boolean down) {
		this.down = down;
	}
	//Sets the way entity is moving to left
	public void setMovingLeft(boolean left) {
		this.left = left;
	}
	//Sets the way entity is moving to right
	public void setMovingRight(boolean right) {
		this.right = right;
	}
	//Sets the center of entity on the x
	public void setCenterX(int x) {
		super.x = x - super.width/2;
	}
	//Sets the center of the entity on the y
	public void setCenterY(int y) {
		super.y = y - super.height/2;
	}
	//Renders in the entity
	public void render(Graphics graphics) {
		if(up || down || left || right) {
			this.animationDelay++;
			if(this.animationDelay == 70) {
				this.animationDelay = 0;
				this.animationFrame = (byte) (1 - this.animationFrame);
			}
		}
		graphics.drawImage(Resources.TEXTURES.get(entityID + animationFrame), super.x, super.y, super.width, super.height, null);
	}
	//Does collision with player and entity and entity on entity
	public void handleCollisionWith(Tile tile) {
		Rectangle intersection = this.intersection(tile);
		if(intersection.isEmpty() || !tile.isWall())
			return;
			
		if(intersection.width > intersection.height) {
			if(this.y < tile.y)
				this.y = tile.y - this.height;
			else
				this.y = tile.y + this.height;
		}
		else {
			if(this.x < tile.x)
				this.x = tile.x - this.width;
			else
				this.x = tile.x + this.width;
		}
	}
	//Check which way is facing
	public MathHelper.Direction getFacing() {
		return facing;
	}
}
