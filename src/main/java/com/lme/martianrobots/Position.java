package com.lme.martianrobots;

import java.awt.Point;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Position {

	@NonNull private Point coordinates; // Using Point class as normally prefer re-use existing APIs rather than creating duplicate classes
	@NonNull private Orientation orientation;
		
	public static Position fromInput(@NonNull String input) {
		
		String[] args = input.split("\\s+");
		
		if (args.length < 3)
			throw new IllegalArgumentException("Input does not include robot position and orientation: " + input);
		
		if (!StringUtils.isNumeric(args[0]))
			throw new IllegalArgumentException("Invalid robot X coordinate: " + args[0]);
		
		if (!StringUtils.isNumeric(args[1]))
			throw new IllegalArgumentException("Invalid robot Y coordinate: " + args[1]);
		
		if (args[2].length() < 0 || args[2].length() > 1)
			throw new IllegalArgumentException("Invalid robot orientation lenght: " + args[2]);
		
		Orientation orientation = null;
		
		try {
			
			orientation = Orientation.valueOf(args[2]);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Invalid robot orientation: " + args[2]);
		}
		
		return new Position(
			new Point(
				Integer.valueOf(args[0]),
				Integer.valueOf(args[1])),
			orientation);
	}
}
