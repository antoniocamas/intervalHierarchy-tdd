package tdd.intervalHierarchy;

public abstract class EndPoint {

	protected double value;
			
	protected boolean open = false; 

	public EndPoint(double value, boolean open) {
		this.value = value;
		this.open = open;
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
