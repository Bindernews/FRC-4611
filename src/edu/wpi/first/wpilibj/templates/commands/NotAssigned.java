package edu.wpi.first.wpilibj.templates.commands;

/**
 * This is a simple command that makes sure the claw is doing nothing. It is the
 * default command for the claw, so whenever no other running command requires
 * the claw (via the {@link CommandBase#requires(edu.wpi.first.wpilibj.command.Subsystem)}
 * function) this command runs.
 * 
 * <p>Recommended next step: {@link OpenClaw}</p>
 *
 * @author Alex Henning
 */
public class NotAssigned extends CommandBase {
    
    /**
     * Initialize the command so that it requires nothing.
	 * It will not interrupt anything.
     */
	private String _CalledFrom = "NotAssigned";
    public NotAssigned(String CalledFrom) {
		_CalledFrom=CalledFrom;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.print("Not Assigned : " + _CalledFrom + "\n");
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to do nothing, stopping any previous movement.
     */
    protected void execute() {
		
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
