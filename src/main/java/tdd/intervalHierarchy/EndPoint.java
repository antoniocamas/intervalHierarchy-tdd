package tdd.intervalHierarchy;

public class EndPoint {

	private double value;
			
	private boolean open = false; 

	public EndPoint(double value, boolean open) {
		this.value = value;
		this.open = open;
	}
		
	public boolean isSameValue(EndPoint other) {
		return this.value == other.value;
	}
	
	public boolean isAnyOpen(EndPoint point) {
		return this.open || point.open;
	}
	
	public boolean areBothOpen(EndPoint point) {
		return this.open && point.open;
	}
	
	public boolean isLeft(EndPoint point) {
		if (this.isAnyOpen(point)) {
			return this.value < point.value;
		}
		return this.value <= point.value;		
	}
	
	public boolean isRight(EndPoint point) {
		return point.isLeft(this);
	}
}
