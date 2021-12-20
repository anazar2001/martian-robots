package com.lme.martianrobots;

import java.awt.Point;
import java.util.List;

import com.lme.martianrobots.instruction.Instruction;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MartianRobot implements Robot {
	
	@NonNull private Grid grid;
	@NonNull private Position position;
	@NonNull private List<Instruction> instructions;
	
	@Override
	public void followInstructions() {
		
		for (Instruction instruction : instructions) {
		
			Point currentCoordinates = new Point(position.getCoordinates());
			
			GridCell gridCell = 
				grid.getGridCell(currentCoordinates.x, currentCoordinates.y);
			
			instruction.follow(position);
		
			if (position.getCoordinates().x >= grid.getWidth() ||
				position.getCoordinates().y >= grid.getHeight()) {
				
				// Move robot to the last position before 'crash'
				position.setCoordinates(new Point(currentCoordinates));

				if (gridCell.isHasScent()) {
					
					// Ignore this instruction if there is a scent in this point left by the previous robot
					continue;
				}
				
				// If the robot falls off the edge set scent and finish processing
				gridCell.setHasScent(true);
				gridCell.setLostRobot(this);
				break;
			}
		}
	}
	
	@Override
	public String getFinalStatus() {
		
		GridCell lastCell = 
			grid.getGridCell(
				position.getCoordinates().x, 
				position.getCoordinates().y);
		
		return String.format(
			"%s %s %s%s", 
			position.getCoordinates().x,
			position.getCoordinates().y,
			position.getOrientation(),
			lastCell.isHasScent() &&
			lastCell.getLostRobot() == this ? 
				" LOST" : "");
	}
}
