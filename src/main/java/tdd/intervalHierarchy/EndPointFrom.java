package tdd.intervalHierarchy;

public class EndPointFrom extends EndPoint {
	
	public EndPointFrom(double value, boolean open) {
		super(value, open);
	}
	
	@Override
	public boolean isLeft(EndPoint point) {
		if (this.isAnyOpen(point)) {
			return this.value < point.value;
		}
		return this.value <= point.value;
		
	}
	

}
