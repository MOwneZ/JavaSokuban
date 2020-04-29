package Sokuban;

import java.util.ArrayList;
import java.util.List;

public class Game {
	protected List<Level> allMyLevels = new ArrayList<Level>();
	protected List<String> levelNames = new ArrayList<String>();
	protected String currentLevelName = "no levels";
	protected Level currentLevel;
	
	public void addLevel(String newLevelName, int newHeight, int newWidth, String newLevel) {
		Level level = new Level(newLevelName, newHeight, newWidth, newLevel);
		this.currentLevel = level;
		this.allMyLevels.add(level);
		this.levelNames.add(newLevelName);
		this.currentLevelName = newLevelName;
	}
	
	public void move(Direction newDirection) {
		this.currentLevel.moveCount++;
		this.currentLevel.move(newDirection);
	}
	
	public String toString() {
		if (this.currentLevel == null) {
			return "no levels";
		}
		return this.currentLevel.toString();
	}
	
	public int getLevelCount() {
		return this.allMyLevels.size();
	}
	
	public String getCurrentLevelName() {
		return this.currentLevelName;
	}
	
	public List<String> getLevelNames() {
		return this.levelNames;
	}
}
