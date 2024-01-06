package Crossyroad;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList <Tree> trees = new ArrayList();
	Random random = new Random();
	
	ObjectManager() {
		
	}
	
	void addTree() {
		trees.add(new Tree(50,50,50,50));
	}
	
	void draw(Graphics g) {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).draw(g); 
		}
	}
	
	void update() {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).update();
		}
	}
}
