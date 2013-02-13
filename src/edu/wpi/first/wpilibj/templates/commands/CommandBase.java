/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain; 
import edu.wpi.first.wpilibj.templates.subsystems.Feeder; 
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalAim; 
import edu.wpi.first.wpilibj.templates.subsystems.Climber; 


/**
 * <p>The CommandBase class is automatically generated when the project is created.
 * However, whenever you create a new subsystem, you must create a public static
 * reference to it in the CommandBase class. All commands (except for
 * CommandGroups) should be subclasses of CommandBase.</p>
 * 
 * <p>Recommended next step: {@link ClawDoNothing}</p>
 * 
 * @author Alex Henning
 */
public abstract class CommandBase extends Command {
    // CommandBase holds a static instance of OI
    public static OI oi;
    
    // Instances of each subsystem
	 public static DriveTrain drivetrain = new DriveTrain(); 
	 public static Shooter shooter = new Shooter();
	 public static Climber climber = new Climber();
	 public static Feeder feeder = new Feeder();
	 public static VerticalAim verticalaim = new VerticalAim();   
	 //AxisCamera camera =  AxisCamera.getInstance("10.46.11.20");
	 
   
    /**
     * Call this command to properly finish initializing the CommandBase.
     * This call is automatically included in the default template.
     */
    public static void init() {
        oi = new OI(); 
		//SmartDashboard.putString("mytest", "that's it");
        //System.out.println("commandbase : OperatingMode : " + oi.OperatingMode);
        // Optional: Logs the currently running command for each subsystem in
        //           the SmartDashboard. This can be useful for debugging.
        SmartDashboard.putData(drivetrain); 
        SmartDashboard.putData(shooter);
		

		//SmartDashboard.putData(feeder);
        //SmartDashboard.putData(verticalaim);
    }
    
    // Automatically created constructors.
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}
