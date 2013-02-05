/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package com.olentangyfrc;

import com.olentangyfrc.commands.AimAndShootCommand;
import com.olentangyfrc.commands.AimHorizontal;
import com.olentangyfrc.commands.CommandBase;
import com.olentangyfrc.commands.DriveWithArrows;
import com.olentangyfrc.commands.DriveWithJoysticks;
import com.olentangyfrc.commands.ManualAimCommand;
import com.olentangyfrc.commands.ReverseDriveCommand;
import com.olentangyfrc.commands.ShootCommand;
import com.olentangyfrc.commands.autonomous.AutonomousCommand;
//import com.olentangyfrc.commands.ExampleCommand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Ozone extends IterativeRobot {

	public static DriveWithJoysticks driveWithJoys;
	public static DriveWithArrows driveWithArrows;
	public static AimHorizontal aimHorizontal;
	public static ManualAimCommand manualAim;
	public static boolean isDriveControl = true;
	
	Command autonomousCommand;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Initialize all subsystems
		CommandBase.init();
		
		// Initialize commands, buttons, Joysticks, etc.
		// Must be run in robotInit and after CommandBase.init
		OI.init();
		
		// instantiate the command used for the autonomous period
		autonomousCommand = new AutonomousCommand();
	}
	
	public void disabledInit() {
		
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
