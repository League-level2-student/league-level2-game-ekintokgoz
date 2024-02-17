package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Road extends GameObject {
	
	ArrayList <Car> cars = new ArrayList();
	Random ran = new Random();
	
	Road(int y,int height) {
		super(0, y, Crossyroad.WIDTH, height);
		addCar(ran.nextInt(350) + Crossyroad.WIDTH, y, ran.nextInt(101)+50, ran.nextInt(11)+3);
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
	
	void update() {
		for(int i = 0; i<cars.size(); i++) {
			cars.get(i).update();
			if(cars.get(i).x <= -width) {
				cars.remove(i);
				addCar(ran.nextInt(350) + Crossyroad.WIDTH, y, ran.nextInt(101)+50, ran.nextInt(11)+3);
			}
		}
	}
}
