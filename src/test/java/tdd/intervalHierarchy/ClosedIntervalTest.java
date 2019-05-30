package tdd.intervalHierarchy;

import org.junit.Test;

import junit.framework.TestCase;

public class ClosedIntervalTest extends IntervalTest {

	@Override
	protected Interval createInterval(double min, double max) {
		return new ClosedIntervalBuilder().min(min).max(max).build();
	}
	

		@Test
	public void testIsIntersectedAdjacentByLeft() {
		Interval one = new ClosedIntervalBuilder().min(3).max(14).build();
		Interval another = new ClosedIntervalBuilder().min(1).max(3).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		Interval one = new ClosedIntervalBuilder().min(3).max(14).build();
		Interval another = new ClosedIntervalBuilder().min(14).max(16).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedPointIncluded() {
		Interval one = new ClosedIntervalBuilder().min(3).max(3).build();
		Interval another = new ClosedIntervalBuilder().min(1).max(4).build();
		assertTrue(one.isIntersected(another));
	}

}
