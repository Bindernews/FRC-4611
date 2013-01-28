
package com.olentangyfrc;

import com.olentangyfrc.commands.AimAndShootCommand;
import com.olentangyfrc.commands.CommandBase;
import com.olentangyfrc.commands.ReverseDriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick
			leftJoy = new Joystick(RobotMap.leftJoystick),
			rightJoy = new Joystick(RobotMap.rightJoystick),
			aimJoy = new Joystick(RobotMap.aimJoystick);
	
	public static JoystickMultiButton fireButtons;
	public static JoystickMultiButton reverseButtons;
	
	public static void init() {
		// Initialzie the SmartDashboard
		
		// Initialize buttons
		reverseButtons = new JoystickMultiButton(10);
		reverseButtons.whenActive(new ReverseDriveCommand());
		reverseButtons.add(leftJoy, RobotMap.reverseButtons[0]);
		reverseButtons.add(leftJoy, RobotMap.reverseButtons[1]);
		reverseButtons.add(leftJoy, RobotMap.reverseButtons[2]);
		reverseButtons.add(leftJoy, RobotMap.reverseButtons[3]);
		
		fireButtons = new JoystickMultiButton(10);
		fireButtons.whenActive(new AimAndShootCommand());
		fireButtons.add(leftJoy, RobotMap.aim_fireBtn1);
	}
	
	private static final double JOYSTICK_DEADZONE = 0.1;
	public static double speedf(double spd) {
		if (Math.abs(spd) < JOYSTICK_DEADZONE) {
			return 0;
		}
		return spd;
	}
	
	public static double getLeftY() {
		return speedf(leftJoy.getY());
	}

	public static double getRightY() {
		return speedf(rightJoy.getY());
	}
	
	private OI() {}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

