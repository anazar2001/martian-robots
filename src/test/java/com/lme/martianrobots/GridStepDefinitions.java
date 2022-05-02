package com.lme.martianrobots;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GridStepDefinitions {
	
	private Grid grid = new Grid();
	
	@Given("The Grid is being initialised")
    public void gridIsInitialised() throws IOException {
		
    }
	
	@When("Grid max X element is {int} and Y element is {int}")
    public void gridIsInitialised(int maxX, int maxY) throws IOException {
        
		grid.init(String.format("%s %s", maxX, maxY));
    }
	
	@Then("Grid gets a width of {int} and Grid height of {int}")
    public void gridGetsCorrectDimensions(int width, int height) throws IOException {
        
		assertEquals(6, width);
		assertEquals(8, height);
    }
}
