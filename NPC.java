import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NPC extends JLabel{
	private int x = 0, y =0; 
	private String dialogue;
	JLabel dialoguePanel = new JLabel();
	JTextArea dialogueArea;
	ArrayList<Item> shop = new ArrayList<Item>();
	
	 NPC(int x1, String s){
		 setIcon(new ImageIcon(getClass().getClassLoader().getResource("NPC1.gif")));
		 x = x1;
		y = AdventureManager.floorHeight-100;
		dialogue = s;
		setBackground(Color.blue);
		setSize(50,100);
		setLocation(x,y);
		setVisible(true);
		AdventureManager.mainPanel.repaint();
		makePanel();
	}
	 public void makePanel() {
		 dialoguePanel.setSize(300,300);
		 dialoguePanel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("textBubble.png")));
		 dialoguePanel.setLocation(x-125, y-300);
		 dialoguePanel.setBackground(Color.green);
		 dialoguePanel.setLayout(null);
		 dialoguePanel.setVisible(false);
		 AdventureManager.mainPanel.add(dialoguePanel);
		 
		 dialogueArea = new JTextArea();
		 dialogueArea.setEditable(false);
		 dialogueArea.setLocation(8,5);
		 dialogueArea.setOpaque(false);
		 dialogueArea.setSize(285,200);
		 dialogueArea.setLayout(null);
		 dialogueArea.setFont(AdventureManager.GUIFont);
		 dialogueArea.setLineWrap(true);
		 dialogueArea.setWrapStyleWord(true);
		 dialogueArea.setForeground(Color.black);
		 dialogueArea.setBackground(Color.red);
		 dialogueArea.setText(dialogue);
		 dialoguePanel.add(dialogueArea);
		 dialogueArea.setVisible(true);
		 
		 
	 }
	 public void addItem(Item t, int p) {
		 t.price = p;
		 shop.add(t);
	 }
	public void showDialogue(){
		 
		 dialoguePanel.setVisible(true);
		 Main.window.requestFocus();
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
				if(!shop.isEmpty()) AdventureManager.currentNPC = this;
			}
		else {
			hideDialogue();
			if(AdventureManager.currentNPC == this) AdventureManager.currentNPC = null;
		}
		
		
		
	}
	
}
