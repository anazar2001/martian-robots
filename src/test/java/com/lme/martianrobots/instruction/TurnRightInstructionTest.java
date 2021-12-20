package com.lme.martianrobots.instruction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lme.martianrobots.Position;

public class TurnRightInstructionTest {
	
	private Instruction instruction;
	
	@Before
	public void beforeTest() {
		
		instruction = new TurnRightInstruction();
	}

	@Test
	public void testFollow() {
		
		Position position = Position.fromInput("3 2 N");
		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 2 E"), position);
		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 2 S"), position);
		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 2 W"), position);
		
		instruction.follow(position);
		assertEquals(Position.fromInput("3 2 N"), position);
	}
}
