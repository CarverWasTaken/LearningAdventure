import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
public class Enemy extends JLabel{
	int x;
	 int y;
	 boolean alive = true;
	int speed = 1, level;
	JLabel mainPanel;
	 Timer time;
	int check =0;
	ImageIcon leftImage, rightImage;
	Enemy(int floor, int position, String image, int l){
		alive = true;
		level = l;
		leftImage = new ImageIcon(getClass().getClassLoader().getResource(image +"Left.png"));
		rightImage = new ImageIcon(getClass().getClassLoader().getResource(image +"Right.png"));
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
