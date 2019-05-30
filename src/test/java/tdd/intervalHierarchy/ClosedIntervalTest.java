package tdd.intervalHierarchy;

import org.junit.Test;

import junit.framework.TestCase;

public class ClosedIntervalTest extends TestCase {

	@Test
	public void testIsIntersectedOverlapingByLeft() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(1).max(7).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByLeftWithEquals() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(3).max(7).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByEquals() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(3).max(14).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByRight() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(7).max(17).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByBoth() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(0).max(17).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByInside() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(5).max(10).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByLeft() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(0).max(2).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByRight() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(16).max(22).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByLeft() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(1).max(3).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(14).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(14).max(16).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedPointIncluded() {
		ClosedInterval one = new ClosedIntervalBuilder().min(3).max(3).build();
		ClosedInterval another = new ClosedIntervalBuilder().min(1).max(4).build();
		assertTrue(one.isIntersected(another));
	}
	
}
