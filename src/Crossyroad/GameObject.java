package Crossyroad;

import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	public static final int speed = 1;
	Rectangle collisionBox;
	
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		Rectangle collisionBox = new Rectangle(x,y,width,height);
	}
}
