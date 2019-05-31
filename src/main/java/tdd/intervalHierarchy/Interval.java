package tdd.intervalHierarchy;

public class Interval {

	private boolean open = false;
	
	private EndPoint endPointMin;
	
	private EndPoint endPointMax;

	public Interval(double min, double max, boolean open) {
		this.open = open;
		this.endPointMin = new EndPointFrom(min, open);
		this.endPointMax = new EndPointUntil(max, open);
	}
	
	public boolean isIntersected(Interval another) {
		if (this.isEmpty() || another.isEmpty()) {
			return false;
		}
		if (this.endPointMin.isLeft(another.endPointMin) && this.endPointMax.isRight(another.endPointMin)) {
			return true;
		}
		if (this.endPointMax.isRight(another.endPointMax) && this.endPointMin.isLeft(another.endPointMax)) {
			return true;
		}
		if (another.endPointMin.isLeft(this.endPointMin) && another.endPointMax.isRight(this.endPointMin)) {
			return true;
		}
		if (another.endPointMax.isRight(this.endPointMax) && another.endPointMin.isLeft(this.endPointMax)) {
			return true;
		}
				
		return this.isEqual(another);
	}

	private boolean isEqual(Interval other) {
		return this.endPointMin.isEqual(other.endPointMin) && this.endPointMax.isEqual(other.endPointMax);
	}
	
	private boolean isEmpty() {
		return this.endPointMin.isEqual(this.endPointMax) && this.open;
	}
	
	private boolean isIncluded(EndPoint other) {
		return this.endPointMin.isSmaller(other) && this.endPointMax.isBigger(other);
	}
}
