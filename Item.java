import java.util.Random;

public class Item {
 String name, type, description; 
 int value;
 Random rand = new Random();
 int id;
 
 Item(String n, String t, String d, int v){
	 name = n;
	 type = t;
	 description = d;
	 value = v;
 }
}
