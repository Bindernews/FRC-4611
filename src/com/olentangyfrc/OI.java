
package com.olentangyfrc;

import com.olentangyfrc.commands.AimAndShootCommand;
import com.olentangyfrc.commands.ManualShoot;
import com.olentangyfrc.commands.ReverseDriveCommand;
import com.olentangyfrc.commands.ShootCommand;
import com.olentangyfrc.utils.NamedMultiButton;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick
			leftJoy = new Joystick(RobotMap.leftJoystick),
			rightJoy = new Joystick(RobotMap.rightJoystick),
			n64 = new Joystick(RobotMap.N64Joystick);
	
	public NamedMultiButton
			btnGiveAimControl,
			btnGiveJoysControl,
			btnFire,
			btnReverseDrive;
	
	public OI() {

		// Initialize buttons
		btnReverseDrive = new NamedMultiButton("ReverseButton", 10);
		btnReverseDrive.whenActive(new ReverseDriveCommand());
		btnReverseDrive.add(leftJoy, 1);
		btnReverseDrive.add(rightJoy, 2);
		btnReverseDrive.add(n64, 3);
		
		btnFire = new NamedMultiButton("FireButton", 10);
		btnFire.whenActive(new ManualShoot());
		btnFire.add(leftJoy, RobotMap.aim_fireBtn1);
		btnFire.add(rightJoy, 1);
		btnFire.add(n64, 2);
		
		btnGiveAimControl = new NamedMultiButton("Enable Aiming", 10);
		btnGiveAimControl.whenActive(Ozone.manualAim.driveLockCommand);
		btnGiveAimControl.add(n64, RobotMap.btnGiveAimControl);
		
		btnGiveJoysControl = new NamedMultiButton("Enable Joysticks", 10);
		btnGiveJoysControl.whenActive(Ozone.driveWithJoys.driveLockCommand);
		btnGiveJoysControl.add(n64, RobotMap.btnGiveJoysControl);
		
		// Initialzie the SmartDashboard
		SmartDashboard.putData(btnReverseDrive);
		SmartDashboard.putData(btnFire);
		SmartDashboard.putData(new ShootCommand());
		SmartDashboard.putData(new ReverseDriveCommand());
		SmartDashboard.putData(new AimAndShootCommand());
	}
	
	public static double [] MainCoeffs = {
		123,
		123,
		0,
		0,
		0,
		0,
	};
	public static double [] SubCoeffs = {
		4.055,
		-9.18,
		6,
	};
	
	private static final double JOYSTICK_DEADZONE = 0.05;
	public static double speedf(double speed) {
		double aspeed = Math.abs(speed);
		double value;
		if (aspeed < JOYSTICK_DEADZONE) {
			return 0;
		}
		else if (aspeed > .95) {
			value = 1;
		}
		else if (aspeed >= .85 && aspeed <= .95) {
			value = SubCoeffs[2] * MathUtils.pow(aspeed, 2)
					+ SubCoeffs[1] * MathUtils.pow(aspeed, 1)
					+ SubCoeffs[0];
		} else {
			value = MainCoeffs[5] * MathUtils.pow(aspeed, 5)
					+ MainCoeffs[4] * MathUtils.pow(aspeed, 4)
					+ MainCoeffs[3] * MathUtils.pow(aspeed, 3)
					+ MainCoeffs[2] * MathUtils.pow(aspeed, 2)
					+ MainCoeffs[1] * aspeed
					+ MainCoeffs[0];
		}
		value *= speed / aspeed; // re-add sign
		return value;
	}
	
	public double getLeftJoyY() {
		return speedf(leftJoy.getY());
	}
	public double getRightJoyY() {
		return speedf(rightJoy.getY());
	}
	
	public double getN64H() {
		return n64.getX();
	}
	public double getN64V() {
		return n64.getY();
	}
	
	public double getArrowLR() {
		return speedf(n64.getRawAxis(RobotMap.ArrowAxisLR));
	}
	public double getArrowUD() {
		return speedf(n64.getRawAxis(RobotMap.ArrowAxisUD));
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

