package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.templates.OI;
/**
 * <p>Similar to SetWristSetpoint, but it also has to handle enabling and
 * disabling the PID loop</p>
 * 
 * <p>Recommended next step: {@link PrepareToGrab}</p>
 *
 * @author Alex Henning
 */
public class AutoAimInitialPosition extends CommandBase {
    double driveSeconds = 0; 
	int sign=1;
	double basetime = 0;
	double leftSpeed =0;
	double rightSpeed = 0;
	Timer elapsedTime;  
    
    /**
     * Require the drive train and store the desired setpoint.
     * 
     * @param setpoint The desired setpoint for the drive train.
     */
//    public DriveToDistance(double setpoint) {
//        requires(drivetrain);
//        this.setpoint = setpoint;
//    }
	 public AutoAimInitialPosition(double driveseconds, double Speed) {
       // requires(verticalaim);
        driveSeconds = driveseconds;	
		if(Speed > 1) { oi.verticalAimOverrideSpeed=1;}
		else if(Speed < -1) { oi.verticalAimOverrideSpeed = -1;}
		else {oi.verticalAimOverrideSpeed=Speed;}
    }
	 

    // Called just before this Command runs the first time
    /**
     * Set the setpoint to the stored value and enable PID on the drivetrain.
     */
    protected void initialize() 
	{
        //drivetrain.setSetpoint(setpoint); 
		basetime = Timer.getFPGATimestamp();
		if(driveSeconds <0 )
		{
			sign=-1;
		}   
		driveSeconds = Math.abs(driveSeconds);
        //leftdrivetrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
	{
		double diff=elapsedTime.getFPGATimestamp() - basetime;
		if(diff <= driveSeconds)
		{
			oi.OperatingMode=OI.AutonomousAimInitialPosition;
		}
		else 
		{
			oi.verticalAimOverrideSpeed=0; 
		} 
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the setpoint
	 * Assumes Left drive keeps track of distance
     */
	
    protected boolean isFinished() {
		// put logic here to decide when distance has been met
		// 
		boolean done=false;
		if(elapsedTime.getFPGATimestamp() - basetime <= driveSeconds)
		{
			done=true;
			oi.verticalAimOverrideSpeed=0; 
		} 
		return done;
       // return Math.abs(drivetrain.getPosition() - setpoint) < .02;
    }

    // Called once after isFinished returns true
    /**
     * When this command ends, disable the drivetrain's PID
     */
    protected void end() {
        //drivetrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * When this command exits, disable the drivetrain's PID
     */
    protected void interrupted() {
        //drivetrain.disable();
    }
}
