/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Bindernews
 */
public class AimAndShootCommand extends CommandGroup {
	public AimAndShootCommand() {
		addParallel(new AimHorizontal());
		addParallel(new AimVertical());
		addSequential(new ShootCommand());
	}
	
}
