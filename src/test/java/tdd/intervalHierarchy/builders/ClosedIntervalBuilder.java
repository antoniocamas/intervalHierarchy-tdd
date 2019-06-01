package tdd.intervalHierarchy.builders;

import tdd.intervalHierarchy.Interval;

public class ClosedIntervalBuilder extends IntervalBuilder {

	public ClosedIntervalBuilder(){
		super();
		this.leftOpen = false;
		this.rightOpen = false;
	}
}
