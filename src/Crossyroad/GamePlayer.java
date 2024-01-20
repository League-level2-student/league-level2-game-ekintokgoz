package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class GamePlayer extends GameObject {

	ObjectManager objectManager;

	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	void update() {
		y+=GameObject.speed;
		collisionBox.setRect(x, y, width, height);
		if(x>Crossyroad.WIDTH-width) {
			x=Crossyroad.WIDTH-width;
		}
	}

	void hopUp() {
		//y-=width;
		if(y>Crossyroad.HEIGHT/3) {
			objectManager.shiftWorldDown(height);	
			y-=height;
			collisionBox.setRect(x, y, width, height);
			if(checkCollision()) {
				objectManager.shiftWorldUp(height);
				collisionBox.setRect(x, y, width, height);
			}
		} else {
			objectManager.shiftWorldDown(height);
			collisionBox.setRect(x, y, width, height);
			if(checkCollision()) {
				objectManager.shiftWorldUp(height);
				collisionBox.setRect(x, y, width, height);
			}
		}
	}

	void hopDown() {
		y+=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision()) {
			y-=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	void hopRight() {
		x+=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision()) {
			x-=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	void hopLeft() {
		x-=width;
		collisionBox.setRect(x, y, width, height);
		if(checkCollision()) {
			x+=width;
			collisionBox.setRect(x, y, width, height);
		}
	}

	boolean checkCollision() {
		for(int i = 0; i<objectManager.trees.size(); i++) {
			if(collisionBox.intersects(objectManager.trees.get(i).collisionBox)) {
				return true;
			}
		}
		return false;
	}

	public void setObjectManager(ObjectManager objectManager) {
		// TODO Auto-generated method stub
		this.objectManager = objectManager;
	}
}
