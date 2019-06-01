package tdd.intervalHierarchy.builders;

import tdd.intervalHierarchy.Interval;

public abstract class IntervalBuilder {

	protected double leftValue;
	
	protected double rightValue;
	
	protected boolean leftOpen;
	
	protected boolean rightOpen;
	
	public IntervalBuilder(){
		this.leftValue = 0;
		this.rightValue = 1;
		this.leftOpen = false;
		this.rightOpen = false;
	}
	
	public IntervalBuilder leftValue(double value) {
		this.leftValue = value;
		return this;
	}

	public IntervalBuilder leftOpen() {
		this.leftOpen = true;
		return this;
	}
	
	public IntervalBuilder rightValue(double value) {
		this.rightValue = value;
		return this;
	}
	
	public IntervalBuilder rightOpen() {
		this.leftOpen = true;
		return this;
	}
	
	public Interval build() {
		return new Interval(this.leftValue, this.leftOpen, this.rightValue, this.rightOpen);
	}
	
}
