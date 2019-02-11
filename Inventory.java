import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inventory{
	JLabel inventoryPanel = new JLabel();
	ImageIcon inventoryB = new ImageIcon(getClass().getClassLoader().getResource("INVENTORY.png"));;
	static boolean on;
 public void start() {
	 	
	 AdventureManager.currentRoom.t.stop();
		System.out.println("Yass");
		inventoryPanel.setSize(1194, 771);
		inventoryPanel.setIcon(inventoryB);
		inventoryPanel.setLocation(0,0);
		inventoryPanel.setLayout(null);
		inventoryPanel.setBackground(Color.green);
		Main.window.add(inventoryPanel);
		inventoryPanel.setVisible(true);
		Main.window.setVisible(true);
		AdventureManager.mainPanel.setVisible(false);
		on = true;
		
		
		JButton leaveButton = new JButton("Exit");
		
		leaveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryPanel.setVisible(false);
				AdventureManager.mainPanel.setVisible(true);
				 AdventureManager.currentRoom.t.start();
					Main.window.requestFocus();
			}
			
		});
		leaveButton.setSize(100, 50);
		leaveButton.setLocation(500, 500);
		inventoryPanel.add(leaveButton);
		leaveButton.setVisible(true);
		
 }

}
