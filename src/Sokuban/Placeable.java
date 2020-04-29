package Sokuban;

import java.awt.Point;

public class Placeable {
	protected Point xAndY;
	protected String symbol = "";
	protected String defaultSymbol = "";
	protected Boolean hasWorker = false;
	protected Boolean hasCrate = false;
	protected Worker myWorker;
	protected Crate myCrate;
	
	public String toString() {
		return this.symbol;
	}
	
	public void addWorker(Worker newWorker) {
		this.myWorker = newWorker;
		this.hasWorker = true;
	}
	
	public void addCrate(Crate newCrate) {
		this.myCrate = newCrate;
		this.hasCrate = true;
	}
	
	public void RemoveObject() {
		this.hasWorker = false;
		this.hasCrate = false;
		this.symbol = this.defaultSymbol;
	}
	
	public void move(Direction newDirection) {
		Point newPosition = new Point((this.xAndY.x + newDirection.offset().x),(this.xAndY.y + newDirection.offset().y));
		this.xAndY = newPosition;
	}

}

