package tdd.intervalHierarchy;

public abstract class EndPoint {

	protected double value;
			
	protected boolean open = false; 

	public EndPoint(double value, boolean open) {
		this.value = value;
		this.open = open;
	}
		
	public boolean isSmaller(EndPoint other) {
		if (this.open) {
			return this.value < other.value;
		}
		return this.value <= other.value;
	}
	
	public boolean isBigger(EndPoint other) {
		if (this.open) {
			return this.value > other.value;
		}
		return this.value >= other.value;
	}
	
	public boolean isEqual(EndPoint other) {
		return this.value == other.value;
	}
	
	protected boolean isAnyOpen(EndPoint point) {
		return this.open || point.open;
	}
	
	protected boolean isLeft(EndPoint point) {
		return false;
	}
	
	protected boolean isRight(EndPoint point) {
		return false;
	}
}
