package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorForward;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorReverse;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorStop;

/**
 * <p>One of the simplest possible subsystems that does anything. It consists of
 * a single motor, this motor then controls opening and closing the motor
 * through dead reckoning. It has three capabilities:</p>
 * <ul>
 * <li>{@link Shooter Motor Turn On Forward}: Tells the motor to turn in one direction.</li>
 * <li>{@link Turn on Backward}: Tells the motor to go in the other direction.</li>
 * <li>{@link TurnOff : Tells the motor to stop
 *                                          .</li>
 * </ul>
 * 
 * <p>Recommended next step: {@link Wrist}</p>
 * 
 * @author Alex Henning
 */
public class Shooter extends Subsystem {
    // The claws motor
    Victor motor;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public Shooter() {
	super("Shooter");
        motor = new Victor(RobotMap.ShooterMotor);
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new  ShooterMotorStop());
    }
    
    /**
     * Implements the shooter motor to turn in 'foward' direction. Simply tells the motor to move full
     * speed in one direction, it is the commands responsibility to tell it when
     * to stop opening. If the command doesn't, it will keep opening until the
     * command ends and the default command {@link Turn off} takes over.
     */
    public void TurnOnForward() 
	{
        motor.set(-1);
    }
    
    
    /**
     * Implements the shooter motor's reverse capability. Simply tells the motor to move
     * full speed in one direction, it is the commands responsibility to tell it
     * when to stop closing. If the command doesn't, it will keep opening until
     * the command ends and the default command {@link Turn Off} takes over.
     */
    public void TurnOnBackward() {
        motor.set(1);
    }
    
    /**
     * Implements the shooter motor to turn off. Simply tells the motor to
     * stop moving. After this is called the claw is neither opening or closing.
     */
    public void TurnOff() {
        motor.set(0);
    }
}
