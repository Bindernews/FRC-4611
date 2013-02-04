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
public class DriveWithArrows extends DrivingCommand {
	
	public DriveWithArrows() {
		super("Drive With Arrow Keys");
		requires(driveTrain);
	}

	protected void initialize() {
		driveLock();
	}

	protected void execute() {
		if (!driveEnabled()) { return; }
		driveTrain.tankDrive(OI.getArrowUD(), OI.getArrowUD());
		driveTrain.turn(OI.getArrowLR());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
}
