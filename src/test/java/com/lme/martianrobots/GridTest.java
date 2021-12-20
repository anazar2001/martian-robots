package com.lme.martianrobots;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	
	private Grid grid;
	
	@Before
	public void beforeTest() {
		
		grid = new Grid();
	}

	@Test
	public void testInitOk() {
		
		grid.init("5 7");
		
		assertEquals(6, grid.getWidth());
		assertEquals(8, grid.getHeight());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromInitFailedDueToInvalidInput() {
		
		grid.init("abc");
	}
	
	// TODO: More tests
}
