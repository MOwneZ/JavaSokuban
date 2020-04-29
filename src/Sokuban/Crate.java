package Sokuban;

import java.awt.Point;

public class Crate extends Placeable {

	public Crate (int newX, int newY) {
		this.xAndY = new Point(newX, newY);
		this.symbol = "x";
	}
	
}
