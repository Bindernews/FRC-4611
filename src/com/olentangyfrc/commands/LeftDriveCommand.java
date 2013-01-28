/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class LeftDriveCommand extends CommandBase {

	public LeftDriveCommand() {
		requires(leftDriveTrain);
		//throw new IllegalStateException("LeftDriveCommand should not be used");
	}
	
	protected void initialize() {
	}

	protected void execute() {
		leftDriveTrain.setSpeed(oi.getLeftSpeed());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
}
