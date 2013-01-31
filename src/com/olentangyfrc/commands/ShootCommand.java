/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class ShootCommand extends CommandBase implements ITableListener {
	
	private static long SHOOT_TIME_DELAY = 1500;
	private static long REVERSE_TIME_DELAY = 500;
	
	long shootTime;
	
	public ShootCommand() {
		super("ShootCommand");
		requires(shooter);
		SmartDashboard.putData(this);
	}

	protected void initialize() {
		shootTime = System.currentTimeMillis();
	}

	protected void execute() {
		shooter.windUp();
	}

	protected boolean isFinished() {
		return (System.currentTimeMillis() - shootTime) < SHOOT_TIME_DELAY;
	}

	protected void end() {
		shooter.windDown();
	}

	protected void interrupted() {
		shooter.windDown();
	}
	
	public void initTable(ITable table) {
		super.initTable(table);
		table.putNumber("SHOOT_TIME_DELAY", SHOOT_TIME_DELAY);
		table.putNumber("REVERSE_TIME_DELAY", REVERSE_TIME_DELAY);
		table.addTableListener(this);
	}

	public void valueChanged(ITable table, String name, Object o, boolean bln) {
		if (name.equals("SHOOT_TIME_DELAY")) {
			SHOOT_TIME_DELAY = (long)table.getNumber("SHOOT_TIME_DELAY");
		}
		if (name.equals("REVERSE_TIME_DELAY")) {
			REVERSE_TIME_DELAY = (long)table.getNumber("REVERSE_TIME_DELAY");
		}
		
	}
	
}
