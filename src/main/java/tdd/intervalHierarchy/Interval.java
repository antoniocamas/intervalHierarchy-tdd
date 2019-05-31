package tdd.intervalHierarchy;

public abstract class Interval {

	protected double min;
	
	protected double max;
	
	boolean open = false; 

	public Interval(double min, double max, boolean open) {
		this.min = min;
		this.max = max;
		this.open = open;
	}

	
	public abstract boolean isIntersected(Interval i);

	protected boolean isIncluded(double value) {
		if (this.open) {
			return this.min < value && value < this.max;
		}
		return this.min <= value && value <= this.max;
	}
}
