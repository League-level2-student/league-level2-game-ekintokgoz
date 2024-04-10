package Crossyroad;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ObjectManager {
	
	ArrayList <Tree> trees = new ArrayList();
	Random random = new Random();
	GamePlayer player = new GamePlayer(Crossyroad.WIDTH/2,Crossyroad.HEIGHT/2,50,50);
	CameraObject cam = new CameraObject(player.x, player.y);
	ArrayList <Road> roads = new ArrayList();
	ArrayList <TrainTracks> tracks = new ArrayList();
	public static ObjectManager manager;
	
	ObjectManager() {
		manager=this;
	}
	
	void addTree(int x, int y) {
		trees.add(new Tree(x,y,50,50));
	}
	
	void addRoad(int y, int height) {
		roads.add(new Road(y, height));
	}
	
	void addTrainTrack(int y, int height) {
		tracks.add(new TrainTracks(y, height));
	}
	
	void draw(Graphics g) {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).draw(g); 
		}
		for(Road r: roads) {
			r.draw(g);
		}
		for (TrainTracks t: tracks) {
			t.draw(g);
		}
		player.draw(g);
		
	}
	
	void update() {
		for(int i = 0; i<trees.size(); i++) {
			trees.get(i).update();
		}
		player.update();
		for(int i = 0; i<roads.size(); i++) {
			roads.get(i).update();
		}
		for(int i = 0; i<tracks.size(); i++) {
			if(player.y == tracks.get(i).y+200) {
				tracks.get(i).addTrain();
			} tracks.get(i).update();
		}
		checkCarCollision();
	}
	
	void resetPos() {
		player = new GamePlayer(Crossyroad.WIDTH/2,Crossyroad.HEIGHT/2,50,50);
		cam = new CameraObject(player.x, player.y);
		roads = new ArrayList<>();
		addRoads();
	}
	
	void addTrees() {
		for(int i = 0; i<10; i++) {
			addTree(50*i,700);
		}
		for(int i = 0; i<3; i++) {
			addTree(50*i,50);
		}
		for(int i = 0; i<3; i++) {
			addTree(50*i+350,50);
		}	
			addTree(300,-400);
			addTree(350,-400);
			addTree(400,-400);
			addTree(50,-350);
			addTree(100,-350);
			addTree(50,-300);
			addTree(0,-300);
			addTree(350,-250);
			addTree(300,-250);
			
			addTree(250,-750);
			addTree(200,-750);
			addTree(150,-750);
			addTree(450,-750);
			addTree(400,-750);
			addTree(300,-900);
			addTree(250,-900);
			addTree(250,-950);
			addTree(300,-950);
			addTree(350,-950);
	}
	
	void addRoads() {
		addRoad(-200,50);
		addRoad(-150,50);
		addRoad(-100,50);
		
		addRoad(-450,50);
		addRoad(-500,50);
		addRoad(-550,50);
		addRoad(-600,50);
		addRoad(-650,50);
		addRoad(-700,50);
		
		addRoad(-800,50);
		addRoad(-850,50);
	}
	
	void addTracks() {
		addTrainTrack(-1100, 50);
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
	
	void checkCarCollision() {
		for(Road r: roads) {
			for(Car c: r.cars) {
				if(c.collisionBox.intersects(player.collisionBox)) {
					Crossyroad.currentState = 2;
					
				}
			}
		}
	}
	
	public static void playSound(String soundFile) {
		String path = "src/Crossyroad/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
    
	
}
