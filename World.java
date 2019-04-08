import java.util.ArrayList;
import java.util.List;

/**
 * JavaBean representing a game world which consists of a list of rooms.
 *
 */
public class World {
	private List<WorldRoom> rooms = new ArrayList<WorldRoom>();

	public List<WorldRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<WorldRoom> rooms) {
		this.rooms.clear();
		this.rooms.addAll(rooms);
	}

	/**
	 * If the original classes were written following JavaBean conventions, then it wouldn't be necessary to 
	 * have a parallel data model for YAML deserialization, and the following code would not be needed.
	 */
	public List<Room> buildRooms() {
		List<Room> list = new ArrayList<Room>();
		for (WorldRoom r : getRooms()) {
			Room room = new Room(r.getBackground());
			for (WorldPlatform p : r.getPlatforms()) {
				room.addPlatform(new Platform(p.getX(), p.getY()));
			}
			for (WorldNPC n : r.getNpcs()) {
				room.addNPC(new NPC(n.getX(), n.getDialogue()));
			}
			for (WorldTreasure t : r.getChests()) {
				room.addChest(new Treasure(t.getX(), t.getY(), t.getGold()));
			}
			for (WorldRobot e : r.getEnemies()) {
				// TODO the constructor for Robot is weird and should be changed to take the normal X, Y coordinates
				room.addEnemies(new Robot(AdventureManager.floorHeight, e.getX()));
			}
			list.add(room);
		}
		
		for (int i = 0; i < list.size(); ++i) {
			if (i > 0) {
				list.get(i).addLeftRoom(list.get(i - 1));
			}
			if (i < list.size() - 1) {
				list.get(i).addRightRoom(list.get(i + 1));
			}
		}
		
		return  list;
	}
}
