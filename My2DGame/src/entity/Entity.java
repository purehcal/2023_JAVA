package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity { 	//this stores variables that will be used in player, monster and NPC classes.
	
	public int worldX, worldY;
	public int speed;
	public BufferedImage up, down, left, right;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
}
