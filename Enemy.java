import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
public class Enemy extends JLabel{
	int x;
	 int y;
	 boolean alive = true;
	 String name;
	int speed = 1, level;
	JLabel mainPanel;
	 Timer time;
	int check =0;
	ImageIcon leftImage, rightImage;
	Enemy(int floor, int position, String n, int l){
		name = n;
		alive = true;
		level = l;
		leftImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Left.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource(n +"Right.png"));
		setIcon(rightImage);
		
			y = floor - 100;
			x = position; 
			setSize(50, 100);
			setLocation(x,y);
			setBackground(Color.red);
			
			
			
		}
	public void Update() {
		//COLLISION
		
		if((alive==true) && ((AdventureManager.toon.x + 50 > x) && (AdventureManager.toon.x + 50 < x+50) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+100) )
			|| ((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50)  && (alive==true) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+100) )
				
				) {
			setVisible(false);
			AdventureManager.currentEnemy = this;
			AdventureManager.combat.enterMenu();
			AdventureManager.mainPanel.remove(this);
			alive=false;
		}
		Random rand = new Random();
		int moveNum = rand.nextInt(100)+100;
		check++;
		if(check >= moveNum) {
			speed = speed*-1;
			check =0;
			
		}
		
		if(speed > 0) {
			setIcon(rightImage);
		}
		else {
			setIcon(leftImage);
		}
		x += speed; setLocation(x,y); repaint();
	}
	
}
