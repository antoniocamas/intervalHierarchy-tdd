package tdd.intervalHierarchy;

public class ClosedIntervalBuilder extends IntervalBuilder {

	ClosedIntervalBuilder(){
		super();
		this.open = false;
	}
	
	@Override
	public Interval build() {
		return new Interval(this.min, this.max, this.open);
	}
}
