package tdd.intervalHierarchy;

public class Interval {
		
	private EndPoint endPointLeft;
	
	private EndPoint endPointRight;

	public Interval(
			double leftValue, boolean leftOpen, 
			double rightValue, boolean rightOpen) {
		
		this.endPointLeft = new EndPoint(leftValue, leftOpen);
		this.endPointRight = new EndPoint(rightValue, rightOpen);
	}
	
	public boolean isIntersected(Interval another) {
		if (this.isEmpty() || another.isEmpty()) {
			return false;
		}
		
		if (this.isIntersectedbyOneSide(another)||
				another.isIntersectedbyOneSide(this)) {
			return true;
		}
		
		return this.haveSameValues(another);
	}

	private boolean isIntersectedbyOneSide(Interval another) {
		if (this.isIncluded(another.endPointLeft) || 
				another.isIncluded(this.endPointRight)) {
			return true;
		}
		
		return false;
	}
	
	private boolean isIncluded(EndPoint point) {
		return this.endPointLeft.isLeft(point) &&
				this.endPointRight.isRight(point);
	}
	
	private boolean haveSameValues(Interval other) {
		return this.endPointLeft.isSameValue(other.endPointLeft) &&
				this.endPointRight.isSameValue(other.endPointRight);
	}
	
	private boolean isEmpty() {
		return this.endPointLeft.isSameValue(this.endPointRight) && 
				this.endPointLeft.areBothOpen(this.endPointRight);
	}	
}
