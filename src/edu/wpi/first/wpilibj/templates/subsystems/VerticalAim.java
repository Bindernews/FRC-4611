package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.VerticalAimControl;

/**
 * <p>Another PID subsystem. Nothing special about this one.</p>
 *
 * <p>Related subsystem: {@link Wrist}</p>
 *
 * @author Alex Henning
 */
public class VerticalAim extends Subsystem {
	public static final double BOTTOM = 4.6,
			STOW = 1.65,
			TABLE_HEIGHT = 1.58;
	SpeedController motor;

	// Initialize your subsystem here
	public VerticalAim() {
		super("VerticalAim");
		motor = new Victor(RobotMap.VerticalAimMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new VerticalAimControl(0));
	}

	public void stop() {
		motor.set(0);
	}
	
	/* 
	 * positive speed move in one directon
	 * negative speed in opposite direction
	 */
	public void setSpeed(double speed) {
		motor.set(speed);
	}
}
