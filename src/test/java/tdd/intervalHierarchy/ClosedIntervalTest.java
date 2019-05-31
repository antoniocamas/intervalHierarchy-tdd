package tdd.intervalHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class ClosedIntervalTest extends IntervalTest {

	@Override
	protected Interval createInterval(double min, double max) {
		return new ClosedIntervalBuilder().min(min).max(max).build();
	}

	@Override
	protected List<Interval> createIntervals(double min, double max, double minOther, double maxOther) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(this.createInterval(min, max));
		intervals.add(this.createInterval(minOther, maxOther));
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

}
