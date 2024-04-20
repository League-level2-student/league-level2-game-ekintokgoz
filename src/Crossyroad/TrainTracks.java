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
		train = new Train(Crossyroad.WIDTH+2000,y,3500,50,50);
		ObjectManager.playSound("TrainDing.wav");
		}
	}
	
	void update() {
		if(train != null) {
		train.update();
		}
	}

}
