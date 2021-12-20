package com.lme.martianrobots.instruction;

import com.lme.martianrobots.Orientation;
import com.lme.martianrobots.Position;

import lombok.NonNull;

public class TurnRightInstruction implements Instruction {

	@Override
	public char getCode() {
		return Character.valueOf('R');
	}

	@Override
	public void follow(@NonNull Position position) {
		
		switch (position.getOrientation()) {
		
			case N:
				position.setOrientation(Orientation.E);
				break;
				
			case E:
				position.setOrientation(Orientation.S);
				break;
				
			case S:
				position.setOrientation(Orientation.W);
				break;
				
			case W:
				position.setOrientation(Orientation.N);
				break;
		}
	}

	@Override
	public boolean isChangingCoordinatesInstruction() {

		return false; // Turning right is not changing coordinates
	}
}
