/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Bindernews
 */
public class ReverseDriveCommand extends CommandBase {
	
	public ReverseDriveCommand() {
		
	}

	protected void initialize() {
		
	}

	protected void execute() {
		double speedMult = SmartDashboard.getNumber("driveSpeedMultiplier");
		speedMult *= -1;
		SmartDashboard.putNumber("driveSpeedMultiplier", speedMult);
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
}
