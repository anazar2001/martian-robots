package com.lme.martianrobots;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;

@Component
@Data
public class Grid {

	private int width;
	private int height;
	private boolean initialized;
	
	private GridCell[][] gridCells;
	
	public void init(@NonNull String input) {
		
		String[] args = input.split("\\s+");
		
		if (args.length < 2)
			throw new IllegalArgumentException("Input does not include grid width and height: " + input);
		
		if (!StringUtils.isNumeric(args[0]))
			throw new IllegalArgumentException("Invalid Grid width: " + args[0]);
		
		if (!StringUtils.isNumeric(args[1]))
			throw new IllegalArgumentException("Invalid Grid height: " + args[1]);
		
		// Coordinates are 0 index based. So, Width = MaxX + 1; Height = MaxY + 1
		width = Integer.valueOf(args[0]) + 1;
		height = Integer.valueOf(args[1]) + 1;
		
		if (width > 50 || height > 50)
			throw new IllegalArgumentException("Max Grid dimensions are 50x50");
		
		gridCells = new GridCell[width][height];
		
		// Pre-populate the grid with cells
		for (int x = 0; x < width; x++)
			for(int y = 0; y < height; y++) {
				
				gridCells[x][y] = new GridCell();
			}
		
		initialized = true;
	}
	
	public GridCell getGridCell(int x, int y) {
		
		return gridCells[x][y];
	}
}
