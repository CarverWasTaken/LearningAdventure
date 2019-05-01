import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class Treasure extends JLabel{
	private boolean open;
	 int gold , x , y, locksPassed = 0, locksFailed = 0;
	 JPanel unlockPanel;
	int count;
	Treasure(int x1, int y1, int g){
		setIcon(new ImageIcon(getClass().getClassLoader().getResource("Chest.png")));
		x = x1;
		y = y1;
		setSize(50,50);
		setLocation(x,y);
		open = false;
		gold = g;
	}
	public void openChest(){
		open = true;
		 AdventureManager.gold += AdventureManager.currentTreasure.gold;
	 AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold );
		setIcon(new ImageIcon(getClass().getClassLoader().getResource("ChestOpen.png")));
		Inventory.addItem(new Item(
				"Tasty Apple",
				"Item",
				"This is a yummy looking apple! If you eat it, the tasty fruit could probably heal you!",
				5
				));
		
	}
	public void unlock() {
		unlockPanel = new JPanel();
		
		
		AdventureManager.currentRoom.t.stop();
		unlockPanel.setSize(1194, 771);
		unlockPanel.setLocation(0,0);
		unlockPanel.setLayout(null);
		unlockPanel.setBackground(Color.black);
		Main.window.add(unlockPanel);
		unlockPanel.setVisible(true);
		Main.window.setVisible(true);
		AdventureManager.mainPanel.setVisible(false);
		
		JPanel lockPanel = new JPanel();
		lockPanel.setSize(600,500);
		lockPanel.setLocation(300,125);
		lockPanel.setBackground(Color.red);
		lockPanel.setLayout(null);
		unlockPanel.add(lockPanel);
		lockPanel.setVisible(true);
		
		lockPanel.add(new Lock(1));
		lockPanel.add(new Lock(2));
		lockPanel.add(new Lock(3));
		
		
		
	}
	public void update() {
		if((open==false) && ((AdventureManager.toon.x + 50 > x) && (AdventureManager.toon.x + 50 < x+50) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )
				|| ((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50)  && (open==false) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )
					
					) {
				AdventureManager.currentTreasure = this;
				if(count == 0) count++;
			}
		else {
			if(count>0) {
				AdventureManager.currentTreasure = null;
				count = 0;
			}
		}
		
	}
	
}
