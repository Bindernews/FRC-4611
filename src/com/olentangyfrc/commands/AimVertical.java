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
class AimVertical extends CommandBase {

	private double turnSpeed = 0.1;
	private double turnAmount = 0.0;
	
	public AimVertical() {
		requires(elevatorSub);
	}

	protected void initialize() {
		SmartDashboard.putNumber("turnSpeedV", turnSpeed);
		SmartDashboard.putNumber("turnAmountV", turnAmount);
	}

	protected void execute() {
		turnSpeed = SmartDashboard.getNumber("turnSpeedV");
		turnAmount = SmartDashboard.getNumber("turnAmountV");
		elevatorSub.setSpeed(turnSpeed * turnAmount);
	}

	protected boolean isFinished() {
		return turnAmount == 0.0;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
}
