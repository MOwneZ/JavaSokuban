package Sokuban;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Level {
	protected String levelName = "";
	protected String level = "no level";
	protected int moveCount;
	protected int completedCount = 0;
	public int targetCount = 0;
	protected int height;
	protected int width;
	protected Worker theWorker;
	protected List<Placeable> gameData = new ArrayList<Placeable>();
	public String test = "";

	public Level(String newLevelName, int newHeight, int newWidth, String newLevel) {
		this.levelName = newLevelName;
		this.height = newHeight;
		this.width = newWidth;
		this.setGameData(newLevel);
		this.countTargets();
	}

	public String toString() {
		String output = this.levelName + "\n";
		int pos = 0;
		for (int i = 0; i <= this.height - 1; i++) {
			for (int z = 0; z <= this.width - 1; z++, pos++) {
				output += this.level.charAt(pos);
			}
			output += "\n";
		}
		output += "move " + this.moveCount + "\n";
		output += "completed " + this.completedCount + " of " + this.targetCount + "\n";;
		return output;
	}

	private void setGameData(String newLevel) {
		int pos = 0;
		for (int i = 0; i <= this.height - 1; i++) {
			for (int z = 0; z <= this.width - 1; z++, pos++) {
				this.addPlaceable(newLevel.charAt(pos), z, i);
			}
		}
		this.level = this.formatGameData(this.gameData);
	}

	public void move(Direction newDirection) {
		Point newWorkerPos = getPotentialMove(newDirection.offset());
		for (Placeable p : this.gameData) {
			if (p.xAndY.equals(newWorkerPos)) {
				if (p.symbol == "." || p.symbol == "+") {
					p.addWorker(this.theWorker);
					this.clearPreviousPos();
					this.theWorker.xAndY = newWorkerPos;
				}
				if (p.symbol == "x") {
					p.addWorker(this.theWorker);
					this.clearPreviousPos();
					this.theWorker.xAndY = newWorkerPos;
					this.pushCrate(newDirection.offset());
				}
			}
		}
		this.level = this.formatGameData(this.gameData);
	}

	private void pushCrate(Point newDirection) {
		Crate theCrate = new Crate(0,0);
		Point newCratePos = this.getPotentialMove(newDirection);
		for(Placeable p : this.gameData) {
			if (p.xAndY.equals(newCratePos)) {
				if (p.symbol == "+") {
					p.addCrate(theCrate);
					this.completedCount++;
				}
				if (p.symbol == ".") {
					p.addCrate(theCrate);
				}
			}
		}
	}

	private Point getPotentialMove(Point newDirection) {
		Point a = new Point(newDirection);
		Point b = this.theWorker.xAndY;
		Point newPos = new Point(a.x + b.x, a.y + b.y);
		return newPos;
	}

	private void clearPreviousPos() {
		for (Placeable p : this.gameData) {
			if (p.symbol == "w" || p.symbol == "W") {
				p.RemoveObject();
			}
		}
	}

	private void addPlaceable(char newPlaceable, int newX, int newY) {
		if (newPlaceable == '#') {
			Wall theWall = this.createWall(newX, newY);
			this.gameData.add(theWall);
		}
		if (newPlaceable == '.') {
			Empty theEmpty = this.createEmpty(newX, newY);
			this.gameData.add(theEmpty);
		}
		if (newPlaceable == '+') {
			Target theTarget = this.createTarget(newX, newY);
			this.gameData.add(theTarget);
		}
		if (newPlaceable == 'w') {
			Empty theWorkerOnEmpty = this.createWorkerOnEmpty(newX, newY);
			this.gameData.add(theWorkerOnEmpty);
		}
		if (newPlaceable == 'W') {
			WorkerOnTarget theWorkerOnTarget = this.createWorkerOnTarget(newX, newY);
			this.gameData.add(theWorkerOnTarget);
		}
		if (newPlaceable == 'x') {
			Empty theCrateOnEmpty = this.createCrateOnEmpty(newX, newY);
			this.gameData.add(theCrateOnEmpty);
		}
	}

	private String formatGameData(List<Placeable> theGameData) {
		String output = theGameData.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
		return output;
	}

	private Wall createWall(int newX, int newY) {
		return new Wall(newX, newY);
	}

	private Empty createEmpty(int newX, int newY) {
		return new Empty(newX, newY);
	}

	private Target createTarget(int newX, int newY) {
		return new Target(newX, newY);
	}

	private Empty createWorkerOnEmpty(int newX, int newY) {
		Empty theWorkerOnEmpty = new Empty(newX, newY);
		Worker theWorker = new Worker(newX, newY);
		this.theWorker = theWorker;
		theWorkerOnEmpty.addWorker(theWorker);
		return theWorkerOnEmpty;
	}

	private Empty createCrateOnEmpty(int newX, int newY) {
		Empty theCrateOnEmpty = new Empty(newX, newY);
		Crate theCrate = new Crate(newX, newY);
		theCrateOnEmpty.addCrate(theCrate);
		return theCrateOnEmpty;
	}

	private WorkerOnTarget createWorkerOnTarget(int newX, int newY) {
		return new WorkerOnTarget(newX, newY);
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	public String getName() {
		return this.levelName;
	}

	public int getCompletedCount() {
		return this.completedCount;
	}

	private void countTargets() {
		this.targetCount = this.level.length() - this.level.replace("+", "").length();
	}

	public int getTargetCount() {
		return this.targetCount;
	}
}
