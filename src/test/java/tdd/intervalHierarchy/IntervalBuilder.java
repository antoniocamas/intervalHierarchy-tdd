package tdd.intervalHierarchy;

public abstract class IntervalBuilder {

	protected double min;
	
	protected double max;
	
	protected boolean open;
	
	public IntervalBuilder(){
		this.min = 0;
		this.max = 1;
		this.open = false;
	}
	
	public IntervalBuilder min(double min) {
		this.min = min;
		return this;
	}

	public IntervalBuilder max(double max) {
		this.max = max;
		return this;
	}
	
	abstract public Interval build();
	
}
