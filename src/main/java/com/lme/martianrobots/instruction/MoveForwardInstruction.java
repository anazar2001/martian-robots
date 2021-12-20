package com.lme.martianrobots.instruction;

import com.lme.martianrobots.Position;

import lombok.NonNull;

public class MoveForwardInstruction implements Instruction {

	@Override
	public char getCode() {
		return Character.valueOf('F');
	}

	@Override
	public void follow(@NonNull Position position) {
		
		if (position.getCoordinates() == null)
			throw new IllegalArgumentException("Position coordinates not provided");
		
		// Move coordinates depending on current orientation
		switch (position.getOrientation()) {
		
			case N:
				position.getCoordinates().translate(0, 1);
				break;
				
			case W:
				position.getCoordinates().translate(-1, 0);
				break;
				
			case S:
				position.getCoordinates().translate(0, -1);
				break;
				
			case E:
				position.getCoordinates().translate(1, 0);
				break;
		}
	}

	@Override
	public boolean isChangingCoordinatesInstruction() {

		return true;
	}
}
