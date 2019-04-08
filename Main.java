import javax.swing.JFrame;
public class Main {
	public static JFrame window;
	AdventureManager manager;
	public static void main(String[] args) {
		new Main();

	}
	Main(){
		window = new JFrame("Learning Adventure"); //Generating main window, using JFrame 
		window.setSize(1200, 800);
		window.setLayout(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		manager = new AdventureManager();
		manager.createSpace();
		
		Item tastyApple = new Item(
				"Tasty Apple",
				"Item",
				"This is a yummy looking apple! If you eat it, the tasty fruit could probably heal you!",
				5
				);
		
		Item tastySquash = new Item(
				"Tasty Squash",
				"Item",
				"This is a yummy looking squash! If you eat it, the tasty fruit could probably heal you!",
				10
				);
		
	
		Item mechanicalEraser = new Item(
				"Mechanical Eraser",
				"Armor",
				"This mechanical eraser helps defend against math-based attacks!",
				20
				);
		
//		Inventory.addItem(tastyApple);
//		Inventory.addItem(tastyApple);
//		Inventory.addItem(tastyApple);
//		Inventory.addItem(tastyApple);
//		Inventory.addItem(tastyApple);
//		Inventory.addItem(tastySquash);
		
		Inventory.addItem(new Item(
				"Pencil Eraser",
				"Armor",
				"This eraser helps defend against math-based attacks!",
				10
				));
		Inventory.addItem(new Item(
				"Pencil Eraser",
				"Armor",
				"This eraser helps defend against math-based attacks!",
				10
				));
		Inventory.addItem(new Item(
				"Pencil Eraser",
				"Armor",
				"This eraser helps defend against math-based attacks!",
				10
				));
		Inventory.addItem(mechanicalEraser);
		
		
	}
	
}
