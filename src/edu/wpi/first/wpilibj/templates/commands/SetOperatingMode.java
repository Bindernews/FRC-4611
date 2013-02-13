package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 * This is a simple command that makes sure the claw is doing nothing. It is the
 * default command for the claw, so whenever no other running command requires
 * the claw (via the {@link CommandBase
 * #requires(edu.wpi.first.wpilibj.command.Subsystem)}
 * function) this command runs.
 * 
 * <p>Recommended next step: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class SetOperatingMode extends CommandBase {
    
	int NewMode = oi.OperatingModeDefault;
    /**
     * Initialize the command so that it requires nothing.
	 * It will not interrupt anything.
     */
    public SetOperatingMode(int Mode) { 
		NewMode=Mode;
		
    }
  
    // Called just before this Command runs the first time
    protected void initialize() 
	{  
		oi.OperatingMode=NewMode; 
		System.out.print("oi.OperatingMode" + oi.OperatingMode + "\n");
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to do nothing, stopping any previous movement.
     */
    protected void execute() {
		
    } 
    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
