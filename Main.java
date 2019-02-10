import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static JFrame window;
	AdventureManager manager;
	public static void main(String[] args) {
		new Main();

	}
	Main(){
		window = new JFrame("Learning Adventure"); //Generating main window, using JFrame 
		window.setSize(1200, 800);
		window.setLayout(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		manager = new AdventureManager();
		manager.createSpace();
//		manager.firstArea(0);
		
	}
	
}
