package com.lme.martianrobots.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lme.martianrobots.Grid;
import com.lme.martianrobots.Position;
import com.lme.martianrobots.Robot;

public class MartianRobotInputProcessorTest {
	
	private Grid grid;
	private RobotInputProcessor inputProcessor;
	
	@Before
	public void beforeTest() {
		
		grid = new Grid();
		inputProcessor = new MartianRobotInputProcessor(grid);
	}

	@Test
	public void testProcess() {
		
		List<Robot> robots = inputProcessor.process("src/test/resources/test-martianrobots-instructions.txt");
		
		assertTrue(grid.isInitialized());
		assertEquals(6, grid.getWidth());
		assertEquals(4, grid.getHeight());
		
		assertEquals(3, robots.size());
		
		assertEquals(Position.fromInput("1 1 E"), robots.get(0).getPosition());
		assertEquals("RFRFRFRF", robots.get(0).getInstructions().stream().map(e -> String.valueOf(e.getCode())).reduce("", String::concat));
		
		assertEquals(Position.fromInput("3 2 N"), robots.get(1).getPosition());
		assertEquals("FRRFLLFFRRFLL", robots.get(1).getInstructions().stream().map(e -> String.valueOf(e.getCode())).reduce("", String::concat));
		
		assertEquals(Position.fromInput("0 3 W"), robots.get(2).getPosition());
		assertEquals("LLFFFLFLFL", robots.get(2).getInstructions().stream().map(e -> String.valueOf(e.getCode())).reduce("", String::concat));
	}
}
