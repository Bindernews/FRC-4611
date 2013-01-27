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
public class ElevatorSubsystem extends Subsystem {
	
	private Victor elevatorMotor;
	
	public ElevatorSubsystem() {
		super("Elevator");
		
		elevatorMotor = new Victor(RobotMap.elevatorMotor);
	}
	
	protected void initDefaultCommand() {
	}
	
	
	
}
