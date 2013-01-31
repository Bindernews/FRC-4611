/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.OI;
import com.olentangyfrc.RobotMap;
import com.olentangyfrc.commands.ManualDriveCommand;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class DriveTrain extends Subsystem {

	private Victor leftMotor1;
	private Victor leftMotor2;
	private Victor rightMotor1;
	private Victor rightMotor2;
	private double driveOrientation = 1.0;
	
	public DriveTrain() {
		super("Drive Train");
		leftMotor1 = new Victor(RobotMap.leftMotor1);
		leftMotor2 = new Victor(RobotMap.leftMotor2);
		rightMotor1 = new Victor(RobotMap.rightMotor1);
		rightMotor2 = new Victor(RobotMap.rightMotor2);
		
		setSafety(true);
	}
	
	public final void setSafety(boolean safe) {
		leftMotor1.setSafetyEnabled(safe);
		leftMotor2.setSafetyEnabled(safe);
		rightMotor1.setSafetyEnabled(safe);
		rightMotor2.setSafetyEnabled(safe);
	}
	
	public void tankDrive() {
		setLeftSpeed(OI.getLeftY());
		setRightSpeed(OI.getRightY());
	}
	
	public void reverseDrive() {
		driveOrientation *= -1;
	}
	
	public void stop() {
		setLeftSpeed(0.0);
		setRightSpeed(0.0);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDriveCommand());
	}
	
	public void setLeftSpeed(double speed) {
		speed *= driveOrientation;
		leftMotor1.set(speed);
		leftMotor2.set(speed);
	}
	
	public void setRightSpeed(double speed) {
		speed *= driveOrientation;
		rightMotor1.set(speed);
		rightMotor2.set(speed);
	}
	
}
