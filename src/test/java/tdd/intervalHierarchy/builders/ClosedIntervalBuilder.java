package tdd.intervalHierarchy.builders;

public class ClosedIntervalBuilder extends IntervalBuilder {

	public ClosedIntervalBuilder(){
		super();
		this.leftOpen = false;
		this.rightOpen = false;
	}
}
