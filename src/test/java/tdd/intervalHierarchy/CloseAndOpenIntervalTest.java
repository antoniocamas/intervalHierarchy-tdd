package tdd.intervalHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import tdd.intervalHierarchy.builders.ClosedIntervalBuilder;
import tdd.intervalHierarchy.builders.OpenIntervalBuilder;

public class CloseAndOpenIntervalTest extends IntervalTest {

	@Override
	protected Interval createInterval(double min, double max) {
		return new OpenIntervalBuilder().leftValue(min).rightValue(max).build();
	}
	
	@Override
	protected List<Interval> createIntervals(double min, double max, double minOther, double maxOther) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new ClosedIntervalBuilder().leftValue(minOther).rightValue(maxOther).build());
		intervals.add(new OpenIntervalBuilder().leftValue(min).rightValue(max).build());
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
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
}