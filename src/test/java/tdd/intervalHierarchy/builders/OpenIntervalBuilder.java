package tdd.intervalHierarchy.builders;

import tdd.intervalHierarchy.Interval;

public class OpenIntervalBuilder extends IntervalBuilder {
		
	public OpenIntervalBuilder(){
		super();
		this.leftOpen = true;
		this.rightOpen = true;
	}
}
