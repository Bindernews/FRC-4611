package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.VerticalAimDown;
import edu.wpi.first.wpilibj.templates.commands.VerticalAimUp; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimStop;

/**
 * <p>One of the simplest possible subsystems that does anything. It consists of
 * a single motor, this motor then controls opening and closing the motor
 * through dead reckoning. It has three capabilities:</p>
 * <ul>
 * <li>{@link Claw#open() Open}: Tells the motor to open the claw.</li>
 * <li>{@link Claw#close() Close}: Tells the motor to close the claw.</li>
 * <li>{@link Claw#doNothing() Do Nothing}: Tells the motor to do nothing with
 *                                          the claw.</li>
 * </ul>
 * 
 * <p>Recommended next step: {@link Wrist}</p>
 * 
 * @author Alex Henning
 */
public class VerticalAim extends Subsystem {
    // The claws motor
    Victor motor;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public VerticalAim() {
	super("VerticalAim");
        motor = new Victor(RobotMap.VerticalAimMotor);
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new  VerticalAimDown());
    }
    
    /**
     * Implements the claw's open capability. Simply tells the motor to move full
     * speed in one direction, it is the commands responsibility to tell it when
     * to stop opening. If the command doesn't, it will keep opening until the
     * command ends and the default command {@link ClawDoNothing} takes over.
     */
    public void Up() {
        motor.set(1);
    }
    
    
    /**
     * Implements the claw's close capability. Simply tells the motor to move
     * full speed in one direction, it is the commands responsibility to tell it
     * when to stop closing. If the command doesn't, it will keep opening until
     * the command ends and the default command {@link ClawDoNothing} takes over.
     */
    public void down() {
        motor.set(-1);
    }
    
    /**
     * Implements the claw's do nothing capability. Simply tells the motor to
     * stop moving. After this is called the claw is neither opening or closing.
     */
    public void stop() {
        motor.set(0);
    }
}
