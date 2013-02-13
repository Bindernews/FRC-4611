package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveTrainControl;

/**
 * <p>The drive train is PID subsystem, but unlike the {@link Wrist} and
 * {@link Elevator}, it is not always running PID. Instead, it can be run in a
 * manual tank drive or PID can be enabled and it will use a range finder to
 * drive a fixed distance away from the target.</p>
 * 
 * <p>Recommended next step: {@link CommandBase}</p>
 *
 * @author Alex Henning
 */
public class DriveTrain extends PIDSubsystem {
    // The constants for the P, I and D portion of PID
    private static final double Kp = 3; 
    private static final double Ki = .2;
    private static final double Kd = 0.0;
	//*specifying -10 forces the first call to print out the new valu
	private static double leftmotorprevvalue = -10;  // default value actual values are -1 > +1
	private static double rightmotorprevvalue = -10;  // default value actual values are -1 > +1
    
    RobotDrive drive; 
    AnalogChannel rangefinder;


    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);
        drive = new RobotDrive(RobotMap.leftMotorFront, RobotMap.leftMotorRear,  RobotMap.rightMotorFront, RobotMap.rightMotorRear); 
        //drive.setSafetyEnabled(false);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        //rangefinder = new AnalogChannel(RobotMap.rangefinder);
    }
    
    /**
     * Set the default command to drive with joysticks.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTrainControl(0));
    }

    /**
     * @return The value of the rangefinder used as the PID input device.
     *         These values correspond to your PID setpoint, in this case the
     *         value can be anywhere between 0v and 5v.
     */
    protected double returnPIDInput() {
        return rangefinder.getVoltage();
    }

    /**
     * @param output The value to set the output to as determined by the PID
     *               algorithm. This gets called each time through the PID loop
     *               to update the output to the motor.
     */
    protected void usePIDOutput(double output) {
        tankDrive(output, output);
	}
     
    
    /**
     * Implements the tank drive capability of the drivetrain.
     * 
     * @param left The speed for the left side of the drivetrain.
     * @param right The speed for the right side of the drivetrain.
     */
    public void tankDrive(double motor1, double motor2) {
		
		if(leftmotorprevvalue  != motor1 ||
		   rightmotorprevvalue != motor2
	   )
		{	
			leftmotorprevvalue = motor1;
			rightmotorprevvalue = motor2;
		   System.out.println("left: " + motor1 + " right: " + motor2);
        } 
        drive.tankDrive(motor1, motor2);
	} 
}
 