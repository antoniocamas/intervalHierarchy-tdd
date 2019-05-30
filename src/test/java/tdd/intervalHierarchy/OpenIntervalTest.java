package tdd.intervalHierarchy;

import org.junit.Test;

import junit.framework.TestCase;

public class OpenIntervalTest extends TestCase {

	@Test
	public void testIsIntersectedOverlapingByLeft() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(1).max(7).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByLeftWithEquals() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(3).max(7).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByEquals() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(3).max(14).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByRight() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(7).max(17).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByBoth() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(0).max(17).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedOverlapingByInside() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(5).max(10).build();
		assertTrue(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByLeft() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(0).max(2).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedNotOverlapingByRight() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(16).max(22).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByLeft() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(1).max(3).build();
		assertFalse(one.isIntersected(another));
	}
	
	@Test
	public void testIsIntersectedAdjacentByRight() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(14).build();
		OpenInterval another = new OpenIntervalBuilder().min(14).max(16).build();
		assertFalse(one.isIntersected(another));
	}	
	
	@Test
	public void testIsIntersectedEmptyIncluded() {
		OpenInterval one = new OpenIntervalBuilder().min(3).max(3).build();
		OpenInterval another = new OpenIntervalBuilder().min(1).max(4).build();
		assertFalse(one.isIntersected(another));
	}	
}
