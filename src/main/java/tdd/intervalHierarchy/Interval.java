package tdd.intervalHierarchy;

public class Interval {

	private double min;
	
	private double max;
	
	private boolean open = false;
	
	private EndPoint endPointMin;
	
	private EndPoint endPointMax;

	public Interval(double min, double max, boolean open) {
		this.min = min;
		this.max = max;
		this.open = open;
		this.endPointMin = new EndPoint(min, open);
		this.endPointMax = new EndPoint(max, open);
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
		return this.endPointMin.isSmaller(value) && this.endPointMax.isBigger(value);
	}
}
