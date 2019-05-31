package tdd.intervalHierarchy;

public class EndPointUntil extends EndPoint {

	public EndPointUntil(double value, boolean open) {
		super(value, open);
	}
	
	@Override
	public boolean isRight(EndPoint point) {
		if (this.isAnyOpen(point)) {
			return this.value > point.value;
		}
		return this.value >= point.value;
	}
}
