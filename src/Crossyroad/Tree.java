package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Tree extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Tree(int x, int y, int width, int height) {
		super(x, y, width, height);
		if(needImage) {
			loadImage("tree.png");
		}
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height, null);
		} else {
		g.setColor(Color.GREEN);
		g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
	}
	}
	
	void update() {
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
