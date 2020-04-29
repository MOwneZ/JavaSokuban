package Sokuban;

import java.awt.Point;

public class WorkerOnTarget extends Placeable {

	public WorkerOnTarget (int newX, int newY) {
		this.xAndY = new Point(newX, newY);
		this.symbol = "W";
	}
	
}
