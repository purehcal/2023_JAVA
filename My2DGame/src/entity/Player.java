package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
		
	}
	
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/덕새 뒷면.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/덕새 전진.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/덕새 좌측.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/덕새 우측.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
	        int prevWorldX = worldX;
	        int prevWorldY = worldY;

	        if (keyH.upPressed) {
	            direction = "up";
	        } else if (keyH.downPressed) {
	            direction = "down";
	        } else if (keyH.leftPressed) {
	            direction = "left";
	        } else if (keyH.rightPressed) {
	            direction = "right";
	        }

	        // CHECK TILE COLLISION
	        collisionOn = false;
	        gp.cChecker.checkTile(this);

	        //CHECK OBJECT COLLISION
	        int objIndex = gp.cChecker.checkObject(this, true);
	        pickUpObject(objIndex);
	        
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
	        if(collisionOn == false) {
	        	
	        	switch(direction) {
	        	case "up": worldY -= speed; break;
	        	case "down": worldY += speed; break;
	        	case "left": worldX -= speed; break;
	        	case "right": worldX += speed; break;
	        	}
	        }

		}
//		else {
//			counter2++;
//			if(counter2 == 20) {
//				spriteNum = 1;
//				counter2 = 0;
//			}
//		}
	}

	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got a key!");
				break;
			case "Door":
				if(hasKey > 0) {
					gp.playSE(3);
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You opened the door!");
				}else {
					gp.ui.showMessage("You need a key!");
				}
				break;
			case "Bok":
				gp.playSE(2);
				speed += 1;
				gp.obj[i] = null;
				gp.ui.showMessage("Speed UP!");
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction ) {
		case "up" :
			image = up;
			break;
		case "down" :
			image = down;
			break;
		case "left" :
			image = left;
			break;
		case "right" :
			image = right;
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); //draw an image on the screen
	}
}
