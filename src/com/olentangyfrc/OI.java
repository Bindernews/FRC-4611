
package com.olentangyfrc;

import com.olentangyfrc.commands.AimAndShootCommand;
import com.olentangyfrc.commands.CommandBase;
import com.olentangyfrc.commands.ReverseDriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick
			leftJoy = new Joystick(RobotMap.leftJoystick),
			rightJoy = new Joystick(RobotMap.rightJoystick),
			aimJoy = new Joystick(RobotMap.aimJoystick);
	
	Button	fireButton1 = new JoystickButton(aimJoy, RobotMap.aim_fireBtn1),
			fireButton2 = new JoystickButton(aimJoy, RobotMap.aim_fireBtn2),
			fireButton3 = new JoystickButton(aimJoy, RobotMap.aim_fireBtn3);
			
	Button [] reverseButtons = {
		new JoystickButton(leftJoy, RobotMap.reverseButtons[0]),
		new JoystickButton(leftJoy, RobotMap.reverseButtons[1]),
		new JoystickButton(rightJoy, RobotMap.reverseButtons[2]),
		new JoystickButton(rightJoy, RobotMap.reverseButtons[3]),
	};
	
	
	/**
	 * Initialize values in the SmartDashboard
	 */
	private void initSmartDashboard() {
		SmartDashboard.putNumber("driveSpeedMultiplier", 1.0); ///< Used to allow driving in reverse
	}
	
	public OI() {
		initSmartDashboard();
		
		AimAndShootCommand shootMeNow = new AimAndShootCommand();
		fireButton1.whenPressed(shootMeNow);
		fireButton2.whenPressed(shootMeNow);
		fireButton3.whenPressed(shootMeNow);
		
		CommandBase reverseDriveCommand = new ReverseDriveCommand();
		for(int i=0; i<reverseButtons.length; i++) {
			reverseButtons[i].whenPressed(reverseDriveCommand);
		}
	}
	
	
	private static final double JOYSTICK_DEADZONE = 0.1;
	public static double speedf(double spd) {
		if (Math.abs(spd) < JOYSTICK_DEADZONE) {
			return 0;
		}
		return spd;
	}
	
	public double getLeftSpeed() {
		return speedf(leftJoy.getY())
				* SmartDashboard.getNumber("driveSpeedMultiplier");
	}

	public double getRightSpeed() {
		return speedf(rightJoy.getY())
				* SmartDashboard.getNumber("driveSpeedMultiplier");
	}
	
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

