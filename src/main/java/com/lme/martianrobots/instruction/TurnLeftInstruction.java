package com.lme.martianrobots.instruction;

import com.lme.martianrobots.Orientation;
import com.lme.martianrobots.Position;

import lombok.NonNull;

public class TurnLeftInstruction implements Instruction {

	@Override
	public char getCode() {
		return Character.valueOf('L');
	}

	@Override
	public void follow(@NonNull Position position) {
		
		switch (position.getOrientation()) {
		
			case N:
				position.setOrientation(Orientation.W);
				break;
				
			case W:
				position.setOrientation(Orientation.S);
				break;
				
			case S:
				position.setOrientation(Orientation.E);
				break;
				
			case E:
				position.setOrientation(Orientation.N);
				break;
		}
	}

	@Override
	public boolean isChangingCoordinatesInstruction() {

		return false; // Turning left is not changing coordinates
	}
}
