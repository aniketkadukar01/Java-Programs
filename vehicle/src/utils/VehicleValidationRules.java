package utils;

import custom_exception.SpeedOutOfBounds;

public class VehicleValidationRules {
	
	public static final int MAX_SPEED;
	public static final int MIN_SPEED;
	static {
		MAX_SPEED=80;
		MIN_SPEED=20;
	}
	
	public static void validateSpeed(int speed) throws SpeedOutOfBounds{
		
		if (speed>MAX_SPEED)
			throw new SpeedOutOfBounds("Your Speed is exceeding the limit ");
		if (speed<MIN_SPEED) {
			throw new SpeedOutOfBounds("Your speed is lower than the limit ");
		}
		System.out.println("Speed is within limit ");
	}
}
