package com.lme.martianrobots.instruction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lme.martianrobots.Position;

public class MoveForwardInstructionTest {
	
	private Instruction instruction;
	
	@Before
	public void beforeTest() {
		
		instruction = new MoveForwardInstruction();
	}

	@Test
	public void testFollowNorth() {
		
		Position position = Position.fromInput("3 2 N");		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 3 N"), position);
	}
	
	@Test
	public void testFollowWest() {
		
		Position position = Position.fromInput("3 2 W");		
		instruction.follow(position);
		assertEquals(Position.fromInput("2 2 W"), position);
	}
	
	@Test
	public void testFollowSouth() {
		
		Position position = Position.fromInput("3 2 S");		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 1 S"), position);
	}
	
	@Test
	public void testFollowEast() {
		
		Position position = Position.fromInput("3 2 E");		
		instruction.follow(position);
		assertEquals(Position.fromInput("4 2 E"), position);
	}
}
