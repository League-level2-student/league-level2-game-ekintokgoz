package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GamePlayer extends GameObject {


	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, Crossyroad.HEIGHT/2-width/2, width, height);
	}

	void update() {
		if(x>Crossyroad.WIDTH-width) {
			x=Crossyroad.WIDTH-width;
		}
	}

	void hopUp() {
		//y-=width;
		if(y>Crossyroad.HEIGHT/3) {
			ObjectManager.manager.shiftWorldDown(height);	
			y-=height;
			collisionBox.setRect(x, y, width, height);
			if(checkCollision(collisionBox)) {
				y+=width;
				ObjectManager.manager.shiftWorldUp(height);
				collisionBox.setRect(x, y, width, height);
			}
		} else {
			ObjectManager.manager.shiftWorldDown(height);
			collisionBox.setRect(x, y, width, height);
			if(checkCollision(collisionBox)) {
				y+=width;
				ObjectManager.manager.shiftWorldUp(height);
				collisionBox.setRect(x, y, width, height);
			}
		}
	}

	void hopDown() {
		y+=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision(collisionBox)) {
			y-=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	void hopRight() {
		x+=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision(collisionBox)) {
			x-=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	void hopLeft() {
		x-=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision(collisionBox)) {
			x+=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	void moveX(boolean left) {
		if(left==true) {
			int px = this.x+width;
			Rectangle predictedBox = new Rectangle(px,y, width, height);
			if(!checkCollision(predictedBox)) {
				x+=width;
				collisionBox.setRect(px, y, width, height);
				ObjectManager.manager.cam.x+=width;
			}
		} else {
			int px = this.x-width;
			Rectangle predictedBox = new Rectangle(px,y, width, height);
			if(!checkCollision(predictedBox)) {
				x-=width;
				collisionBox.setRect(px, y, width, height);
				ObjectManager.manager.cam.x-=width;
			}
		}
	}

	void moveY(boolean up) {
		if(up==true) {
			int py = this.y-width;
			Rectangle predictedBox = new Rectangle(x,py,width,height);
			if(!checkCollision(predictedBox)) {
				y-=width;
				collisionBox.setRect(x, py, width, height);
				ObjectManager.manager.cam.y-=width;
			}
		}else {
			int py = this.y+width;
			Rectangle predictedBox = new Rectangle(x,py,width,height);
			if(!checkCollision(predictedBox)) {
				y+=width;
				collisionBox.setRect(x, py, width, height);
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
}
