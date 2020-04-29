package Sokuban;

import java.awt.Point;

public class Target extends Placeable {

	public Target (int newX, int newY) {
		this.xAndY = new Point(newX, newY);
		this.symbol = "+";
		this.defaultSymbol = "+";
	}
	
	public String toString() {
		if (this.hasWorker) {
			return this.symbol = "W";
		}
		if (this.hasCrate) {
			return this.symbol = "X";
		}
		return this.symbol;
	}
}
