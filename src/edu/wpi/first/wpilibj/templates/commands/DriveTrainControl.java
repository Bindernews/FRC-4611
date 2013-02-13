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
public class DriveTrainControl extends CommandBase {
	
    /**
     * Requires the drive train
     */ 
    public DriveTrainControl(int Mode) {
        requires(drivetrain); 
		oi.OperatingMode=Mode;
	
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
		System.out.println("DriveWithJoystick : OperatingMode : " + oi.OperatingMode);
		
		
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drivetrain drive tank drive with the latest values from joysticks.
     */
    protected void execute() 
	{ 
		double rightSpeed;
		double leftSpeed;
		System.out.println("ShooterMotorStop : OperatingMode : " + oi.OperatingMode);
		switch(oi.OperatingMode)
		{
			case OI.tankModeLeftandRight:				
				leftSpeed=oi.getLeftSpeed();
				leftSpeed=leftSpeed*(-1); 
                rightSpeed=oi.getRightSpeed();
				break;
			case OI.tankModeLeftandShooter:
				rightSpeed = oi.getShooterDrivepeed();
			    leftSpeed = oi.getLeftSpeed();
				leftSpeed=leftSpeed*(-1);
				break;
		   case OI.tankModeRightandShooter:
				leftSpeed = oi.getShooterDrivepeed();
				leftSpeed=leftSpeed*(-1); 
			    rightSpeed = oi.getRightSpeed(); 
				break; 
		   case OI.shooterModeLeft:
			   // normally,left has to be opposite right
			   // however, the wheels need to go opposite
			   // so set to same value;
			    leftSpeed=oi.getLeftHorizontal();
				if(leftSpeed > 0)
				{
					leftSpeed = oi.ShooterDriveSpeed;
					rightSpeed = leftSpeed;
				}
				else if(leftSpeed < 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else 
				{
					leftSpeed=0;
			        rightSpeed=leftSpeed;
				} 
				break;  

			case OI.shooterModeRight:
			   // normally,left has to be opposite right
			   // however, the wheels need to go opposite
			   // so set to same value;
			    leftSpeed=oi.getRightHorizontal();
				if(leftSpeed > 0)
				{
					leftSpeed = oi.ShooterDriveSpeed;
					rightSpeed = leftSpeed;
				}
				else if(leftSpeed < 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else 
				{
					leftSpeed=0;
			        rightSpeed=leftSpeed;
				} 
				break;  
			case OI.shooterModeShooter:
				// normally,left has to be opposite right
				// however, the wheels need to go opposite
				// so set to same value;
				leftSpeed=oi.getHorizontalAimSpeed();
				if(leftSpeed > 0)
				{
					leftSpeed = oi.ShooterDriveSpeed;
					rightSpeed = leftSpeed;
				}
				else if(leftSpeed < 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else 
				{
					leftSpeed=0;
					rightSpeed=leftSpeed;
				} 
			
				break;  
			case OI.AutoAim:
					// normally,left has to be opposite right
			   // however, the wheels need to go opposite
			   // so set to same value;
			    leftSpeed=oi.getHorizontalAimSpeed();
				if(leftSpeed > 0)
				{
					leftSpeed = oi.ShooterDriveSpeed;
					rightSpeed = leftSpeed;
				}
				else if(leftSpeed < 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else 
				{
					leftSpeed=0;
			        rightSpeed=leftSpeed; 
			        SmartDashboard.putString("Aim Vertical Lock :","Locked");
				} 
				break;
			case OI.StraightDriveForward:
				leftSpeed= oi.StraightDriveSpeedDefault * (-1);
				rightSpeed= oi.StraightDriveSpeedDefault;
				break;
			case OI.AutonomousAimInitialPosition:
					// normally,left has to be opposite right
			   // however, the wheels need to go opposite
			   // so set to same value;
			    leftSpeed=oi.horizontalAimOverrideSpeed;
				if(leftSpeed > 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else if(leftSpeed < 0)
				{
					leftSpeed = oi.ShooterDriveSpeed * (-1);
					rightSpeed = leftSpeed;
				}
				else 
				{
					leftSpeed=0;
			        rightSpeed=leftSpeed; 
			        SmartDashboard.putString("Aim Vertical Lock :","Locked");
				} 
				break;
			case OI.STOP:
				leftSpeed=0;
				rightSpeed = 0;
				break;
			default:	 
				leftSpeed=0;
				leftSpeed=leftSpeed*-1;
                rightSpeed=oi.getRightSpeed();
				break;
		}
		System.out.println("Speed : Left : " + leftSpeed + "   Right : " + rightSpeed);
		drivetrain.tankDrive(leftSpeed, rightSpeed);
		 
//		    System.out.println("HOff " + SmartDashboard.getNumber("HOff"));
//		    System.out.println("VOff " + SmartDashboard.getNumber("YOff"));
//		    System.out.println("Distance " + SmartDashboard.getNumber("Distance"));
	 
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
		// joy sticks never stop providing information
		// if you set this to true, it ends the 
		// DriveTrainControl command 
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
