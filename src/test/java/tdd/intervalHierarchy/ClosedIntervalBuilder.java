package tdd.intervalHierarchy;

public class ClosedIntervalBuilder extends IntervalBuilder {

	ClosedIntervalBuilder(){
		super();
	}
	
	@Override
	public Interval build() {
		return new ClosedInterval(min, max);
	}
}
