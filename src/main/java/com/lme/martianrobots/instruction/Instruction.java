package com.lme.martianrobots.instruction;

import java.util.ArrayList;
import java.util.List;

import com.lme.martianrobots.Position;

import lombok.NonNull;

/**
 * Interface representing Robot instruction. To add a new instruction you
 * need to create a new Class implementing this interface and most likely
 * add some logic for handling new instruction
 */
public interface Instruction {
	
	char getCode(); 	// Using Character instead of Enum only because requirement says we need to 
						// support adding more instructions easily (assume without changing interface/enum)
	
	
	/**
	 * Follow instruction from the given position.
	 */
	void follow(Position position);
	
	boolean isChangingCoordinatesInstruction();
	
			
	public static List<Instruction> fromInput(@NonNull String input) {
		
		char[] instructionCodes = input.toCharArray();
		
		List<Instruction> instructions = new ArrayList<Instruction>();
		
		for (char instructionCode : instructionCodes) {
			
			instructions.add(create(instructionCode));
		}
		
		return instructions;
	}
	
	/**
	 * Factory method. Could have created a separate class especially if many instructions supported
	 */
	public static Instruction create(char code) {
		
		if (code == 'L')
			return new TurnLeftInstruction();
		else if (code == 'R')
			return new TurnRightInstruction();
		else if (code == 'F')
			return new MoveForwardInstruction();
		// Add factory code for new instructions here
		else
			throw new IllegalArgumentException("Instruction is not supported: " + code);
	}
}
