/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Bindernews
 */
public class Elevator extends Subsystem {
	
	private Victor elevatorMotor;
	
	public Elevator() {
		super("Elevator");
		
		elevatorMotor = new Victor(RobotMap.elevatorMotor);
	}
	
	protected void initDefaultCommand() {
	}
	
	public void setSpeed(double spd) {
		elevatorMotor.set(spd);
	}
	
}
