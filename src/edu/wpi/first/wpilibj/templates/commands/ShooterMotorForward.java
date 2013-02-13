package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.OI;

//import edu.wpi.first.wpilibj.templates.OI;
//import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 * <p>Same basic idea as the OpenClaw command, however it closes slightly longer
 * to make sure that it is completely closed.</p>
 * 
 * <p>Related command: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class ShooterMotorForward extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw and set the timeout
     * for 1 second, limiting runtime.
     */
   double basetime = 0;
    public ShooterMotorForward() {
        requires(shooter); 
        //this.setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		oi.ShooterReady=false;
		basetime = Timer.getFPGATimestamp();
		//System.out.println("ShooterMotorForwardInitialize");
		
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to close.
     */
    protected void execute() {
			
		    //System.out.println("ShooterMotorForward : Execute"); 
        if(!oi.ShooterReady)
		{
		   shooter.TurnOnForward();
		   //Timer.delay(shooterdelay);
		   double diff = Timer.getFPGATimestamp() - basetime;
		   if(diff > OI.ShooterStartupTime)
		   {
		      oi.ShooterReady=true;
		   }
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it times out, aka after a second.
     */
    protected boolean isFinished() {
		 
		    System.out.println("ShooterMotorForward : Finish");
	
		return false;
        //return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		{
			 
	    	//System.out.println("ShooterMotorForward : End");
		}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
			 
		    //System.out.println("ShooterMotorForward : interrupted");
		
    }
}
