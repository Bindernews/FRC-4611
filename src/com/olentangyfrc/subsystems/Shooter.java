/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.subsystems;

import com.olentangyfrc.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class Shooter extends Subsystem implements ITableListener {
	
	private static double SHOOTER_SPEED = 10.0;
	private static double REVERSE_SPEED = 1.0;
	private Victor shooterMotor;
	
	public Shooter() {
		super("Shooter");
		shooterMotor = new Victor(RobotMap.shooterMotor);
	}
	
	public void initTable(ITable table) {
		super.initTable(table);
		table.putNumber("SHOOTER_SPEED", SHOOTER_SPEED);
		table.putNumber("REVERSE_SPEED", REVERSE_SPEED);
		table.addTableListener(this);
	}
	
	public void windUp() {
		shooterMotor.set(SHOOTER_SPEED);
	}
	
	public void windDown() {
		shooterMotor.set(0.0);
	}
	
	public void runReverse() {
		shooterMotor.set(REVERSE_SPEED);
	}

	protected void initDefaultCommand() {
		// no default command needed because command is run by Buttons
	}

	public void valueChanged(ITable table, String name, Object obj, boolean bln) {
		if (name.equals("SHOOTER_SPEED")) {
			SHOOTER_SPEED = table.getNumber("SHOOTER_SPEED");
		}
		if (name.equals("REVERSE_SPEED")) {
			REVERSE_SPEED = table.getNumber("REVERSE_SPEED");
		}
	}
	
}
