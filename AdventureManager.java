import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/*

 0 is left position 
 1196 is right position 
 
 */
public class AdventureManager {

	int first = 0, first1 = 0, beginning = 0, end = 1145;
	static int floorHeight = 700;
	static int gold = 5;
	static Room currentRoom;
	static int start = 0;
	ArrayList<Platform> blocks = new ArrayList<Platform>();
	ImageIcon background;
	public static Music musicPlayer;
	public static Combat combat = new Combat();
	public static Enemy currentEnemy;
	public static Adventurer toon;
	public static Timer t;
	public static JPanel floor, dataPanel;
	public static JLabel mainPanel, healthInfo;
	static Font GUIFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	static Font TextFont = new Font("Comic Sans MS", Font.PLAIN, 25);
	static Treasure currentTreasure;
	static NPC currentNPC = null;
	String factoryMusic = ".//res//Laserpack.wav";
	String DRUM = ".//res//DRUM.wav";

	public void createWorld() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			World world = mapper.readValue(new File("world1.yaml"), World.class);
			List<Room> rooms = world.buildRooms();
			rooms.get(0).start();
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to read world file", e);
		}
	}

	public void createSpace() {
		toon = new Adventurer(floorHeight, 0);
		mainPanel = new JLabel();
		mainPanel.setSize(1194, 771);
		mainPanel.setLocation(0, 0);
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
		healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + gold);
		healthInfo.setSize(1200, 25);
		healthInfo.setLocation(0, 0);
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
		if (Adventurer.health > Adventurer.maxHealth)
			Adventurer.health = Adventurer.maxHealth;
		healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + gold);
	}

}
