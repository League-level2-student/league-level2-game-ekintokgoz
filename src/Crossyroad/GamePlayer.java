package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GamePlayer extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);
		if(needImage) {
			loadImage("chicken.png");
		}
	}


	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, Crossyroad.HEIGHT/2-width/2, width, height, null);
//			g.drawRect(collisionBox.x + collisionBox.width/6, Crossyroad.HEIGHT/2-width/2 + collisionBox.height/6, collisionBox.width-collisionBox.width/3, collisionBox.height - collisionBox.height/3);

		} else {
		g.setColor(Color.RED);
		g.fillRect(x, Crossyroad.HEIGHT/2-width/2, width, height);
		}
	}

	void update() {
		if(x>Crossyroad.WIDTH-width) {
			x=Crossyroad.WIDTH-width;
		}
	}

	void moveX(boolean left) {
		if(left==true) {
			int px = this.x-width;
			Rectangle predictedBox = new Rectangle(px,y, width, height);
			if(!checkCollision(predictedBox)) {
				x-=width;
				collisionBox.setRect(px + width/6, y + height/6, width - width/3, height - height/3);
				ObjectManager.manager.cam.x-=width;
			}
			if(predictedBox.x < 0) {
				x+=width;
			}
		} else {
			int px = this.x+width;
			Rectangle predictedBox = new Rectangle(px,y, width, height);
			if(!checkCollision(predictedBox)) {
				x+=width;
				collisionBox.setRect(px + width/6, y + height/6, width - width/3, height - height/3);
				ObjectManager.manager.cam.x+=width;
			}
		}
	}

	void moveY(boolean up) {
		if(up==true) {
			int py = this.y-width;
			Rectangle predictedBox = new Rectangle(x,py,width,height);
			if(!checkCollision(predictedBox)) {
				y-=width;
				collisionBox.setRect(x + width/6, py + height/6, width - width/3, height - height/3);
				ObjectManager.manager.cam.y-=width;
			}
		}else {
			int py = this.y+width;
			Rectangle predictedBox = new Rectangle(x,py,width,height);
			if(!checkCollision(predictedBox)) {
				y+=width;
				collisionBox.setRect(x + width/6, py + height/6, width - width/3, height - height/3);
				ObjectManager.manager.cam.y+=width;
			}
		}
	}

	boolean checkCollision(Rectangle rect) {
		for(int i = 0; i<ObjectManager.manager.trees.size(); i++) {
			if(rect.intersects(ObjectManager.manager.trees.get(i).collisionBox)) {
				return true;
			}
		}
		return false;
	}
	
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
