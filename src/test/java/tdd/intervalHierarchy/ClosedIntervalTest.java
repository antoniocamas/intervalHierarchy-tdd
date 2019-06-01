package tdd.intervalHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import tdd.intervalHierarchy.builders.ClosedIntervalBuilder;

public class ClosedIntervalTest extends IntervalTest {

	@Override
	protected Interval createInterval(double leftValue, double rightValue) {
		return new ClosedIntervalBuilder().leftValue(leftValue).rightValue(rightValue).build();
	}

	@Override
	protected List<Interval> createIntervals(
			double leftValue, double rightValue,
			double leftValueOther, double rightValueOther) {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(this.createInterval(leftValue, rightValue));
		intervals.add(this.createInterval(leftValueOther, rightValueOther));
		return intervals;
	}
	
	@Test
	public void testIsIntersectedAdjacentByLeft() {
		List<Interval> intervals = this.createIntervals(3, 14, 1, 3);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		List<Interval> intervals = this.createIntervals(3, 14, 14, 16);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedPointIncluded() {
		List<Interval> intervals = this.createIntervals(3, 3, 1, 4);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}

	@Test
	public void testIsIntersectedOtherPointIncluded() {
		List<Interval> intervals = this.createIntervals(1, 4, 3, 3);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedTwoPointIncluded() {
		List<Interval> intervals = this.createIntervals(3, 3, 3, 3);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
}
