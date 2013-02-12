package edu.wpi.first.wpilibj.templates.commands;

/**
 * <p>Same basic idea as the OpenClaw command, however it closes slightly longer
 * to make sure that it is completely closed.</p>
 * 
 * <p>Related command: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class ShooterMotorForward extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw and set the timeout
     * for 1 second, limiting runtime.
     */
    public ShooterMotorForward() {
        requires(shooter);
        this.setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to close.
     */
    protected void execute() {
        shooter.TurnOnForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it times out, aka after a second.
     */
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
