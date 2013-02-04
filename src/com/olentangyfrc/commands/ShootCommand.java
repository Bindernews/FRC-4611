/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.utils.DashUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class ShootCommand extends CommandBase implements ITableListener {
	
	private static long SHOOT_TIME = 1500;
	private static long FEED_DELAY = 250;
	private static long FEED_TIME = 500 + FEED_DELAY;
	
	private long timer;
	private boolean wasInterrupted;
	
	public ShootCommand() {
		super("ShootCommand");
		requires(shooter);
		
		SmartDashboard.putNumber("SHOOT_TIME", SHOOT_TIME);
		SmartDashboard.putNumber("FEED_DELAY", FEED_DELAY);
		SmartDashboard.putNumber("FEED_TIME", FEED_TIME);
		DashUtils.addListener("SHOOT_TIME", this);
		DashUtils.addListener("FEED_DELAY", this);
		DashUtils.addListener("FEED_TIME", this);
	}

	protected void initialize() {
		SmartDashboard.putData(this);
		timer = System.currentTimeMillis();
		wasInterrupted = false;
	}
	
	private long runTime() {
		return System.currentTimeMillis() - timer;
	}

	protected void execute() {
		shooter.windUp();
		if (runTime() >= FEED_DELAY && runTime() <= FEED_TIME) {
			shooter.feederOn();
		} else {
			shooter.feederOff();
		}
	}

	protected boolean isFinished() {
		return runTime() > SHOOT_TIME;
	}

	protected void end() {
		shooter.windDown();
	}

	protected void interrupted() {
		wasInterrupted = true;
		shooter.windDown();
	}

	public void valueChanged(ITable table, String name, Object o, boolean bln) {
		SHOOT_TIME = (long)table.getNumber("SHOOT_TIME");
		FEED_DELAY = (long)table.getNumber("FEED_DELAY");
		FEED_TIME = (long)table.getNumber("FEED_TIME") + FEED_DELAY;
	}
	
}
