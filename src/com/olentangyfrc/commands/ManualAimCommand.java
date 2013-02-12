/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.OI;
import com.olentangyfrc.Ozone;

/**
 *
 * @author Bindernews
 */
public class ManualAimCommand extends DrivingCommand {

	public ManualAimCommand() {
		super("Manual Aim Command");
	}
	
	protected void initialize() {
	}

	protected void execute() {
		driveTrain.turn(oi.getN64H());
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void onLockGained() {
		Ozone.isDriveControl = false;
	}

	protected void end() {
		Ozone.isDriveControl = true;
	}

	protected void interrupted() {
	}
	
	
	
}
