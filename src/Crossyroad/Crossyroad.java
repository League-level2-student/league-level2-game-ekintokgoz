package Crossyroad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Crossyroad extends JPanel implements ActionListener, KeyListener {
	
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	Timer timer;
	Font titleFont;
	Font subTitleFont;
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
		timer = new Timer(1000/30,this);
		timer.start();
		objectManager.addTrees();
		frame.addKeyListener(this);
	}
	
	void updateMenuState() {}
	void updateGameState() {}
	void updateEndState() {}
	
	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("CROSSYROAD", 25, 200);
		g.setFont(subTitleFont);
		g.drawString("Click to start", 115, 350);
	}
	void drawGameState(Graphics g) {
		objectManager.draw(g);
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
	objectManager.update();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			objectManager.player.moveY(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			objectManager.player.moveY(false);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			objectManager.player.moveX(true); 
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			objectManager.player.moveX(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
	
}
