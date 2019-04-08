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

public class Projectile extends JPanel {
	int speed =1, current = 1020;
	Music laserSound;
	JTextField answer;
	boolean alive = true;
	public static Timer t;
	Font questionFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	Projectile(int location){
		Random Rand = new Random();
		
		setBackground(Color.red);
		setSize(100, 100);
		setLocation(location, current);
		setLayout(new GridLayout(2,1));
		
		
		t = new Timer(5, new ActionListener() {
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
					Adventurer.health -= Combat.enemyDamage;
					Combat.healthDisplay.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth);
					AdventureManager.healthInfo.setText("Health: " + Adventurer.health + "/" + Adventurer.maxHealth);
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
				if(Integer.parseInt(answer.getText()) + 0 == result) {
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
		Combat.count++;
		alive = false;
		this.setVisible(false);
		Main.window.remove(this);
	}
}
