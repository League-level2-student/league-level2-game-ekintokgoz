package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class TrainTracks extends GameObject{

	Train train;
	
	TrainTracks(int y, int height) {
		super(0, y, Crossyroad.WIDTH, height);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
		if(train != null) {
			train.draw(g);
		}
	}
	
	void addTrain() {
		if(train == null) {
		train = new Train(Crossyroad.WIDTH+100,y,2000,50,50);
		}
	}
	
	void update() {
		if(train != null) {
		train.update();
		}
	}

}
