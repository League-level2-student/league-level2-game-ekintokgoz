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
	}
	
	void hopUp() {
		y-=width;
		collisionBox.setRect(x, y, width, height);
	}
	
	void hopDown() {
		y+=width;
		collisionBox.setRect(x, y, width, height);
	}
	
	void hopRight() {
		x+=width;
		collisionBox.setRect(x, y, width, height);
	}
	
	void hopLeft() {
		x-=width;
		collisionBox.setRect(x, y, width, height);
	}
	
	void checkCollision() {
		for(int i = 0; i<objectManager.trees.size(); i++) {
			if(collisionBox.intersects(objectManager.trees.get(i).collisionBox)) {
				
			}
		}
	}

	public void setObjectManager(ObjectManager objectManager) {
		// TODO Auto-generated method stub
		this.objectManager = objectManager;
	}
}
