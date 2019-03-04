import javax.swing.JPanel;

public class Treasure extends JPanel{
	private boolean open;
	 int gold , x , y;
	int count;
	Treasure(int x1, int y1, int g){
		x = x1;
		y = y1;
		setSize(50,50);
		setLocation(x,y);
		open = false;
		gold = g;
		
		
	}
	public void openChest(){
		open = true;
	}
	public void update() {
		if((open==false) && ((AdventureManager.toon.x + 50 > x) && (AdventureManager.toon.x + 50 < x+50) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )
				|| ((AdventureManager.toon.x > x) && (AdventureManager.toon.x < x+50)  && (open==false) &&(AdventureManager.toon.y+98> y) &&(AdventureManager.toon.y+98< y+50) )
					
					) {
				AdventureManager.currentTreasure = this;
				count++;
			}
		else {
			if(count>0) {
				AdventureManager.currentTreasure = null;
				count = 0;
			}
		}
		
	}
}
