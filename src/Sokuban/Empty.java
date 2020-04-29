package Sokuban;

import java.awt.Point;

public class Empty extends Placeable {
	
	public Empty(int newX, int newY) {
		this.xAndY = new Point(newX, newY);
		this.symbol = ".";
		this.defaultSymbol = ".";
	}
	
	public String toString() {
		if (this.hasWorker) {
			return this.symbol = "w";
		}
		if (this.hasCrate) {
			return this.symbol = "x";
		}
		return this.symbol;
	}
}
