/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class RightDriveCommand extends CommandBase {
	
	private double speed;
	
	public RightDriveCommand() {
		requires(rightDriveTrain);
		throw new IllegalStateException("RightDriveCommand should not be used");
	}

	protected void initialize() {
	}

	protected void execute() {
		rightDriveTrain.setSpeed(oi.getRightSpeed());
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
	public void setSpeed(double spd) {
		speed = spd;
		rightDriveTrain.setSpeed(spd);
	}
	
}
