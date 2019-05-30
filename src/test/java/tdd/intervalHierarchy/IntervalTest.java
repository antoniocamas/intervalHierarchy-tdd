package tdd.intervalHierarchy;

import org.junit.Test;

import junit.framework.TestCase;

public abstract class IntervalTest extends TestCase {

	protected abstract Interval createInterval(double min, double max);
	
	@Test
	public void testIsIntersectedOverlapingByLeft() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(1, 7);
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByLeftWithEquals() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(3, 7);
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByEquals() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(3, 14);
		assertTrue(one.isIntersected(another));
	}

	@Test
	public void testIsIntersectedOverlapingByRight() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(7, 17);
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByBoth() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(3, 17);
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByInside() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(5, 10);
		assertTrue(one.isIntersected(another));
	}

	@Test
	public void testIsIntersectedNotOverlapingByLeft() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(0, 2);
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByRight() {
		Interval one = this.createInterval(3, 14);
		Interval another = this.createInterval(16, 22);
		assertFalse(one.isIntersected(another));
	}
}
