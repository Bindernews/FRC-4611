/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import java.util.Vector;
import java.util.Hashtable;

/**
 *
 * @author Bindernews
 */
public abstract class DrivingCommand extends CommandBase {
	
	private static DrivingCommand enabledCommand = null;
	
	public final SimpleCommand driveLockCommand = new SimpleCommand() {
		protected void initialize() {
			driveLock();
		}
	};
	
	public DrivingCommand() {
		super();
		construct();
	}
	
	public DrivingCommand(String name) {
		super(name);
		construct();
	}
	
	private void construct() {
		requires(driveTrain);
	}
	
	public void driveLock() {
		enabledCommand = this;
	}
	
	public boolean driveEnabled() {
		return enabledCommand == this;
	}
	
}
