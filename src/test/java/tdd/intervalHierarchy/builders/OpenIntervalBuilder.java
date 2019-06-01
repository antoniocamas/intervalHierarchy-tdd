package tdd.intervalHierarchy.builders;

public class OpenIntervalBuilder extends IntervalBuilder {
		
	public OpenIntervalBuilder(){
		super();
		this.leftOpen = true;
		this.rightOpen = true;
	}
}
