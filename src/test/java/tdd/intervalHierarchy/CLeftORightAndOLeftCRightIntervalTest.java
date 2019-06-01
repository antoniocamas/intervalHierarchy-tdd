package tdd.intervalHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tdd.intervalHierarchy.builders.IntervalBuilder;

public class CLeftORightAndOLeftCRightIntervalTest extends IntervalTest {

	@Override
	protected List<Interval> createIntervals(
			double leftValue, double rightValue, 
			double leftValueOther, double rightValueOther) {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new IntervalBuilder().
				leftValue(leftValue).
				rightValue(rightValue).rightOpen().build());
		intervals.add(new IntervalBuilder().
				leftValue(leftValueOther).leftOpen().
				rightValue(rightValueOther).build());
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
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}	
	
	@Test
	public void testIsIntersectedEmptyIncluded() {
		List<Interval> intervals = this.createIntervals(3, 3, 1, 4);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}

	@Test
	public void testIsIntersectedOtherEmptyIncluded() {
		List<Interval> intervals = this.createIntervals(1, 4, 3, 3);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
}