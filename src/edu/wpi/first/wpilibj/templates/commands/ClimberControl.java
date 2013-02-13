package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 * <p>The default command for the drive train. When no other command is running,
 * the robot can be driven using the joysticks.</p>
 * 
 * <p>Recommended next step: {@link DriveToDistance}
 *
 * @author Alex Henning
 */
public class ClimberControl extends CommandBase {
    /**
     * Requires the drive train
     */
    public ClimberControl(int Mode) {
        requires(climber); 
		//oi.OperatingMode=Mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.println("ClimbWithJoystick : OperatingMode : " + oi.OperatingMode);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drive with the latest values from joysticks.
     */
    protected void execute() {
		double speed = 0;
		switch(oi.OperatingMode)
		{
			case OI.climberModeLeft:
				speed=oi.getLeftSpeed(); 
				break;
			case OI.climberModeRight:
				speed=oi.getRightSpeed();
				break;
			case OI.climberModeShooter:
				speed=oi.getVerticalAimSpeed();
				break;
			default: // do nothing  Climber has to be specfically selected
				// for safety, t motor off
				speed=0; 
				break;
		} 
		climber.Move(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
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
