package tdd.intervalHierarchy;

public class OpenIntervalBuilder extends IntervalBuilder {
		
	OpenIntervalBuilder(){
		super();
	}
		
	@Override
	public Interval build() {
		return new OpenInterval(min, max);
	}
}
