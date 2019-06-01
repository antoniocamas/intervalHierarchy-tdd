package tdd.intervalHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import tdd.intervalHierarchy.builders.OpenIntervalBuilder;

public class OpenIntervalTest extends IntervalTest {

	protected Interval createInterval(double leftValue, double rightValue) {
		return new OpenIntervalBuilder().leftValue(leftValue).rightValue(rightValue).build();
	}
	
	@Override
	protected List<Interval> createIntervals(double leftValue, double rightValue, double leftValueOther, double rightValueOther) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(this.createInterval(leftValue, rightValue));
		intervals.add(this.createInterval(leftValueOther, rightValueOther));
		return intervals;
	}
	
	@Test
	public void testIsIntersectedAdjacentByLeft() {
		List<Interval> intervals = this.createIntervals(3, 14, 1, 3);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		List<Interval> intervals = this.createIntervals(3, 14, 14, 16);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}	
	
	@Test
	public void testIsIntersectedEmptyIncluded() {
		List<Interval> intervals = this.createIntervals(3, 3, 1, 4);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}

	@Test
	public void testIsIntersectedOtherEmptyIncluded() {
		List<Interval> intervals = this.createIntervals(1, 4, 3, 3);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
}
