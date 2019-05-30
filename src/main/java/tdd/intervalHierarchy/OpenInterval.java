package tdd.intervalHierarchy;

public class OpenInterval extends Interval{

	public OpenInterval(double min, double max) {
		super(min, max);
	}
	
	@Override
	public boolean isIntersected(Interval another) {
		if(another.min == another.max || this.min == this.max) {
			return false;
		}
		return this.isIncluded(another.min) ||
				this.isIncluded(another.max)||
				another.isIncluded(this.min) || this.min == another.min;
	}

	@Override
	protected boolean isIncluded(double value) {
		return this.min < value && value < this.max;
	}

}

