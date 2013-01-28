package com.olentangyfrc.commands;

import com.olentangyfrc.OI;
import com.olentangyfrc.subsystems.ElevatorSubsystem;
import com.olentangyfrc.subsystems.LeftDriveTrain;
import com.olentangyfrc.subsystems.RightDriveTrain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

	public static OI oi;
	// Create a single static instance of all of your subsystems
	public static ElevatorSubsystem elevatorSub = new ElevatorSubsystem();
	public static LeftDriveTrain leftDriveTrain = new LeftDriveTrain();
	public static RightDriveTrain rightDriveTrain = new RightDriveTrain();

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();

		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData(elevatorSub);
		SmartDashboard.putData(leftDriveTrain);
		SmartDashboard.putData(rightDriveTrain);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
