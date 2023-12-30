package Crossyroad;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Crossyroad extends JPanel implements ActionListener {
	
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	Timer timer;
	ObjectManager objectManager = new ObjectManager();
	
	public static void main(String[] args) {
		Crossyroad crossyroad = new Crossyroad();
		crossyroad.run();

	}
	
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.pack();	
		timer = new Timer(1000/60,this);
		timer.start();
	}
	
	void updateMenuState() {}
	void updateGameState() {}
	void updateEndState() {}
	
	void drawMenuState(Graphics g) {
		
	}
	void drawGameState(Graphics g) {
		
	}
	void drawEndState(Graphics g) {
		
	}
@Override
protected void paintComponent(Graphics g) {
	objectManager.draw(g);
}
	@Override
	public void actionPerformed(ActionEvent e) {
	repaint();
		
	}
	
}
