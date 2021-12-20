package com.lme.martianrobots;

import java.util.List;

import com.lme.martianrobots.instruction.Instruction;

public interface Robot {
	
	/**
	 * Follow all provided instructions one by one.
	 */
	void followInstructions();
	
	
	/**
	 * Get the final status (position/orientation + "LOST" in case the robot falls off the edge of the grid.
	 */
	String getFinalStatus();
	
	Position getPosition();
	List<Instruction> getInstructions();
}
