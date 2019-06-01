package tdd.intervalHierarchy;

public class EndPoint {

	protected double value;
			
	protected boolean open = false; 

	public EndPoint(double value, boolean open) {
		this.value = value;
		this.open = open;
	}
		
	public boolean isSameValue(EndPoint other) {
		return this.value == other.value;
	}
	
	protected boolean isAnyOpen(EndPoint point) {
		return this.open || point.open;
	}
	
	protected boolean areBothOpen(EndPoint point) {
		return this.open && point.open;
	}
	
	protected boolean isLeft(EndPoint point) {
		if (this.isAnyOpen(point)) {
			return this.value < point.value;
		}
		return this.value <= point.value;		
	}
	
	protected boolean isRight(EndPoint point) {
		if (this.isAnyOpen(point)) {
			return this.value > point.value;
		}
		return this.value >= point.value;
	}
}
