package com.olentangyfrc;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
	public static final int
			leftJoystick = 1,
			rightJoystick = 2,
			aimJoystick = 3;
	
	public static final int
			aim_feedButton = 1,
			aim_fireBtn1 = 2,
			aim_fireBtn2 = 3,
			aim_fireBtn3 = 4;
	
	public static final int [] reverseButtons = { 1, 2, 3, 4 };
	
	public static final int
			rightMotor1 = 1,
			rightMotor2 = 2,
			leftMotor1 = 3,
			leftMotor2 = 4,
			//,
			feederMotor = 6,
			elevatorMotor = 7;
    
    // Sensors: This is the mapping of the analog ports on the analog module
    // to the relevant sensors.
    public static final int
            rangefinder = 3;
            //elevatorPot = 4,
            //wristPot = 2;
}
