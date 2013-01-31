/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class AimHorizontal extends CommandBase implements ITableListener {
	
	public static final String webcamHTurn = "horizontal";
	
	private double turnSpeed = 0.1;
	private double turnAmount = 0.0;

	public AimHorizontal() {
		super("AimHorizontal");
		requires(driveTrain);
		SmartDashboard.putData(this);
	}

	protected void initialize() {
	}

	protected void execute() {
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
		end();
	}
	
	public void initTable(ITable table) {
		super.initTable(table);
		table.putNumber("turnSpeedH", turnSpeed);
		table.addTableListener(this);
	}

	public void valueChanged(ITable table, String name, Object obj, boolean changed) {
		if (name.equals("turnSpeedH")) {
			turnSpeed = table.getNumber("turnSpeedH");
		}
	}
	
}
