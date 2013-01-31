/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class ManualDriveCommand extends CommandBase {

	public ManualDriveCommand() {
		requires(driveTrain);
	}
	
	protected void initialize() {
	}

	protected void execute() {
		driveTrain.tankDrive();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
	}
	
}
