package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Road extends GameObject {
	
	ArrayList <Car> cars = new ArrayList();
	
	Road(int y,int height) {
		super(0, y, Crossyroad.WIDTH, height);
		
	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, Crossyroad.HEIGHT/2-25+(y-ObjectManager.manager.cam.y), width, height);
		for(Car c: cars) {
			c.draw(g);
		}
	}
	
	void addCar(int x, int y, int width, int speed) {
		cars.add(new Car(x,y,width,50, speed));
	}
}
