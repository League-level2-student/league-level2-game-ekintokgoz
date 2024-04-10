package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Train extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	Train(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		if(needImage) {
			loadImage("Train.png");
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height, null);
		}else {
			g.setColor(Color.BLUE);
			g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
		}
	}

	void update() {
		x-=speed;
		collisionBox.setRect(x, y, width, height);
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
