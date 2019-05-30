package tdd.intervalHierarchy;

public class ClosedInterval extends Interval{

	public ClosedInterval(double min, double max) {
		super(min, max);
	}

	@Override
	public boolean isIntersected(Interval another) {
		return this.isIncluded(another.min) ||
				this.isIncluded(another.max)||
				another.isIncluded(this.min);
	}

	@Override
	protected boolean isIncluded(double value) {
		return this.min <= value && value <= this.max;
	}

}
