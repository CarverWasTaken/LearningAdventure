import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
		 if(shop.size()>0) { setIcon(new ImageIcon(getClass().getClassLoader().getResource("Shopkeeper.png")));
		 }
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
