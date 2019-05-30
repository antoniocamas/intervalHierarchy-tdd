package tdd.intervalHierarchy;

import org.junit.Test;

import junit.framework.TestCase;

public class OpenIntervalTest extends IntervalTest {

	@Override
	protected Interval createInterval(double min, double max) {
		return new OpenIntervalBuilder().min(min).max(max).build();
	}
		
	@Test
	public void testIsIntersectedAdjacentByLeft() {
		Interval one = new OpenIntervalBuilder().min(3).max(14).build();
		Interval another = new OpenIntervalBuilder().min(1).max(3).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		Interval one = new OpenIntervalBuilder().min(3).max(14).build();
		Interval another = new OpenIntervalBuilder().min(14).max(16).build();
		assertFalse(one.isIntersected(another));
	}	
	
	@Test
	public void testIsIntersectedEmptyIncluded() {
		Interval one = new OpenIntervalBuilder().min(3).max(3).build();
		Interval another = new OpenIntervalBuilder().min(1).max(4).build();
		assertFalse(one.isIntersected(another));
	}	
}
