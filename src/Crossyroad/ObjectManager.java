package Crossyroad;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	
	ArrayList <Tree> tree = new ArrayList();
	
	void draw(Graphics g) {
		for(int i = 0; i<tree.size(); i++) {
			tree.get(i).draw(g); 
		}
	}
}
