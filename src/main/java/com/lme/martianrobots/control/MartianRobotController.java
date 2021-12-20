package com.lme.martianrobots.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.lme.martianrobots.Grid;
import com.lme.martianrobots.Robot;
import com.lme.martianrobots.input.RobotInputProcessor;

import lombok.Data;
import lombok.NonNull;

@Data
@Component
public class MartianRobotController implements RobotController {
	
	private final String ROBOTS_INPUT_FILE = "robotsInputFile";
	private List<String> output = new ArrayList<String>();

	@Autowired
	public MartianRobotController(
			@NonNull RobotInputProcessor inputProcessor,
			@NonNull Grid grid,
			@NonNull ApplicationArguments args) {
		
		if (!args.getOptionNames().contains(ROBOTS_INPUT_FILE) ||
			args.getOptionValues(ROBOTS_INPUT_FILE).size() == 0) {
			
			throw new IllegalArgumentException("Robots input file not provided");
		}
		
		String robotsInputFile = args.getOptionValues(ROBOTS_INPUT_FILE).get(0);
		
		try {
			
			List<Robot> robots = 
				inputProcessor.process(robotsInputFile);
			
			System.out.println("\nOUTPUT:\n");
			
			for(Robot robot : robots) {
				
				robot.followInstructions();
				System.out.println(robot.getFinalStatus());
				
				output.add(robot.getFinalStatus());
			}
			
			System.out.println();
		}
		catch(Exception e) {
			
			throw new RuntimeException("Failed to process robot instructions");
		}
	}
}
