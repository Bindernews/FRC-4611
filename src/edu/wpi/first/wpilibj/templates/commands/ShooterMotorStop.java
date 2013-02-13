package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 * This is a simple command that makes sure the claw is doing nothing. It is the
 * default command for the claw, so whenever no other running command requires
 * the claw (via the {@link CommandBase#requires(edu.wpi.first.wpilibj.command.Subsystem)}
 * function) this command runs.
 * 
 * <p>Recommended next step: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class ShooterMotorStop extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw. This means it will
     * be interrupted if another command requiring the claw is run.
     */ 
	 
    public ShooterMotorStop() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
		System.out.println("ShooterMotorStop : Initialize");  
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to do nothing, stopping any previous movement.
     */
    protected void execute() { 
		   //System.out.println("ShooterMotorStop : Execute"); 
        shooter.TurnOff();	
		oi.ShooterReady=false;
		
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
		
		  // System.out.println("ShooterMotorStop : isFinished"); 
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		 
		  // System.out.println("ShooterMotorStop : end"); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { 
		  // System.out.println("ShooterMotorStop : interrupted"); 
    }
}
