import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Room {
	static int floorHeight =700;
	static int gold = 5;
	 ArrayList<Platform> blocks = new ArrayList<Platform>();
	 ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	 ArrayList<NPC> NPCs = new ArrayList<NPC>();
	static boolean clear; 
	ImageIcon background;
	public static Music musicPlayer;
	Timer t;
	int first =0, first1=0, beginning = 10, end = 1135;
	public static JPanel floor, dataPanel;
	public JLabel mainPanel = new JLabel();
	public static JLabel healthInfo;
	private Room leftRoom, rightRoom;
	static Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	static Font TextFont = new Font("Comic Sans MS", Font.PLAIN, 25);
	String factoryMusic = ".//res//Laserpack.wav";
	String DRUM = ".//res//DRUM.wav";
	
	Room(String bg){
		leftRoom = null;
		rightRoom = null;
		background = new ImageIcon(getClass().getClassLoader().getResource(bg + ".png"));
	}
	
	public void start(int start){
		AdventureManager.currentRoom = this;
		AdventureManager.toon.x = start;
		AdventureManager.mainPanel.setIcon(background);
		
		for(int i =0; i<enemies.size(); i++) {
			enemies.get(i).alive = true;
			AdventureManager.mainPanel.add(enemies.get(i));
		}
		
		for(int i =0; i<blocks.size(); i++) {
			AdventureManager.mainPanel.add(blocks.get(i));
		}
		for(int i =0; i<NPCs.size(); i++) {
			AdventureManager.mainPanel.add(NPCs.get(i));
		}
		AdventureManager.mainPanel.repaint();
		
		t = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdventureManager.toon.Update();
				for(int i = 0; i<blocks.size(); i++) {
					blocks.get(i).update();
				}
				for(int i =0; i<NPCs.size(); i++) {
					NPCs.get(i).update();
				}
				for(int i = 0; i<enemies.size(); i++) {
					enemies.get(i).Update();
				}
				
				if(AdventureManager.toon.x < 0) {
					if(leftRoom == null) {
						AdventureManager.toon.x = 0; Main.window.repaint();
					}
					else {
						deleteMain();
						
						leftRoom.start(end);
					}
				}
				if(AdventureManager.toon.x +50 > 1194) {
					if(rightRoom == null) {
						AdventureManager.toon.x = 1145; Main.window.repaint();
					}
					else {
						
						deleteMain();
						
						rightRoom.start(beginning);
					}
				}
			}
			
		}); t.start();
//		musicPlayer.setFile(DRUM);
//		musicPlayer.play(); first++;
		Main.window.setVisible(true);
		Main.window.repaint();
	}
	public void deleteMain() {
		for(int i =0; i<blocks.size(); i++) {
			AdventureManager.mainPanel.remove(blocks.get(i));
		}
		for(int i =0; i<enemies.size(); i++) {
			AdventureManager.mainPanel.remove(enemies.get(i));
		}
		for(int i =0; i<NPCs.size(); i++) {
			AdventureManager.mainPanel.remove(NPCs.get(i));
		}
		t.stop();
		//System.out.println("Main Deleted");
		t.stop();
		Main.window.repaint();
		
	}
	public void addPlatform(Platform p) {
		blocks.add(p);
		p.setVisible(true);
		Main.window.repaint();
	}
	public void addRightRoom(Room r) {
		rightRoom = r;
		
	}
	public void addLeftRoom(Room r) {
		leftRoom = r;
		
	}
	public void addEnemies(Enemy e) {
		enemies.add(e);
		e.setVisible(true);
		Main.window.repaint();
		
	}
	public void addNPC(NPC q) {
		NPCs.add(q);
		q.setVisible(true);
		Main.window.repaint();
		
	}
}
