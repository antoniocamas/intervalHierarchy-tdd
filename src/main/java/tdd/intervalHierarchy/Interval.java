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
			return this.isIncluded(another.endPointMin) ||
					this.isIncluded(another.endPointMax)||
					another.isIncluded(this.endPointMin);
		}
		
		if(another.endPointMin.isEqual(another.endPointMax) ||
				this.endPointMin.isEqual(this.endPointMax))    {
			return false;
		}
		
		return  this.isIncluded(another.endPointMin) ||
				this.isIncluded(another.endPointMax) ||
				another.isIncluded(this.endPointMin) ||
				this.endPointMin.isEqual(another.endPointMin);
				
	}

	private boolean isIncluded(double value) {
		return this.endPointMin.isSmaller(value) && this.endPointMax.isBigger(value);
	}
	
	private boolean isIncluded(EndPoint other) {
		return this.endPointMin.isSmaller(other.value) && this.endPointMax.isBigger(other.value);
	}
}
