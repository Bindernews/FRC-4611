/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.OI;
import edu.wpi.first.wpilibj.RobotDrive;
import com.olentangyfrc.RobotMap;
import com.olentangyfrc.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class DriveTrain extends Subsystem {

	private Victor leftMotorFront;
	private Victor leftMotorRear;
	private Victor rightMotorFront;
	private Victor rightMotorRear;
	private RobotDrive drive;
	private double driveOrientation = 1.0;
	
	public DriveTrain() {
		super("Drive Train");
		leftMotorFront = new Victor(RobotMap.leftMotor1);
		leftMotorRear = new Victor(RobotMap.leftMotor2);
		rightMotorFront = new Victor(RobotMap.rightMotor1);
		rightMotorRear = new Victor(RobotMap.rightMotor2);
		
		drive = new RobotDrive(leftMotorFront, leftMotorRear, rightMotorFront, rightMotorRear);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setSafetyEnabled(true);
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left * driveOrientation, right * driveOrientation);
	}
	
	public void reverseDrive() {
		driveOrientation *= -1;
	}
	
	public void setForwardDrive() {
		driveOrientation = 1;
	}
	
	public void stop() {
		drive.tankDrive(0, 0);
	}
	
	public void turn(double speed) {
		tankDrive(-speed, speed);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoysticks());
	}
	
}
