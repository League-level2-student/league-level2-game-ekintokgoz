package Crossyroad;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	public static final int speed = 1;
	
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
