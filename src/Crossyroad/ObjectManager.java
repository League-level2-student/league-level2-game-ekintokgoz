package Crossyroad;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList <Tree> trees = new ArrayList();
	Random random = new Random();
	GamePlayer player = new GamePlayer(Crossyroad.WIDTH/2,Crossyroad.HEIGHT/2,50,50);
	
	ObjectManager() {
		player.setObjectManager(this);
	}
	
	void addTree(int x, int y) {
		trees.add(new Tree(x,y,50,50));
	}
	
	void draw(Graphics g) {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).draw(g); 
		}
		player.draw(g);
	}
	
	void update() {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).update();
		}
		player.update();
		
	}
	
	void addTrees() {
		addTree(50,50);
	}
	
	void shiftWorldDown(int amount) {
		for(Tree t: trees) {
			t.y+=amount;
			t.collisionBox.setRect(t.x, t.y, t.width, t.height);
		}
	}
	
	void shiftWorldUp(int amount) {
		for(Tree t: trees) {
			t.y-=amount;
			t.collisionBox.setRect(t.x, t.y, t.width, t.height);
		}
	}
	
}
