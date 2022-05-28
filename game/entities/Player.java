package dungeoncrawler.game.entities;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serial;

import dungeoncrawler.framework.resources.Resources;
import dungeoncrawler.framework.utils.MathHelper;
import dungeoncrawler.game.world.Tile;

public class Player extends Entity {

	@Serial
	private static final long serialVersionUID = 1L;
	//Initializes variables for use in constructor
	private int hp;
	private static int maxHp = 20;
	private byte regenDelay;
	private int armor;
	private int gold;
	private static int exp = 0;
	private static int damage = 0;
	private static int attackSpeed = 0;
	
	private byte attackTime;
	private byte damageTime;
	//Set up player variables
	public Player() {
		super(Resources.PLAYER, MathHelper.randomInt(2, 14), MathHelper.randomInt(2, 7));
		this.hp = maxHp;
		this.regenDelay = 0;
		this.armor = 0;
		this.gold = 0;
		this.attackTime = 0;
		this.damageTime = 0;
		damage = 0;
	}
	//Places player randomly upon spawning into the games
	public void replaceRandomly() {
		super.x = MathHelper.randomInt(2, 14)*Tile.SIZE;
		super.y = MathHelper.randomInt(2, 7)*Tile.SIZE;
	}
	//Returns the current hp
	public int getHp() {
		return hp;
	}
	//Returns max hp
	public int getMaxHp() {
		return maxHp;
	}
	//Heals character instantly
	public void instantHeal(int amount) {
		this.hp += amount;
		if(this.hp > maxHp) this.hp = maxHp;
	}
	//Heals character slowly
	public void regenerateHealth() {
		if(this.hp < maxHp) this.regenDelay++;
		else this.regenDelay = 0;
		
		if(this.regenDelay == 50) {
			this.hp++;
			this.regenDelay = 0;
		}
	}
	//Returns the amount of armour
	public int getArmor() {
		return armor;
	}
	//Adds armour onto player
	public void addArmor(int amount) {
		this.armor += amount;
		if(this.armor > 75) this.armor = 75;
	}
	//Returns gold
	public int getGold() {
		return gold;
	}
	//Add gold
	public void giveGold(int amount) {
		this.gold += amount;
	}
	//Adds max hp
	public static void addHealth(){
		maxHp+=5;
	}
	//Adds attack speed
	public static void addSpeed(){
		attackSpeed+=2;
	}
	public static int getSpeed(){
		return attackSpeed;
	}
	//Adds an upgrade point
	public static void addEXP(){
		exp++;
	}
	//Returns how many upgrade points player has
	public static int getEXP(){
		return exp;
	}
	//Removes an upgrade point
	public static void removeEXP(){
		exp--;
	}
	//Moves player and uses sprite based off of direction player is facing
	@Override
	public void move() {
		super.move();
		switch (facing) {
			case NORTH -> super.entityID = Resources.PLAYER_BACK;
			case SOUTH -> super.entityID = Resources.PLAYER;
			case WEST -> super.entityID = Resources.PLAYER_LEFT;
			case EAST -> super.entityID = Resources.PLAYER_RIGHT;
		}
	}
	//Attack timer cool down
	public void decreaseTime() {
		if(this.attackTime > 0) this.attackTime--;
		if(this.damageTime > 0) this.damageTime--;
	}
	//Attacks if cool down timer is over
	public void attack() {
		if(this.attackTime == 0) this.attackTime = (byte)(30 - attackSpeed);
	}
	//Finds where the attack will hit
	public Rectangle getAttackBox() {
		if(this.attackTime == 20) {
			switch(facing) {
			case NORTH:
				return new Rectangle(super.x, super.y - super.height, super.width, super.height);
			case SOUTH:
				return new Rectangle(super.x, super.y + super.height, super.width, super.height);
			case WEST:
				return new Rectangle(super.x - super.width, super.y, super.width, super.height);
			case EAST:
				return new Rectangle(super.x + super.width, super.y, super.width, super.height);
			default:
				break;
			}
		}
		return new Rectangle(0, 0, 0, 0);
	}
	//Render in player
	@Override
	public void render(Graphics graphics) {
		if((up || down || left || right) && this.attackTime == 0) {
			super.animationDelay++;
			if(super.animationDelay == 70) {
				super.animationDelay = 0;
				super.animationFrame = (byte) (1 - super.animationFrame);
			}
		}
		graphics.drawImage(Resources.TEXTURES.get(entityID + animationFrame), super.x, super.y, super.width, super.height, null);
	}
	//Calculate the damage dealt to enemy
	public void damage(int amount, MathHelper.Direction knockback) {
		if(this.damageTime == 0) {
			this.hp -= (amount + damage);
			this.damageTime = 50;
		}
		super.x += knockback.dirX * 30;
		super.y += knockback.dirY * 30;
	}
}
