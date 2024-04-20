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
		int speed = ran.nextInt(10)+3;
		int width = ran.nextInt(51)+50;
		int carX = ran.nextInt(350);
		addCar(Crossyroad.WIDTH, y, width, speed);
		addCar(Crossyroad.WIDTH + 400, y, width, speed);
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
			if(cars.get(i).x <= -cars.get(i).width) {
				cars.get(i).x = Crossyroad.WIDTH;
			}
		}
	}
}
