package tdd.intervalHierarchy;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public abstract class IntervalTest extends TestCase {

	protected abstract List<Interval> createIntervals(
			double leftValue, double rightValue, 
			double leftValueOther, double rightValueOther);
	
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
	
	//####################################
	
	@Test
	public void testIsIntersectedOverlapingInfinitePositiveOtherByLeft() {
		List<Interval> intervals = this.createIntervals(3, 14, Double.NEGATIVE_INFINITY, 7);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingInfinitePositiveOtherByBoth() {
		List<Interval> intervals = this.createIntervals(3, 14, 3, Double.POSITIVE_INFINITY);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingInfiniteOtherByBoth() {
		List<Interval> intervals = this.createIntervals(3, 14, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingInfiniteNegativeOtherByBoth() {
		List<Interval> intervals = this.createIntervals(3, 14, Double.NEGATIVE_INFINITY, 22);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingInfinitePositiveOtherByRight() {
		List<Interval> intervals = this.createIntervals(3, 14, 16, Double.POSITIVE_INFINITY);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingInfiniteNegativeAndPositiveOtherByRight() {
		List<Interval> intervals = this.createIntervals(Double.NEGATIVE_INFINITY, 14, 16, Double.POSITIVE_INFINITY);
		assertFalse(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	@Test
	public void testIsIntersectedOverlapingInfiniteNegativeBoth() {
		List<Interval> intervals = this.createIntervals(Double.NEGATIVE_INFINITY, 14, Double.NEGATIVE_INFINITY, 16);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	public void testIsIntersectedOverlapingInfinitePositiveBoth() {
		List<Interval> intervals = this.createIntervals(3, Double.POSITIVE_INFINITY, 7, Double.POSITIVE_INFINITY);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
	
	public void testIsIntersectedOverlapingAllInfinite() {
		List<Interval> intervals = this.createIntervals(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		assertTrue(intervals.get(0).isIntersected(intervals.get(1)));
	}
}
