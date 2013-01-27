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
	
	public ShootCommand() {
		requires(elevatorSub);
	}

	protected void initialize() {
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
	
}
