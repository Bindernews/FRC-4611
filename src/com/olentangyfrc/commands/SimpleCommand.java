/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.Ozone;

/**
 *
 * @author Bindernews
 */
public abstract class SimpleCommand extends CommandBase {

	protected void execute() {}
	protected boolean isFinished() { return true; }
	protected void end() {}
	protected void interrupted() {}
	
}
