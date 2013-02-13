/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.camera.AxisCamera;  
import edu.wpi.first.wpilibj.templates.commands.AutoMode;
import edu.wpi.first.wpilibj.templates.commands.MessageTest;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * <p>This is the main robot class for an robot that is designed to shoot 
 * frizbees. It is designed to be able to both handle autonomously and
 * under operator control using a joystick. The goal is that this is to provide
 * an example of a more complicated command based robot.</p>
 * 
 * <p> It is recommended that you have read at least the beginning of the
 * cookbook and are familiar with the basics of command base programming before
 * you start trying to understand this example. When reading through this, the
 * recommended order is:</p>
 * <ol>
 * <li>{@link RobotMap}</li>
 * <li>The subsystems starting with {@link drivetrain}</li>
 * <li>{@link CommandBase}</li>
 * <li>The commands staring with {@link DriveWithJoySticks}</li>
 * <li>{@link OI}</li>
 * </ol>
 * 
 * <p>The only modifications from the default file created are setting the
 * autonomousCommand to position the robot and shoot and manual
 * functions in teleopPeriodic.</p>
 * 
 * <p>Recommended next step: {@link RobotMap}</p>
 * 
 * @author Alex Henning
 */
public class GearsBot extends IterativeRobot {

    Command autonomousCommand;
	MessageTest messageTest = new MessageTest();
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize the CommandBase so that everything is ready to run]
		
        CommandBase.init();
        //SmartDashboard.putData("SchedulerData",Scheduler.getInstance());
        // instantiate the command used for the autonomous period
        // Set it so that it runs the SodaDelivery command automatically during 
        // the automous period.
        autonomousCommand = new AutoMode();
		messageTest.start();
    }
	
	public void disabledInit() {
		messageTest.interrupt();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
