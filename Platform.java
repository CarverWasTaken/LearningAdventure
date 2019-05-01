import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class Platform extends JLabel {
	private int x, y;
	Timer time;
	public Platform() {
		x = 0;
		y = 0;
		setSize(50, 50);
		setLocation(x,y);
		start();
		
	}
	public Platform(int inX, int inY) {
		x = inX;
		y = inY;
		setSize(50, 50);
		setLocation(x,y);
		start();
	}
	public void start() {
		ImageIcon block;
		block = new ImageIcon(getClass().getClassLoader().getResource("bloc.png"));
		setIcon(block);
		setBackground(Color.blue);
		//AdventureManager.mainPanel.add(this);
		}
	
	public void update() {
		if((AdventureManager.toon.y < y+50) && (AdventureManager.toon.y > y+40) && 
				(((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50))
				|| ((AdventureManager.toon.x+50 > x) && AdventureManager.toon.x+50 < x+50))) {
			AdventureManager.toon.y = y+55; AdventureManager.toon.repaint();
		}
		else if((AdventureManager.toon.y+100 < y) && (AdventureManager.toon.y+100 > y-5) && (((AdventureManager.toon.x >= x) && (AdventureManager.toon.x <= x+50)) 
				|| ((AdventureManager.toon.x+50 >= x) && (AdventureManager.toon.x+50 <= x+50))
				|| ((AdventureManager.toon.x+25 >= x) && AdventureManager.toon.x+25 <= x+50))) {
		 AdventureManager.toon.y = y-105; AdventureManager.toon.repaint();
		 AdventureManager.toon.jumpCount = 25;
		}
		else if(((AdventureManager.toon.x + 50) > x) && ((AdventureManager.toon.x+50)<x+20) && ( //Left Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+45)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+45)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+45)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+45)) 
				
				
				)     ) {
			AdventureManager.toon.x = x-51; AdventureManager.toon.repaint();
		}
		else if(((AdventureManager.toon.x) > x+40) && ((AdventureManager.toon.x)<x+50) && ( //Right Collision
				((AdventureManager.toon.y > y) && (AdventureManager.toon.y < y+50)) ||
				((AdventureManager.toon.y + 25 > y) && (AdventureManager.toon.y + 25 < y+50)) ||
				((AdventureManager.toon.y + 50 > y) && (AdventureManager.toon.y + 50 < y+50)) ||
				((AdventureManager.toon.y + 75 > y) && (AdventureManager.toon.y + 75 < y+50)) ||
				((AdventureManager.toon.y + 100 > y) && (AdventureManager.toon.y + 100 < y+50)) 
				
				
				)     ) {
			AdventureManager.toon.x = x+51; AdventureManager.toon.repaint();
		}
	}
}


