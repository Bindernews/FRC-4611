/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

/**
 *
 * @author Bindernews
 */
public class ShootCommand extends CommandBase {
	
	private static final long SHOOT_TIME_DELAY = 2500;
	
	long shootTime;
	
	public ShootCommand() {
		requires(shooter);
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
	}
	
}
