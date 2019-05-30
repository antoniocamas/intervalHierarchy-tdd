package tdd.intervalHierarchy;

public abstract class Interval {

	protected double min;
	
	protected double max;

	public Interval(double min, double max) {
		this.min = min;
		this.max = max;
	}

	
	public abstract boolean isIntersected(Interval i);

	protected abstract boolean isIncluded(double d);
}
