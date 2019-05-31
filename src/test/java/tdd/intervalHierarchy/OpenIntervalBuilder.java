package tdd.intervalHierarchy;

public class OpenIntervalBuilder extends IntervalBuilder {
		
	OpenIntervalBuilder(){
		super();
		this.open = true;
	}
		
	@Override
	public Interval build() {
		return new Interval(this.min, this.max, this.open);
	}
}
