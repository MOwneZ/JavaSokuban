package Sokuban;

import java.awt.Point;

public class Wall extends Placeable {

	public Wall (int newX, int newY) {
		this.xAndY = new Point(newX, newY);
		this.symbol = "#";
	}
	
}
