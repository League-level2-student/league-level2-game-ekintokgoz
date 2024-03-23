package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class TrainTracks extends GameObject{

	TrainTracks(int y, int height) {
		super(0, y, Crossyroad.WIDTH, height);
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
	}
	
	void addTrain(int x, int y, int width, int speed) {
		
	}

}
