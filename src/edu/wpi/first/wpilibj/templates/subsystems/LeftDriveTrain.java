package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;

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
public class LeftDriveTrain extends PIDSubsystem {
    // The constants for the P, I and D portion of PID
    private static final double Kp = 3;
    private static final double Ki = .2;
    private static final double Kd = 0.0;
    
    RobotDrive leftdrive; 
    AnalogChannel rangefinder;


    // Initialize your subsystem here
    public LeftDriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);
        leftdrive = new RobotDrive(RobotMap.leftMotor1, RobotMap.leftMotor2); 
        
        
        rangefinder = new AnalogChannel(RobotMap.rangefinder);
    }
    
    /**
     * Set the default command to drive with joysticks.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
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
        lefttankDrive(output, output);
	}
     
    
    /**
     * Implements the tank drive capability of the drivetrain.
     * 
     * @param left The speed for the left side of the drivetrain.
     * @param right The speed for the right side of the drivetrain.
     */
    public void lefttankDrive(double motor1, double motor2) {
        leftdrive.tankDrive(motor1, motor2);
	} 
}
 