/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands.autonomous;

import com.olentangyfrc.commands.AimAndShootCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Bindernews
 */
public class AutonomousCommand extends CommandGroup {
	public AutonomousCommand() {
		addSequential(new DriveToPosition());
		addSequential(new AimAndShootCommand());
	}
}
