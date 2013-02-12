package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.AutoMode;
import edu.wpi.first.wpilibj.templates.commands.CommandBase; 
import edu.wpi.first.wpilibj.templates.commands.DriveToDistance;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.templates.commands.ClimbWithJoysticks;
import edu.wpi.first.wpilibj.templates.commands.FeederPush;
import edu.wpi.first.wpilibj.templates.commands.FeederRetract;
import edu.wpi.first.wpilibj.templates.commands.FeederStop;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorForward;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorReverse;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorStop;
import edu.wpi.first.wpilibj.templates.commands.Stow; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimDown; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimStop; 
import edu.wpi.first.wpilibj.templates.commands.VerticalAimUp;  


//import edu.wpi.first.wpilibj.templates.commands.Grab;
//import edu.wpi.first.wpilibj.templates.commands.PrepareToGrab;
//import edu.wpi.first.wpilibj.templates.commands.PlaceSoda;
//import edu.wpi.first.wpilibj.templates.commands.SodaDelivery;
//import edu.wpi.first.wpilibj.templates.commands.Stow;

/**
 * <p>The operator interface class ties the commands that have been implemented
 * to the physical controls of the user. This allows you to bind the same
 * command that executes autonomous to a button. It also reveal the joystick as
 * used by the DriveWithJoysticks command.</p>
 * 
 * @author Alex Henning
 */
public class OI {
    // Create the joystick and of the 8 buttons on it
    Joystick leftJoy = new Joystick(1);
    Button leftbutton1 = new JoystickButton(leftJoy, 1),
            leftbutton2 = new JoystickButton(leftJoy, 2),
            leftbutton3 = new JoystickButton(leftJoy, 3),
            leftbutton4 = new JoystickButton(leftJoy, 4),
            leftbutton5 = new JoystickButton(leftJoy, 5),
            leftbutton6 = new JoystickButton(leftJoy, 6),
            leftbutton7 = new JoystickButton(leftJoy, 7),
            leftbutton8 = new JoystickButton(leftJoy, 8);
    Joystick rightJoy = new Joystick(2);
    Button rightbutton1 = new JoystickButton(rightJoy, 1),
            rightbutton2 = new JoystickButton(rightJoy, 2),
            rightbutton3 = new JoystickButton(rightJoy, 3),
            rightbutton4 = new JoystickButton(rightJoy, 4),
            rightbutton5 = new JoystickButton(rightJoy, 5),
            rightbutton6 = new JoystickButton(rightJoy, 6),
            rightbutton7 = new JoystickButton(rightJoy, 7),
            rightbutton8 = new JoystickButton(rightJoy, 8);
	Joystick shooterJoy = new Joystick(3);
    Button shooterbutton1 = new JoystickButton(shooterJoy, 1),
            shooterbutton2 = new JoystickButton(shooterJoy, 2),
            shooterbutton3 = new JoystickButton(shooterJoy, 3),
            shooterbutton4 = new JoystickButton(shooterJoy, 4),
            shooterbutton5 = new JoystickButton(shooterJoy, 5),
            shooterbutton6 = new JoystickButton(shooterJoy, 6),
            shooterbutton7 = new JoystickButton(shooterJoy, 7),
            shooterbutton8 = new JoystickButton(shooterJoy, 8); 
    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI() {
		// need to map buttons to commands
		leftbutton1.whenPressed(new Stow());
        leftbutton2.whenPressed(new Stow());
        leftbutton3.whenPressed(new Stow());
        leftbutton4.whenPressed(new Stow());
        leftbutton5.whenPressed(new Stow());
        leftbutton6.whenPressed(new Stow());
		leftbutton7.whenPressed(new Stow());
		leftbutton8.whenPressed(new Stow());
		
		rightbutton1.whenPressed(new Stow());
        rightbutton2.whenPressed(new Stow());
        rightbutton3.whenPressed(new Stow());
        rightbutton4.whenPressed(new Stow());
        rightbutton5.whenPressed(new Stow());
        rightbutton6.whenPressed(new Stow());
		rightbutton7.whenPressed(new Stow());
		rightbutton8.whenPressed(new Stow());
		
		shooterbutton1.whenPressed(new Stow());
        shooterbutton2.whenPressed(new Stow());
        shooterbutton3.whenPressed(new Stow());
        shooterbutton4.whenPressed(new Stow());
        shooterbutton5.whenPressed(new Stow());
        shooterbutton6.whenPressed(new Stow());
		shooterbutton7.whenPressed(new Stow());
        //button1.whenPressed(new PrepareToGrab());
        //button2.whenPressed(new Grab());
        //button3.whenPressed(new DriveToDistance(0.11));
        //button4.whenPressed(new PlaceSoda());
        //button6.whenPressed(new DriveToDistance(0.2));
        //button8.whenPressed(new Stow());
        
        //button7.whenPressed(new SodaDelivery());
    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getLeftSpeed() {
        return leftJoy.getY();
    }
    
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
	
	 public double getRightSpeed() {
        return rightJoy.getY();
    }
   // public double getRightSpeed() {
    //    return leftJoy.getRawAxis(4);
   // }
	 public double getVerticalAimSpeed() {
        return shooterJoy.getY();
    } 
	 public double getHorizontalAimSpeed() {
        return shooterJoy.getRawAxis(4);
    }
}

