package tdd.intervalHierarchy;

public class Interval {

	protected double min;
	
	protected double max;
	
	boolean open = false; 

	public Interval(double min, double max, boolean open) {
		this.min = min;
		this.max = max;
		this.open = open;
	}
	
	public boolean isIntersected(Interval another) {
		if (!this.open) {
			return this.isIncluded(another.min) ||
					this.isIncluded(another.max)||
					another.isIncluded(this.min);
		}
		
		if(another.min == another.max || this.min == this.max) {
			return false;
		}
		return  this.isIncluded(another.min) ||
				this.isIncluded(another.max) ||
				another.isIncluded(this.min) || 
				this.min == another.min;
	}

	protected boolean isIncluded(double value) {
		if (this.open) {
			return this.min < value && value < this.max;
		}
		return this.min <= value && value <= this.max;
	}
}
