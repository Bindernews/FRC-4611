/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Bindernews
 */
public class Shooter extends Subsystem {
	
	private static double SHOOTER_SPEED = 10.0;
	private Victor shooterMotor;
	
	public Shooter() {
		shooterMotor = new Victor(RobotMap.shooterMotor);
	}
	
	public void windUp() {
		shooterMotor.set(SHOOTER_SPEED);
	}
	
	public void windDown() {
		shooterMotor.set(0.0);
	}

	protected void initDefaultCommand() {
		// no default command needed because command is run by Buttons
	}
	
}
