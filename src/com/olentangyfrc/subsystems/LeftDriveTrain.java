/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import com.olentangyfrc.commands.LeftDriveCommand;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class LeftDriveTrain extends Subsystem {

	private Victor motor1;
	private Victor motor2;
	
	public LeftDriveTrain() {
		super("Left Drive");
		motor1 = new Victor(RobotMap.leftMotor1);
		motor2 = new Victor(RobotMap.leftMotor2);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new LeftDriveCommand());
	}
	
	public void setSpeed(double speed) {
		motor1.set(speed);
		motor2.set(speed);
	}
	
}
