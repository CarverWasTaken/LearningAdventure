import java.util.ArrayList;
import java.util.List;

/**
 * JavaBean representing a room in the game world
 *
 */
public class WorldRoom {
	private String background;
	private List<WorldTreasure> chests = new ArrayList<WorldTreasure>();
	private List<WorldNPC> npcs = new ArrayList<WorldNPC>();
	private List<WorldPlatform> platforms = new ArrayList<WorldPlatform>();
	private List<WorldRobot> enemies = new ArrayList<WorldRobot>();

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<WorldTreasure> getChests() {
		return chests;
	}

	public void setChests(List<WorldTreasure> chests) {
		this.chests = chests;
	}

	public List<WorldNPC> getNpcs() {
		return npcs;
	}

	public void setNpcs(List<WorldNPC> npcs) {
		this.npcs = npcs;
	}

	public List<WorldPlatform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<WorldPlatform> platforms) {
		this.platforms = platforms;
	}

	public List<WorldRobot> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<WorldRobot> enemies) {
		this.enemies = enemies;
	}
}
