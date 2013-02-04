/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.OI;

/**
 *
 * @author Bindernews
 */
public class DriveWithJoysticks extends DrivingCommand {
	
	public DriveWithJoysticks() {
	}
	
	protected void initialize() {
		driveLock();
	}

	protected void execute() {
		if (!driveEnabled()) { return; }
		driveTrain.tankDrive(OI.getLeftJoy(), OI.getRightJoy());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
	
}
