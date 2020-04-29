package Sokuban;

import java.awt.Point;

public class Worker extends Placeable {
	
	public Worker (int newX, int newY) {
		this.symbol = "w";
		this.xAndY = new Point(newX, newY);
	}
	
	public void setPos(Point newPos) {
		this.xAndY = newPos;
	}
	
	public Point getPos() {
		return this.xAndY;
	}
	
}
