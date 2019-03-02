import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NPC extends JPanel{
	private int x = 0, y =0; 
	private String dialogue;
	JPanel dialoguePanel = new JPanel();
	
	 NPC(int x1, String s){
		x = x1;
		y = AdventureManager.floorHeight-100;
		setBackground(Color.blue);
		setSize(50,100);
		setLocation(x,y);
		setVisible(true);
		AdventureManager.mainPanel.repaint();
		 
	}
	public void showDialogue(){
		 
		 dialoguePanel.setSize(300,300);
		 dialoguePanel.setLocation(x-130, y-300);
		 dialoguePanel.setBackground(Color.green);
		 dialoguePanel.setLayout(null);
		 AdventureManager.mainPanel.add(dialoguePanel);
		 dialoguePanel.setVisible(true);
		AdventureManager.mainPanel.repaint();
	 }
	public void hideDialogue(){
		 dialoguePanel.setVisible(false);
	}
	public void update(){
		if(((AdventureManager.toon.x + 50 > x) && (AdventureManager.toon.x + 50 < x+50) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+100) )
				|| ((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50)&&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+100) )
					
					) {
				showDialogue();
			}
		else {
			hideDialogue();
		}
	}
}
