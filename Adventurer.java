import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
public class Adventurer extends JLabel implements KeyListener{
	int x = 0;
	int y = 0;
	int speed = 2;
	int jumpCount = 25;
	int gravity = 3;
	public boolean plat = false, jump;
	static Inventory inven = new Inventory();
	
	public static boolean[] keyss = new boolean[256];
	static public int health = 20, maxHealth = 20;
	int jumpCounter;
	boolean jumping = false;
	ImageIcon leftImage, rightImage, run, idle;
	Timer jumpTimer, fallTimer;
	int keys;
		Adventurer(int floor, int position){
		leftImage = new ImageIcon(getClass().getClassLoader().getResource("SnowmanLeft.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource("SnowmanRight.png"));
		
		setIcon(rightImage);
		
		
		y = floor - 100;
		x = position; 
		setSize(50, 100);
		setLocation(x,y);
		setBackground(Color.red);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keyss[e.getKeyCode()] = true;
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keyss[e.getKeyCode()] = false;
		jumping=false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public boolean iskeyDown(int key) {
		return keyss[key];
	}
	public void Update() {
		
		
		if((iskeyDown(KeyEvent.VK_I)) && AdventureManager.currentRoom.t.isRunning()){
			inven.open();
		}
		if(iskeyDown(KeyEvent.VK_W)){
			jump();
		}
		if(iskeyDown(KeyEvent.VK_D)){
		 x += speed; setLocation(x,y); setIcon(rightImage);
		}
		if(iskeyDown(KeyEvent.VK_A)){
			 x -= speed; setLocation(x,y); setIcon(leftImage);
			}	
		if(iskeyDown(KeyEvent.VK_ENTER)){
			 if(AdventureManager.currentTreasure != null) {
				//AdventureManager.currentRoom.t.stop();
			 AdventureManager.currentTreasure.unlock();
				Main.window.setVisible(true);
			 }
			 if(AdventureManager.currentNPC != null) {
					AdventureManager.shop.openShop();
				 } 
			 
			}	
		if((y+100)>=AdventureManager.floorHeight) {
			jump = false;
			y= AdventureManager.floorHeight -100;
			gravity *= 0;
			jumpCount = 25;
			
		}
		else {
			gravity = 3;}
		
		y += gravity; setLocation(x,y);
		jump = false;
		}
	public void jump() {
		jump = true;
		if(jumpCount >= 0) {
			y -= speed+3 + (jumpCount/4);
			jumpCount--;
		}
	}
	
		
	}
	
