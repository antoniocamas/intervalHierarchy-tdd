package tdd.intervalHierarchy;

public class ClosedInterval {

	private double min;
	
	private double max;

	public ClosedInterval(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public boolean isIntersected(ClosedInterval another) {
		return this.isIncluded(another.min) ||
				this.isIncluded(another.max)||
				another.isIncluded(this.min);
	}

	private boolean isIncluded(double value) {
		return this.min <= value && value <= this.max;
	}

}
