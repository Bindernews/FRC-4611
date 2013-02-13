package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.templates.OI;
/**
 * <p>Same basic idea as the OpenClaw command, however it closes slightly longer
 * to make sure that it is completely closed.</p>
 * 
 * <p>Related command: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class FeederPush extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw and set the timeout
     * for 1 second, limiting runtime.
     */
	double basetime = 0;
	boolean done = false;
    public FeederPush() {
        requires(feeder); 
    }

    // Called just before this Command runs the first time
    protected void initialize() 
	{
		oi.Feedercnt=0;
		done=false;
		basetime = Timer.getFPGATimestamp();
		System.out.println("FeederPush : Initialize");
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to close.
     */
    protected void execute() {
		
		System.out.println("FeederPush : Execute");
		System.out.println("FeederPush : Execute" + oi.Feedercnt);
		if(!oi.ShooterReady)
		{
			shooter.TurnOnForward();  
			basetime = Timer.getFPGATimestamp();
			done=false;
		} 
		else 
		{
			double diff = Timer.getFPGATimestamp() - basetime;
		    if(diff < OI.FeederRevolutionTime)
			{
				feeder.TurnOnForward();
			} 
			else 
			{
				feeder.TurnOff();
				done=true;
			} 
		} 
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it times out, aka after a second.
     */
    protected boolean isFinished() 
	{ 
		return done;
	}
       // return Math.abs(elevator.getPosition() - setpoint) < .05;
    // Called once after isFinished returns true
    protected void end() { 
		 		
		    System.out.println("FeederPush : end");
		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		    
		    System.out.println("FeederPush : interrupted");
			
    }
}
