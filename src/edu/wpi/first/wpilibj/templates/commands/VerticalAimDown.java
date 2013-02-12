package edu.wpi.first.wpilibj.templates.commands;

/**
 * <p>Another command that requires the claw. However, this one runs for a set
 * period of time and then it's finished and stops executing.</p>
 * 
 * <p>Recommended next step: {@link SetWristSetpoint}<br/>
 * Related command: {@link CloseClaw}</p>
 *
 * @author Alex Henning
 */
public class VerticalAimDown extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw and set the timeout
     * for 0.8 seconds, limiting runtime.
     */
    public VerticalAimDown() {
        requires(verticalaim);
        this.setTimeout(.8);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to open.
     */
    protected void execute() {
        verticalaim.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it times out, aka after four fifths of a second.
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
