package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;

/**
 * <p>The default command for the drive train. When no other command is running,
 * the robot can be driven using the joysticks.</p>
 * 
 * <p>Recommended next step: {@link DriveToDistance}
 *
 * @author Alex Henning
 */
public class VerticalAimControl extends CommandBase {
    /**
     * Requires the drive train
     */
    public VerticalAimControl(int Mode) { 
		requires(verticalaim);  
		oi.OperatingMode = Mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
		System.out.println("VerticalAimWithJoystick : OperatingMode : " + oi.OperatingMode);
		
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drivetrain drive tank drive with the latest values from joysticks.
     */
    protected void execute() 
	{
		double speed = 0; 
		System.out.println("VerticalAimWithJoystick : OperatingMode : " + oi.OperatingMode);
		switch(oi.OperatingMode)
		{ 
			case OI.shooterModeLeft:
				speed = oi.getLeftSpeed();  
				break;
			case OI.shooterModeRight:
				speed = oi.getRightSpeed();  
				break;
			case OI.shooterModeShooter:
				speed = oi.getVerticalAimSpeed();  
				break;
			case OI.tankModeLeftandRight:
				speed = oi.getVerticalAimSpeed();  
				break;
			case OI.tankModeLeftandShooter:
				speed = oi.getRightSpeed();  
				break; 
			case OI.tankModeRightandShooter:
				speed = oi.getLeftSpeed();  
				break; 
			case OI.AutoAim:
				speed = oi.verticalAimOverrideSpeed; 
				if(speed == 0)
				{					
			       SmartDashboard.putString("Aim Vertical Lock :","Locked");
				} 
				break;
			case OI.AutonomousAimInitialPosition:
				break;
			default:
				speed = oi.getVerticalAimSpeed();  
				break;
		}
		verticalaim.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
		// joy sticks never stop providing information
		// if you set this to true, it ends the 
		// DriveWithJoysticks command
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
