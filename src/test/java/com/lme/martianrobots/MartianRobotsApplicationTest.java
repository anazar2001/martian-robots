package com.lme.martianrobots;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lme.martianrobots.control.RobotController;

@RunWith(SpringRunner.class)
@SpringBootTest(args = { "--robotsInputFile=src/test/resources/test-martianrobots-instructions.txt" })
public class MartianRobotsApplicationTest {
	
	@Autowired
	private RobotController robotController;

	@Test
	public void contextLoads() {
		
		assertNotNull(robotController.getOutput());
		assertEquals(3, robotController.getOutput().size());
		
		assertEquals("1 1 E", robotController.getOutput().get(0));
		assertEquals("3 3 N LOST", robotController.getOutput().get(1));
		assertEquals("2 3 S", robotController.getOutput().get(2));
	}
}
