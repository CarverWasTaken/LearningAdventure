import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class Projectile extends JPanel {
	int speed = (int)((double)AdventureManager.currentEnemy.level*0.25)+2, current = 1020;
	Music laserSound;
	JTextField answer;
	boolean alive = true;
	public Timer t;
	Font questionFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	Projectile(int location){
		Random Rand = new Random();
		
		setBackground(Color.red);
		setSize(100, 100);
		setLocation(location, current);
		setLayout(new GridLayout(2,1));
		
		
		t = new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				current -= speed;
				setLocation(current, location);
				repaint();
				
				if(answer.isFocusOwner()) {
					answer.setBackground(Color.red);
					repaint();
				}
				if((current<130) && (alive == true) && (Combat.inCombat == true)) {
					Adventurer.health -= AdventureManager.currentEnemy.level/2;
					AdventureManager.dataPanel.setVisible(false);
					if(Adventurer.health<=0) AdventureManager.combat.lost();
					Combat.healthDisplay.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth);
					AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth + "   Gold: " + AdventureManager.gold );
					
					alive = false;
					destroy();
					
				
				}
				if(Combat.inCombat == false) {
					alive = false;
				}
				
			} 
			
		}); t.start();
		
		JTextArea question = new JTextArea();
		question.setEditable(false);
		question.setFont(questionFont);
		question.setBackground(Color.BLACK);
		question.setForeground(Color.white);
		int numOne = Rand.nextInt(9) + 1;
		int numTwo = Rand.nextInt(9) + 1;
		int result = numOne + numTwo;
		question.setText(numOne + " + " + numTwo + " = ?");
		
		add(question);
		
		
		answer = new JTextField();
		answer.setBackground(Color.black);
		answer.setForeground(Color.white);
		answer.setFont(questionFont);
		answer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(answer.getText().equals(Integer.toString(result))){
					alive = false; destroy();
				}
				else {
					answer.setText("");
				}
			}
			
			
		});
		add(answer);
		
	}
	public void destroy(){
		Combat.attacks.remove(this);
		Combat.count++;
		alive = false;
		this.setVisible(false);
		Main.window.remove(this);
	}
}
