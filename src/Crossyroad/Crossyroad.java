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

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Crossyroad extends JPanel implements ActionListener, KeyListener {

	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	static final int MENU = 0;
	static final int GAME = 1;
	static final int END = 2;
	static int currentState = MENU;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer timer;
	Font titleFont = new Font("Arial", Font.BOLD, 40);
	Font subTitleFont = new Font("Arial", Font.ITALIC, 25);
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
		objectManager.addRoads();
		objectManager.addTracks();
		frame.addKeyListener(this);
		setBackground(new Color(108, 235, 120));
	}

	void updateMenuState() {}
	void updateGameState() {}
	void updateEndState() {}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH,HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("CROSSYROAD", 100, 200);
		g.setFont(subTitleFont);
		g.drawString("Press Space to Start", 135, 350);
	}
	void drawGameState(Graphics g) {
		objectManager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH,HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 125, 200);
		g.setFont(subTitleFont);
		g.drawString("Press Space to Play Again", 100, 350);
	}
	@Override
	protected void paintComponent(Graphics g) {
		if(currentState == MENU) {
			drawMenuState(g);
		}else if(currentState == GAME) {
			drawGameState(g);
		}else if(currentState == END) {
			drawEndState(g);
		}
	}
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		objectManager.update();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState == MENU) {
				currentState = GAME;
			}  if(currentState == END) {
				currentState = MENU;
				objectManager.resetPos();
			}
		}
//		if(currentState == GAME) {
//			if(e.getKeyCode()==KeyEvent.VK_UP) {
//				objectManager.player.moveY(true);
//			}
//			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
//				objectManager.player.moveY(false);
//			}
//			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
//				objectManager.player.moveX(false); 
//			}
//			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
//				objectManager.player.moveX(true);
//			}
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(currentState == GAME) {
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				objectManager.player.moveY(true);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				objectManager.player.moveY(false);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				objectManager.player.moveX(false); 
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				objectManager.player.moveX(true);
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {


	}
	
	

}
