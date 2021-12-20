package com.lme.martianrobots.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lme.martianrobots.Grid;
import com.lme.martianrobots.MartianRobot;
import com.lme.martianrobots.Position;
import com.lme.martianrobots.Robot;
import com.lme.martianrobots.instruction.Instruction;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // Setting Autowired annotation on generated constructor
public class MartianRobotInputProcessor implements RobotInputProcessor {
	
	@NonNull private Grid grid;

	@Override
	public List<Robot> process(String robotsInputFile) {
		
		List<Robot> robots = new ArrayList<Robot>();
				
		BufferedReader reader =  null;
		
		try {
			
			reader = new BufferedReader(new FileReader(robotsInputFile));
			
			String line = reader.readLine();
			
			String positionInput = null;
			
			while (line != null) {
				
				try {
				
					if (StringUtils.isBlank(line))
					continue;
				
					if (!grid.isInitialized()) {
						
						// Grid initialization instruction are expected to in the first line of the file
						grid.init(line);
					}
					else if (positionInput == null) {
						
						positionInput = line;
					}
					else {
						
						Position position = Position.fromInput(positionInput);
						List<Instruction> instructions = Instruction.fromInput(line);
						
						Robot robot = new MartianRobot(grid, position, instructions);
						robots.add(robot);
						
						// Prepare for the next set of robot input instructions
						positionInput = null;
					}
				}
				finally {
				
					line = reader.readLine();
				}
			}
		}
		catch(Exception e) {
			
			throw new RuntimeException("Failed to process robots input file: " + robotsInputFile);
		}
		finally {
			if (reader != null) {
				
				try {
					
					reader.close();
				} 
				catch (IOException e) {
					
					log.error("Failed to close robots input file", e);
				}
			}
		}
		
		return robots;
	}
}
