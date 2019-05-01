import javax.swing.JFrame;
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
		
		Inventory.addItem(new Item(
				"Pencil Eraser",
				"Armor",
				"This eraser helps defend against math-based attacks!",
				10
				));
		Inventory.addItem(new Item(
				"Tasty Apple",
				"Item",
				"This is a yummy looking apple! If you eat it, the tasty fruit could probably heal you!",
				5
				));
		
		
	}
	
}
