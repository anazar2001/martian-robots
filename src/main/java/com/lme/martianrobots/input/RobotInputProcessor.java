package com.lme.martianrobots.input;

import java.util.List;

import com.lme.martianrobots.Robot;

/**
 * Process the file with robot instructions and return list of robots ready to operate
 */
public interface RobotInputProcessor {
	
	List<Robot> process(String robotsInputFile);
}
