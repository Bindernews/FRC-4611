/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class AimVertical extends CommandBase implements ITableListener {

	public static final String turnAmountName = "vertical";
	
	private double turnSpeed = 0.1;
	private double turnAmount = 0.0;
	
	public AimVertical() {
		requires(elevatorSub);
	}

	protected void initialize() {
		SmartDashboard.putNumber("turnSpeedV", turnSpeed);
		//DashUtils.addListener("turnSpeedV", this);
		
		SmartDashboard.putNumber(turnAmountName, turnAmount);
	}

	protected void execute() {
		turnAmount = SmartDashboard.getNumber("turnAmountV");
		elevatorSub.setSpeed(turnSpeed * turnAmount);
	}

	protected boolean isFinished() {
		return turnAmount == 0.0;
	}

	protected void end() {
		elevatorSub.setSpeed(0.0);
	}

	protected void interrupted() {
		end();
	}

	public void valueChanged(ITable table, String name, Object obj, boolean changed) {
		turnSpeed = table.getNumber("turnSpeedV");
	}
	
}
