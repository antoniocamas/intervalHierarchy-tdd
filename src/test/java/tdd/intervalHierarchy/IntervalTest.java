package tdd.intervalHierarchy;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public abstract class IntervalTest extends TestCase {

	protected abstract Interval createInterval(double min, double max);
	
	protected abstract List<Interval> createIntervals(double min, double max, double minOther, double maxOther);
	
	@Test
	public void testIsIntersectedOverlapingByLeft() {
		List<Interval> intervals = this.createIntervals(3, 14, 1, 7);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingByLeftWithEquals() {
		List<Interval> intervals = this.createIntervals(3, 14, 3, 7);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingByEquals() {
		List<Interval> intervals = this.createIntervals(3, 14, 3, 14);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}

	@Test
	public void testIsIntersectedOverlapingByRight() {
		List<Interval> intervals = this.createIntervals(3, 14, 7, 17);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingByBoth() {
		List<Interval> intervals = this.createIntervals(3, 14, 3, 17);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingByInside() {
		List<Interval> intervals = this.createIntervals(3, 14, 5, 10);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}

	@Test
	public void testIsIntersectedNotOverlapingByLeft() {
		List<Interval> intervals = this.createIntervals(3, 14, 0, 2);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByRight() {
		List<Interval> intervals = this.createIntervals(3, 14, 16, 22);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
}
