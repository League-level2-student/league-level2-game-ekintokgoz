package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class Train extends GameObject {

	Train(int x, int y, int width, int height) {
		super(x, y, width, height);

	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
	}
	
	void update() {
		x-=speed;
		collisionBox.setRect(x, y, width, height);
	}

}
