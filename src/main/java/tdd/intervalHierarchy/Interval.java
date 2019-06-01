package tdd.intervalHierarchy;

public class Interval {
		
	private EndPoint endPointLeft;
	
	private EndPoint endPointRight;

	public Interval(double leftValue, boolean leftOpen, double rightValue, boolean rightOpen) {
		this.endPointLeft = new EndPointFrom(leftValue, leftOpen);
		this.endPointRight = new EndPointUntil(rightValue, rightOpen);
	}
	
	public boolean isIntersected(Interval another) {
		if (this.isEmpty() || another.isEmpty()) {
			return false;
		}
		if (this.endPointLeft.isLeft(another.endPointLeft) && this.endPointRight.isRight(another.endPointLeft)) {
			return true;
		}
		if (this.endPointRight.isRight(another.endPointRight) && this.endPointLeft.isLeft(another.endPointRight)) {
			return true;
		}
		if (another.endPointLeft.isLeft(this.endPointLeft) && another.endPointRight.isRight(this.endPointLeft)) {
			return true;
		}
		if (another.endPointRight.isRight(this.endPointRight) && another.endPointLeft.isLeft(this.endPointRight)) {
			return true;
		}
				
		return this.isEqual(another);
	}

	private boolean isEqual(Interval other) {
		return this.endPointLeft.isEqual(other.endPointLeft) && this.endPointRight.isEqual(other.endPointRight);
	}
	
	private boolean isEmpty() {
		return this.endPointLeft.isEqual(this.endPointRight) && 
				this.endPointLeft.areBothOpen(this.endPointRight);
	}	
}
