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
import edu.wpi.first.wpilibj.templates.commands.AutoMode;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
//import edu.wpi.first.wpilibj.templates.commands.SodaDelivery;
import edu.wpi.first.wpilibj.templates.commands.FeederPush;
import edu.wpi.first.wpilibj.templates.commands.FeederStop; 
import edu.wpi.first.wpilibj.templates.commands.FeederRetract; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimDown; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimStop; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimUp; 
import edu.wpi.first.wpilibj.templates.commands.ClimbWithJoysticks; 

//import edu.wpi.first.wpilibj.templates.subsystems.Claw;
import edu.wpi.first.wpilibj.templates.subsystems.Feeder;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.LeftDriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.RightDriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalAim;
import edu.wpi.first.wpilibj.templates.subsystems.Climber;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * <p>This is the main robot class for an robot that is designed to deliver sodas.
 * It is designed to be able to both handle delivering soda autonomously and
 * under operator control using a joystick. The goal is that this is to provide
 * an example of a more complicated command based robot.</p>
 * 
 * <p> In is recommended that you have read at least the beginning of the
 * cookbook and are familiar with the basics of command base programming before
 * you start trying to understand this example. When reading through this, the
 * recommended order is:</p>
 * <ol>
 * <li>{@link RobotMap}</li>
 * <li>The subsystems starting with {@link Claw}</li>
 * <li>{@link CommandBase}</li>
 * <li>The commands staring with {@link SodaDelivery}</li>
 * <li>{@link OI}</li>
 * </ol>
 * 
 * <p>The only modifications from the default file created are setting the
 * autonomousCommand to SodaDelivery in robotInit and a few calls to status 
 * functions in teleopPeriodic.</p>
 * 
 * <p>Recommended next step: {@link RobotMap}</p>
 * 
 * @author Alex Henning
 */
public class GearsBot extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize the CommandBase so that everything is ready to run
        CommandBase.init();
        
        // instantiate the command used for the autonomous period
        // Set it so that it runs the SodaDelivery command automatically during 
        // the automous period.
        autonomousCommand = new AutoMode();
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
