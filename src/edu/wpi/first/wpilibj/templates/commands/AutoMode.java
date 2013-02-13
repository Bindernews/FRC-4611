package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.AutoDriveToDistance;

/**
 * <p>This command group combines commands and other command groups to perform
 * a relatively complicated autonomous very robustly. This autonomous:</p>
 * <ol>
 * <li>Prepares to grab the soda</li>
 * <li>Grabs the soda</li>
 * <li>Drive to the table</li>
 * <li>Place the soda</li>
 * <li>Back away from the table</li>
 * <li>Stow the entire arm</li>
 * </ol>
 * 
 * <p>Recommended next step: {@link OI}</p>
 *
 * @author Alex Henning
 */
public class AutoMode extends CommandGroup {
    public AutoMode() {
		
		// add code here for autonomous
		// model after code below
		// need team to identify starting point and actions needed to get
	   // get robot to right position,then AIM, then Shoot
		
        addSequential(new SetOperatingMode(OI.STOP));  
		addParallel(new AutoDriveToDistance(5,0.35));
		addParallel(new AutoAimInitialPosition(2,-0.35)); // stow position
		addSequential(new SetOperatingMode(OI.STOP));  
		addParallel(new AutoTurnToPosition(1,0.35));  // turn approx direction
	    addParallel(new AutoAimInitialPosition(2,0.35)); // init position 
		addParallel(new ShooterMotorForward()); // turn on Shooter Motor
        addSequential(new SetOperatingMode(OI.AutoAim));
		addSequential(new FeederPush());
		addSequential(new FeederPush());
		addSequential(new FeederPush());
		addSequential(new FeederPush());
		addSequential(new SetOperatingMode(OI.STOP));
		addSequential(new AutoTurnToPosition(3,0.35));  // turn approx direction
		addSequential(new AutoDriveToDistance(5,0.35));
		addSequential(new SetOperatingMode(OI.STOP));
    }
}
