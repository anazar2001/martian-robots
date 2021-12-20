package com.lme.martianrobots;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lme.martianrobots.instruction.Instruction;

public class MartianRobotTest {
	
	private Grid grid;
	private Position position;
	
	@Before
	public void beforeTest() {
		
		grid = new Grid();
		grid.init("3 4");
		
		position = Position.fromInput("1 1 S");
	}

	@Test
	public void testFollowInstructions() {
		
		List<Instruction> instructions = Instruction.fromInput("RFLFLFF");
		
		Robot robot = new MartianRobot(grid, position, instructions);
		
		robot.followInstructions();
		
		assertEquals(Position.fromInput("2 0 E"), position);
		assertEquals("2 0 E", robot.getFinalStatus());
		assertFalse(grid.getGridCell(2, 0).isHasScent());
	}
	
	@Test
	public void testFollowInstructionsToScent() {
		
		List<Instruction> instructions = Instruction.fromInput("RFLFLFFFFFF");
		
		Robot robot = new MartianRobot(grid, position, instructions);
		
		robot.followInstructions();
		
		assertEquals(Position.fromInput("3 0 E"), position);
		assertEquals("3 0 E LOST", robot.getFinalStatus());
		assertTrue(grid.getGridCell(3, 0).isHasScent());
	}
	
	/**
	 *  Tests that robot ignores 'off edge' instruction from the scent point left by the previous robot
	 */
	@Test
	public void testFollowInstructionsIgnoreFromScent() {
		
		grid.getGridCell(3, 0).setHasScent(true); 
		
		List<Instruction> instructions = Instruction.fromInput("RFLFLFFFFFF");
		
		Robot robot = new MartianRobot(grid, position, instructions);
		
		robot.followInstructions();
		
		assertEquals(Position.fromInput("3 0 E"), position);
		assertEquals("3 0 E", robot.getFinalStatus());
		assertTrue(grid.getGridCell(3, 0).isHasScent());
	}
}
