import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Combat {
	public static JPanel combatPanel, menuPanel, damagePanel, healthPanel;
	public static String enemyName;
	public static Boolean inCombat = true;
	public static JTextArea healthDisplay;
	public static Projectile projectile1;
	public static Music battleMusic;
	static Timer time;
	Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 30);
	Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 15);
	public static JLabel enemyPanel, playerPanel;
	ImageIcon Image, playerImage;
	public static int target = 350, currentLocation = 350, ammo = 1, count =0, maxAmmo =1, playerField, enemyDamage, enemyLevel;
	public static Timer changeTarget, move;
	public static void startCombat(int enemy, Timer t) {
		time = t;
		//t.stop();
		AdventureManager.mainPanel.setVisible(false);
		//AdventureManager.musicPlayer.stop();
		
//		battleMusic = new Music();
//		battleMusic.setFile(".//res//Metalmania.wav");
//		battleMusic.play();
//		
		
		new Combat(enemy);
	}
	Combat(int enemy){
		AdventureManager.currentRoom.t.stop();
		enemyName = "Robot";
		menuPanel = new JPanel();
		menuPanel.setSize(1194, 771);
		menuPanel.setLocation(0,0);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.green);
		Main.window.add(menuPanel);
		
		
		JPanel introPanel = new JPanel();
		introPanel.setLocation(350, 100); 
		introPanel.setSize(500, 300);
		introPanel.setBackground(Color.green);
		
		JTextArea introArea = new JTextArea();
		introArea.setSize(500, 300);
		introArea.setFont(menuFont);
		introArea.setLocation(0,0);
		introArea.setEditable(false);
		introArea.setForeground(Color.white);
		introArea.setBackground(Color.green);
		introArea.setLineWrap(true);
		introArea.setWrapStyleWord(true);
		introArea.setText("You got attacked by a " + enemyName + "! What do you do?");
		introPanel.add(introArea);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLocation(350, 400); 
		buttonPanel.setSize(500, 200);
		buttonPanel.setBackground(Color.green);
		
		
		menuPanel.add(introPanel);
		menuPanel.add(buttonPanel);
		
		JButton fightButton = new JButton();
		fightButton.setFont(menuFont);
		fightButton.setBackground(Color.CYAN);
		fightButton.setText("Fight!");
		buttonPanel.add(fightButton);
		fightButton.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuPanel.setVisible(false);
				Main.window.remove(menuPanel);
				Main.window.setVisible(true);
				
				switch(enemy) {
				case 0: robotCombat(); break;
				}
				
			}
			
		});
		
		
		JButton itemButton = new JButton();
		itemButton.setText("Use an item!");
		itemButton.setFont(menuFont);
		itemButton.setBackground(Color.CYAN);
		buttonPanel.add(itemButton);
		
		JButton runButton = new JButton();
		runButton.setText("Run!");
		runButton.setFont(menuFont);
		runButton.setBackground(Color.CYAN);
		runButton.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int runChance = rand.nextInt(2);
				
				switch(runChance) {
				case 0: 
				menuPanel.setVisible(false);
				Main.window.remove(menuPanel);
				Main.window.setVisible(true); Run(); break;
				case 1: 
					menuPanel.setVisible(false);
					Main.window.remove(menuPanel);
					Main.window.setVisible(true);
					robotCombat(); break;
				}
				
			}
			
		});
		buttonPanel.add(runButton);
		
		
		
		
		buttonPanel.setLayout(new GridLayout(3,1));
		
		
		Main.window.setVisible(true);
		

	}
	
	public void robotCombat() {
		inCombat = true;
		enemyLevel = 5;
		enemyDamage = 2;
		
		combatPanel = new JPanel();
		combatPanel.setSize(1194, 771);
		combatPanel.setLocation(0,0);
		combatPanel.setLayout(null);
		combatPanel.setBackground(Color.magenta);
		
		Main.window.add(combatPanel);
		
		Image = new ImageIcon();
		Image = new ImageIcon(getClass().getClassLoader().getResource("RobotLeft.png"));
		
		playerImage = new ImageIcon();
		playerImage = new ImageIcon(getClass().getClassLoader().getResource("SnowmanRight.png"));
		
		enemyPanel = new JLabel(); 
		enemyPanel.setSize(50, 100);
		enemyPanel.setLocation(1100, currentLocation);
		enemyPanel.setBackground(Color.GREEN);
		enemyPanel.setIcon(Image);
		
		combatPanel.add(enemyPanel);
		
		
		playerPanel = new JLabel(); 
		playerPanel.setSize(50, 100);
		playerPanel.setLocation(50, 350);
		playerPanel.setBackground(Color.GREEN);
		playerPanel.setIcon(playerImage);
		
		combatPanel.add(playerPanel);

		
		healthPanel = new JPanel(); 
		healthPanel.setSize(100, 25);
		healthPanel.setLocation(25, 300);
		healthPanel.setBackground(Color.GREEN);
		
		healthDisplay = new JTextArea();
		healthDisplay.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth);
		healthDisplay.setLocation(0,0);
		healthDisplay.setSize(100, 25);
		healthDisplay.setFont(GUIFont);
		healthDisplay.setBackground(Color.green);
		healthPanel.add(healthDisplay);
		combatPanel.add(healthPanel);
		
		damagePanel = new JPanel(); 
		damagePanel.setSize(140, 780);
		damagePanel.setLocation(0,0);
		damagePanel.setBackground(Color.cyan);
		
		combatPanel.add(damagePanel);
		
		Main.window.setVisible(true);
		changeTarget = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(count == 10) { endCombat(); count = 0; target = 350;} 
				count++;
				
			Random rand = new Random(); 
			int chance = rand.nextInt(3);
			
			switch(chance) {
			case 0: target = 50; break;
			case 1: target = 350; break;
			case 2: target = 640; break;
			}
				
			}
			
		}); changeTarget.start();
		
		move = new Timer(3, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(currentLocation < target) {
					ammo = maxAmmo;
					currentLocation = currentLocation+2;
					enemyPanel.setLocation(1100, currentLocation); enemyPanel.repaint();
				}
				if(currentLocation > target) {
					ammo = maxAmmo;
					currentLocation = currentLocation-2;
					enemyPanel.setLocation(1100, currentLocation); enemyPanel.repaint();
				}
				if(currentLocation == target) {
					if(ammo > 0) {
						
						projectile1 = new Projectile(currentLocation); 
						combatPanel.add(projectile1);
						ammo--;
						Main.window.setVisible(true);
					}
					
				}
				
			}
			
		}); move.start();
		
		
	}
	public  void playerAttack() {
		
	}
	public static void endCombat() {
		AdventureManager.currentRoom.t.start();
		//battleMusic.stop();
		//AdventureManager.musicPlayer.play();
		inCombat = false;
		Projectile.t.stop();
		move.stop();
		changeTarget.stop();
		
		//AdventureManager.t.start();
		AdventureManager.mainPanel.setVisible(true);
		
		combatPanel.setVisible(false);
		Main.window.requestFocus();
		Main.window.remove(combatPanel);
		Random rand = new Random();
		int enemyReward = enemyLevel + rand.nextInt(enemyLevel) +1;
		
		
//		AdventureManager.dialogueBox("You defeated the " + enemyName + "!\nYou got " + enemyReward + " gold!" );
		AdventureManager.gold += enemyReward;
		AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold );
	}
	public static void Run() {
		//battleMusic.stop();
		
		//AdventureManager.musicPlayer.play();
		inCombat = false;
		AdventureManager.currentRoom.t.start();
		AdventureManager.mainPanel.setVisible(true);
		
		
		Main.window.requestFocus();
	}
}
