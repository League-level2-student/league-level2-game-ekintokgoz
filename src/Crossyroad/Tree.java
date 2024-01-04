package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class Tree extends GameObject {

	Tree(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
}
