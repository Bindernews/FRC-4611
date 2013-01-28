/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Bindernews
 */
class AimHorizontal extends CommandBase {
	
	public static final String webcamHTurn = "webcamHTurn";
	
	private double turnSpeed = 0.1;
	private double turnAmount = 0.0;

	public AimHorizontal() {
		requires(driveTrain);
	}

	protected void initialize() {
		SmartDashboard.putNumber("turnSpeed", turnSpeed);
	}

	protected void execute() {
		turnSpeed = SmartDashboard.getNumber("turnSpeed");
		turnAmount = SmartDashboard.getNumber(webcamHTurn);
		driveTrain.setLeftSpeed(turnSpeed * turnAmount);
		driveTrain.setRightSpeed(turnSpeed * -turnAmount);
	}

	protected boolean isFinished() {
		return turnAmount == 0.0;
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
	}
	
}
