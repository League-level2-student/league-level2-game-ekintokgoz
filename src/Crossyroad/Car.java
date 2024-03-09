package Crossyroad;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Car extends GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;	
	static Random random = new Random();
	
	Car(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		int carNum = random.nextInt(7);
		if(needImage) {
			if(carNum == 0) {
			loadImage("car.png");
			}if(carNum == 1) {
			loadImage("car2.png");	
			}if(carNum == 2) {
			loadImage("bus1.png");		
			}if(carNum == 3) {
			loadImage("truck1.png");		
			}if(carNum == 4) {
			loadImage("car3.png");		
			}if(carNum == 5) {
			loadImage("car4.png");		
			}if(carNum == 6) {
			loadImage("car5.png");		
			}
		}
	}
	
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height, null);
		} else {
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
