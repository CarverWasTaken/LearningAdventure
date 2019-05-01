import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
/*
	This is a game called "Learning Adventure." It is designed for children within the ages of 9-10 years old, and uses mathematics to practice and test academic skills!
    Copyright (C) 2019 Carver Ellis Simkins

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
public class AdventureManager {
	
	int first =0, first1=0, beginning = 0, end = 1145;
	static int floorHeight =700;
	static int gold = 5;
	static Room currentRoom;
	static int start = 0;
	ArrayList<Platform> blocks = new ArrayList<Platform>();
	ImageIcon background;
	public static Music musicPlayer = new Music();
	public static Combat combat = new Combat();
	public static Enemy currentEnemy;
	public static Adventurer toon;
	public static Timer t;
	public static JPanel floor, dataPanel;
	public static JLabel mainPanel, healthInfo;
	public static Shop shop = new Shop();
	static Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	static Font TextFont = new Font("Comic Sans MS", Font.PLAIN, 25);
	static Treasure currentTreasure;
	static NPC currentNPC = null;
	static Room spawnRoom;
	String factoryMusic = ".//res//Laserpack.wav";
	String DRUM = ".//res//DRUM.wav";
	
	public void createWorld() {
		musicPlayer.setFile(".//res//CarverGameMusic.wav");
		musicPlayer.play(); first++;
		Main.window.setVisible(true);
		
		Room forestRoom1 = new Room("Sky"); forestRoom1.setRespawn();
		forestRoom1.addNPC(new NPC(150, "You can use A and D to move, and W to jump! You can jump over those platforms over there!"));
		forestRoom1.addPlatform(new Platform(500, 650));
		forestRoom1.addPlatform(new Platform(550, 600));
		forestRoom1.addPlatform(new Platform(600, 550));
		forestRoom1.start();
		
		Room forestRoom2 = new Room("Sky"); forestRoom1.setRespawn();
		forestRoom2.addNPC(new NPC(150, "You can press I to access your inventory! You can equip armor and use items to heal!"));
		forestRoom2.addPlatform(new Platform(500, 600));
		forestRoom2.addPlatform(new Platform(510, 510));
		forestRoom2.addPlatform(new Platform(520, 420));
	
		Room forestRoom3 = new Room("Sky");
		forestRoom3.addNPC(new NPC(150, "You can press ENTER on a treasure chest to try and open it!"));
		forestRoom3.addPlatform(new Platform(475, 610));
		forestRoom3.addPlatform(new Platform(525, 610));
		forestRoom3.addChest(new Treasure(850, 650, 25));
		forestRoom3.addPlatform(new Platform(575, 610));
		forestRoom3.addPlatform(new Platform(625, 610));
		
	
		
		forestRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 500, "Robot", 5));
		
		Room forestRoom4 = new Room("Sky");
		forestRoom4.addPlatform(new Platform(775, 610));
		forestRoom4.addPlatform(new Platform(675, 620));
		forestRoom4.addPlatform(new Platform(575, 630));
		forestRoom4.addPlatform(new Platform(425, 640));
		forestRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 300, "Robot", 5));
		
		Room forestRoom5 = new Room("Sky");
		forestRoom5.addPlatform(new Platform(775, 400));
		forestRoom5.addPlatform(new Platform(675, 500));
		forestRoom5.addPlatform(new Platform(575, 600));
		forestRoom5.addPlatform(new Platform(665, 300));
		forestRoom5.addPlatform(new Platform(565, 200));
		forestRoom5.addPlatform(new Platform(300, 500));
		forestRoom5.addChest(new Treasure(300, 450, 100));
		forestRoom5.addEnemies(new Enemy(AdventureManager.floorHeight, 300, "Robot", 7));
		forestRoom5.addEnemies(new Enemy(AdventureManager.floorHeight, 350, "Robot", 7));
		forestRoom5.addEnemies(new Enemy(AdventureManager.floorHeight, 400, "Robot", 7));
		
		
		NPC warningGuy = new NPC(250, "That Robot looks even more DANGEROUS than the rest! Buy some items from me to help!");
		warningGuy.addItem(new Item(
				"Tasty Apple",
				"Item",
				"This is a yummy looking apple! If you eat it, the tasty fruit could probably heal you!",
				5
				),10);
		warningGuy.addItem(new Item(
				"Yummy Candy",
				"Item",
				"This candy looks really tasty, but it's not very good for you!",
				10
				),20);
		warningGuy.addItem(new Item(
				"Iron Armor",
				"Armor",
				"This armor is really strong!",
				30
				),200);
		Room forestRoom6 = new Room("Sky"); forestRoom6.setRespawn();
		forestRoom6.addNPC(warningGuy);
		forestRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Robot", 14));
		
		Room caveRoom1 = new Room("Cave");
		caveRoom1.addNPC(new NPC(250, "Wow! These caves look very dangerous! Look out for those Magma Monsters!"));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 500, "Magma", 10));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Magma", 10));
		caveRoom1.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 10));
		
		Room caveRoom2 = new Room("Cave");
		caveRoom2.addChest(new Treasure(650,150,100));
		caveRoom2.addPlatform(new Platform(150, 600));
		caveRoom2.addPlatform(new Platform(250, 500));
		caveRoom2.addPlatform(new Platform(350, 400));
		caveRoom2.addPlatform(new Platform(450, 300));
		caveRoom2.addPlatform(new Platform(550, 200));
		caveRoom2.addPlatform(new Platform(650, 200));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 12));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Magma", 12));
		caveRoom2.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 12));
		
		Room caveRoom3 = new Room("Cave");
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 400, "Magma", 13));
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 500, "Magma", 13));
		caveRoom3.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 13));
		
		Room caveRoom4 = new Room("Cave");
		caveRoom4.addPlatform(new Platform(775, 400));
		caveRoom4.addPlatform(new Platform(675, 500));
		caveRoom4.addPlatform(new Platform(575, 600));
		caveRoom4.addPlatform(new Platform(665, 300));
		caveRoom4.addPlatform(new Platform(565, 200));
		caveRoom4.addPlatform(new Platform(135, 500));
		caveRoom4.addChest(new Treasure(135, 450, 250));
		
		NPC Bobby = new NPC(250, "This area sure is scary! maybe you should buy something from me?");
		Bobby.addItem(new Item(
				"Protective Barrier",
				"Armor",
				"This magic armor creates a magic barrier to help increase your health!",
				50
				),350);
		Bobby.addItem(new Item(
				"Mega Armor",
				"Armor",
				"This is some of the strongest armor ever created!",
				70
				),500);
		Bobby.addItem(new Item(
				"Tasty Apple",
				"Item",
				"This is a yummy looking apple! If you eat it, the tasty fruit could probably heal you!",
				5
				),10);
		Bobby.addItem(new Item(
				"Yummy Candy",
				"Item",
				"This candy looks really tasty, but it's not very good for you!",
				10
				),20);
		Bobby.addItem(new Item(
				"Strengthening Veggies",
				"Item",
				"These veggies make you grow up strong! Plus, they heal for a lot of health!",
				35
				),40);
		Room caveRoom5 = new Room("Cave"); caveRoom5.setRespawn();
		caveRoom5.addNPC(Bobby);
		
		Room caveRoom6 = new Room("Cave");
		caveRoom6.addNPC(new NPC(250, "This looks like the final Room in the caves! Look out, those monsters are strong!"));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 600, "Magma", 18));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 700, "Robot", 18));
		caveRoom6.addEnemies(new Enemy(AdventureManager.floorHeight, 800, "Magma", 18));
		
		Room caveRoom7 = new Room("Sky");
		caveRoom7.addNPC(new NPC(250, "Yay, you made it out of the cave!"));
		caveRoom7.addNPC(new NPC(450, "Great job using math!"));
		caveRoom7.addNPC(new NPC(650, "I'm glad that we planned this MATH PARTY!"));
		caveRoom7.addChest(new Treasure(850, 650, 2500));
		caveRoom7.addChest(new Treasure(920, 650, 2500));
		caveRoom7.addChest(new Treasure(980, 650, 2500));
		caveRoom7.addChest(new Treasure(1050, 650, 2500));
		
		
		
		forestRoom1.addRightRoom(forestRoom2);
		forestRoom2.addRightRoom(forestRoom3); forestRoom2.addLeftRoom(forestRoom1);
		forestRoom3.addLeftRoom(forestRoom2); forestRoom3.addRightRoom(forestRoom4);
		forestRoom4.addLeftRoom(forestRoom3); forestRoom4.addRightRoom(forestRoom5);
		forestRoom5.addLeftRoom(forestRoom4); forestRoom5.addRightRoom(forestRoom6);
		forestRoom6.addLeftRoom(forestRoom5); forestRoom6.addRightRoom(caveRoom1);
		caveRoom1.addLeftRoom(forestRoom6); caveRoom1.addRightRoom(caveRoom2);
		caveRoom2.addLeftRoom(caveRoom1); caveRoom2.addRightRoom(caveRoom3);
		caveRoom3.addLeftRoom(caveRoom2); caveRoom3.addRightRoom(caveRoom4);
		caveRoom4.addLeftRoom(caveRoom3);caveRoom4.addRightRoom(caveRoom5);
		caveRoom5.addLeftRoom(caveRoom4); caveRoom5.addRightRoom(caveRoom6);
		caveRoom6.addLeftRoom(caveRoom5); caveRoom6.addRightRoom(caveRoom7);
		caveRoom7.addLeftRoom(caveRoom6);
	}
	
	
	
	
	
	
	public void createSpace() {
		toon = new Adventurer(floorHeight, 0);
		mainPanel = new JLabel();
		mainPanel.setSize(1194, 771);
		mainPanel.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.MAGENTA);
		Main.window.add(mainPanel);
		mainPanel.setIcon(background);

		
		mainPanel.add(toon);
		Main.window.addKeyListener(toon);
		
		dataPanel = new JPanel(); 
		dataPanel.setLocation(0, 0);
		dataPanel.setSize(1200, 30);
		dataPanel.setLayout(null);
		dataPanel.setBackground(Color.cyan);
		mainPanel.add(dataPanel);
		
		healthInfo = new JLabel();
		healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + gold );
		healthInfo.setSize(1200,25);
		healthInfo.setLocation(0,0);
		healthInfo.setFont(GUIFont);
		dataPanel.add(healthInfo);
		
		floor = new JPanel(); 
		floor.setLocation(0, floorHeight);
		floor.setSize(1200, 300);
		floor.setBackground(Color.gray);
		mainPanel.add(floor);
		
		mainPanel.setVisible(true);
		Main.window.setVisible(true);
		floor.setVisible(true);
		
		createWorld();
	}
	static void heal(int h) {
		Adventurer.health += h;
		if(Adventurer.health > Adventurer.maxHealth) Adventurer.health = Adventurer.maxHealth;
		healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + gold );
	}
	
}

