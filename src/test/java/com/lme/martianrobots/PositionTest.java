package com.lme.martianrobots;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testFromInputOk() {
		
		Position position = Position.fromInput("3 2 N");
		
		assertNotNull(position);
		assertNotNull(position.getCoordinates());
		
		assertEquals(3, position.getCoordinates().x);
		assertEquals(2, position.getCoordinates().y);
		
		assertEquals(Orientation.N, position.getOrientation());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromInputFailedDueToInvalidInput() {
		
		Position.fromInput("abc");
	}
	
	@Test
	public void testEquals() {
		
		Position pos1 = Position.fromInput("3 2 N");
		Position pos2 = new Position(new Point(3, 2), Orientation.N);
		
		assertEquals(pos1, pos2);
	}
	
	@Test
	public void testNotEquals() {
		
		Position pos1 = Position.fromInput("3 2 N");
		Position pos2 = new Position(new Point(2, 3), Orientation.S);
		
		assertNotEquals(pos1, pos2);
	}
	
	// TODO: More tests
}
