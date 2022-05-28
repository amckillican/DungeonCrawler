package dungeoncrawler.game.entities;

import dungeoncrawler.framework.utils.MathHelper;

import java.io.Serial;

public class Enemy extends Entity {

	@Serial
	private static final long serialVersionUID = 1L;
	//Make the player the target always
	private final Player target;
	//Initialize the hp
	private int hp;
	//Create an enemy that targets the player with a set amount of health
	public Enemy(byte id, int health, Player target) {
		super(id, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7));
		this.target = target;
		super.speed = 2;
		this.hp = health;
	}
	//Create a copy of this enemy for times where there is more than one
	public Enemy(Enemy copy) {
		this(copy.getID(), copy.hp, copy.target);
	}
	//Moves the bat towards the target
	@Override
	public void move() {
		super.move();
		float angCoeff = ((float) this.target.y - (float) super.y) / ((float) this.target.x - (float) super.x);
		if(angCoeff < 1 && angCoeff > -1) {
			if(this.target.x < super.x) {
				super.up = false;
				super.down = false;
				super.left = true;
				super.right = false;
			} else {
				super.up = false;
				super.down = false;
				super.left = false;
				super.right = true;
			}
		}
		else if(angCoeff > 1 || angCoeff < -1) {
			if(this.target.y < super.y) {
				super.up = true;
				super.down = false;
			} else {
				super.up = false;
				super.down = true;
			}
			super.left = false;
			super.right = false;
		}
		else {
			if(this.target.x < super.x) {
				super.left = true;
				super.right = false;
			} else {
				super.left = false;
				super.right = true;
			}
		}
	}
	
	@SuppressWarnings("EmptyMethod")
	@Override
	public void setMovingUp(boolean up) {
	}
	
	@SuppressWarnings("EmptyMethod")
	@Override
	public void setMovingDown(boolean down) {
	}
	
	@SuppressWarnings("EmptyMethod")
	@Override
	public void setMovingLeft(boolean left) {
	}
	
	@SuppressWarnings("EmptyMethod")
	@Override
	public void setMovingRight(boolean right) {
	}
	//Returns hp of enemy to see if dead
	public int getHp() {
		return hp;
	}
	//Calculates damage and knock back
	public void damage(int amount, MathHelper.Direction knockback) {
		this.hp -= amount;
		super.x += knockback.dirX * 90;
		super.y += knockback.dirY * 90;
	}
}
