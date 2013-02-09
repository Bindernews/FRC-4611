/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.utils.DashUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class AimHorizontal extends DrivingCommand implements ITableListener {
	
	public static final String webcamHTurn = "horizontal";
	
	private double turnSpeed = 0.1;
	private double turnAmount = 0.0;
	
	public boolean isEnabled = false;

	public AimHorizontal() {
		super("AimHorizontal");
	}

	protected void initialize() {
		dashboard.putNumber("turnHSpeed", turnSpeed);
		dashboard.addTableListener("turnHSpeed", this, true);
		
		SmartDashboard.putData(this);
		isEnabled = true;
	}

	protected void execute() {
		if (!driveEnabled()) { return; }
		turnAmount = ozone.getNumber(webcamHTurn);
		driveTrain.tankDrive(turnSpeed * turnAmount, turnSpeed * -turnAmount);
	}

	protected boolean isFinished() {
		return turnAmount == 0.0;
	}

	protected void end() {
		driveTrain.stop();
		isEnabled = false;
	}

	protected void interrupted() {
		end();
	}

	public void valueChanged(ITable table, String name, Object obj, boolean changed) {
		turnSpeed = table.getNumber("turnSpeedH");
	}
	
}
