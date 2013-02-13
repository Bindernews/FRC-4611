package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 * This is a simple command that makes sure the claw is doing nothing. It is the
 * default command for the claw, so whenever no other running command requires
 * the claw (via the
 * {@link CommandBase#requires(edu.wpi.first.wpilibj.command.Subsystem)}
 * function) this command runs.
 *
 * <p>Recommended next step: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class SetVerticalAimAuto extends CommandBase {

	/**
	 * Initialize the command so that it requires nothing. It will not interrupt
	 * anything.
	 */
	public SetVerticalAimAuto(int Mode) {
		requires(verticalaim);
		oi.OperatingMode = Mode;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
