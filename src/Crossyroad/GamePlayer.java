package Crossyroad;

import java.awt.Color;
import java.awt.Graphics;

public class GamePlayer extends GameObject {

	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}
