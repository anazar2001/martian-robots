Feature: Grid initialisation
	Grid should be initialised

Scenario: Upon initialisation Grid gets the correct dimensions
	Given The Grid is being initialised
	When Grid max X element is 5 and Y element is 7
	Then Grid gets a width of 6 and Grid height of 8