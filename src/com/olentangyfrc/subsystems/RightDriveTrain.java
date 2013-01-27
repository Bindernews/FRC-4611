/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import com.olentangyfrc.commands.RightDriveCommand;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class RightDriveTrain extends Subsystem {

	private Victor motor1;
	private Victor motor2;
	
	public RightDriveTrain() {
		super("Right Drive");
		motor1 = new Victor(RobotMap.rightMotor1);
		motor2 = new Victor(RobotMap.rightMotor2);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new RightDriveCommand());
	}
	
}
