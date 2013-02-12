/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class Shooter extends Subsystem implements ITableListener {
	
	private static double SHOOTER_SPEED = 1.0;
	private static double FEEDER_SPEED = 1.0;
	private Victor shooterMotor;
	private Victor feeder;
	
	public Shooter() {
		super("Shooter");
		shooterMotor = new Victor(RobotMap.shooterMotor);
		feeder = new Victor(RobotMap.feederMotor);
		SmartDashboard.putNumber("SHOOTER_SPEED", SHOOTER_SPEED);
		SmartDashboard.putNumber("FEEDER_SPEED", FEEDER_SPEED);
		//DashUtils.addListener("SHOOTER_SPEED", this);
		//DashUtils.addListener("FEEDER_SPEED", this);
	}
	
	public void shooterOn() {
		shooterMotor.set(SHOOTER_SPEED);
	}
	
	public void shooterOff() {
		shooterMotor.set(0.0);
	}
	
	public void feederOn() {
		feeder.set(FEEDER_SPEED);
	}
	
	public void feederOff() {
		feeder.set(0.0);
	}

	protected void initDefaultCommand() {
		// no default command needed because command is run by Buttons
	}

	public void valueChanged(ITable table, String name, Object obj, boolean bln) {
		SHOOTER_SPEED = SmartDashboard.getNumber("SHOOTER_SPEED");
		FEEDER_SPEED = SmartDashboard.getNumber("FEEDER_SPEED");
	}
	
}
