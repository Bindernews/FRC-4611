package edu.wpi.first.wpilibj.templates;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import edu.wpi.first.wpilibj.templates.commands.DriveTrainControl;
import edu.wpi.first.wpilibj.templates.commands.FeederPush;
import edu.wpi.first.wpilibj.templates.commands.SetOperatingMode;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorForward;
import edu.wpi.first.wpilibj.templates.commands.ShooterMotorStop;

/**
 * <p>The operator interface class ties the commands that have been implemented
 * to the physical controls of the user. This allows you to bind the same
 * command that executes autonomous to a button. It also reveal the joystick as
 * used by the DriveWithJoysticks command.</p>
 *
 * @author Alex Henning
 */
public class OI {
	// creates digital channels, the encoder and the encoder output variables
	DigitalInput channel1a = new DigitalInput(2, 1);
	DigitalInput channel1b = new DigitalInput(2, 2);
	Encoder feederEncoder = new Encoder(channel1a, channel1b);
	//*******************************************************//
	//* CONSTANTS                                           *//
	//*******************************************************//
	//* Operating Modes                                     *//
	//* Used by the control commands for linking the        *//
	//* different inputs (joystick and auto control inputs) *//
	//* This allows switching control of a subsystem to     *//
	//* different joysticks on the fly                      *//
	//*******************************************************//
	static final public int 
			STOP = -1, // initial value to do nothing
			tankModeLeftandRight = 0, //LJoy,RJoy,ShooterJoy	
			tankModeRightandShooter = 1,//Shooter Joy plays left
			tankModeLeftandShooter = 2,// Shooter Joy Plays rt 

			shooterModeLeft = 3, // shooter joy primary
			shooterModeRight = 4, // right joy drives
			shooterModeShooter = 5, // left joy drives

			climberModeLeft = 6, // Left primary
			climberModeRight = 7, // right joy drives
			climberModeShooter = 8, // shooter joy drives

			AutoAim = 9 , // shooter joy drives
			StraightDriveForward = 10, // drives straight forward 
			AutonomousAimInitialPosition = 11 ; // shooter joy drives; 

	 static final public int OperatingModeDefault = tankModeLeftandRight;
     
	 static final public double 
			ClimberStowPosition = 0,
			ClimberStartPosition = 0,
			ClimberMaxPosition = 200;
	 
	static final public double JoyStickSoftener = 0.05,
			HorizontalConstant = 0.1,
			verticalAimStowPosition = -20,
			verticalAimStartPosition = 0,
			verticalAimMaxPosition = 0;
	public double verticalAimOverrideSpeed=0.5;
	public double horizontalAimOverrideSpeed=0.3;
	
	static final public double 
			FeederForwardSpeed = -1,
	        FeederBackwardSpeed = 1, 
			FeederStowPosition = -20,
			FeederStartPosition = 0,
			FeederStopPosition = 100,
	        FeederRevolutionTime = 3;
	static final public double StraightDriveSpeedDefault = 0.5;
	
	static final public double ShooterDriveSpeed = 0.35;
	static final public double ShooterStartupTime = 3.0;
	
	static final public double autoModeDrivetrainSpeed = 0.5;
	public double autoModeBaseTime = 0;
	
	public final int DistanceAngle[][] = {{10, 10},
		{20, 20},
		{30, 30},
		{40, 40},
		{50, 50}
	};
	// depending on the distance, the xdelta value has to be adusted.
	// this table takes the delta and adjusts it.
	// Aim Softener
	static final double AimVerticalSoftener = 1;
	static final double AimHorizontalSoftener = 1;
	static final double AimDefaultSpeed = 0.1;
	static final double AimHorizontalDefaultSpeed = 0.1;
	static final double AimDistanceAdjustment[][] = {{10, 1},
		{20, 20},
		{30, 30},
		{40, 40},
		{50, 50}
	};
	//*****************************************************//
	//* VARIABLES                                         *//
	//*****************************************************//
	public int rawHopper = 0;
	public double rate = 0;
	public boolean towards = true;
	public double distance = 0;
	
	// accelerometer
	public Accelerometer acell = new Accelerometer(1);
	 double angle =0;
	// Create the joystick and of the 8 buttons on 
  
  
	public double verticalAimCurentPosition = 0;
	public int OperatingMode = 0;
	
	public double ClimberCurrentPosition = 0;
	
	public double FeederCurrentPosition = 0;

	public double Feedercnt = 0;
	public boolean ShooterReady = false;
	
	Joystick leftJoy = new Joystick(3);
	Button leftbutton1 = new JoystickButton(leftJoy, 1),
			leftbutton2 = new JoystickButton(leftJoy, 2),
			leftbutton3 = new JoystickButton(leftJoy, 3),
			leftbutton4 = new JoystickButton(leftJoy, 4),
			leftbutton5 = new JoystickButton(leftJoy, 5),
			leftbutton6 = new JoystickButton(leftJoy, 6),
			leftbutton7 = new JoystickButton(leftJoy, 7),
			leftbutton8 = new JoystickButton(leftJoy, 8),
			leftbutton9 = new JoystickButton(leftJoy, 9),
			leftbutton10 = new JoystickButton(leftJoy, 10),
			leftbutton11 = new JoystickButton(leftJoy, 11);
	Joystick rightJoy = new Joystick(1);
	Button rightbutton1 = new JoystickButton(rightJoy, 1),
			rightbutton2 = new JoystickButton(rightJoy, 2),
			rightbutton3 = new JoystickButton(rightJoy, 3),
			rightbutton4 = new JoystickButton(rightJoy, 4),
			rightbutton5 = new JoystickButton(rightJoy, 5),
			rightbutton6 = new JoystickButton(rightJoy, 6),
			rightbutton7 = new JoystickButton(rightJoy, 7),
			rightbutton8 = new JoystickButton(rightJoy, 8),
			rightbutton9 = new JoystickButton(rightJoy, 9),
			rightbutton10 = new JoystickButton(rightJoy, 10),
			rightbutton11 = new JoystickButton(rightJoy, 11);
	Joystick shooterJoy = new Joystick(2);
	Button shooterbutton1 = new JoystickButton(shooterJoy, 1),
			shooterbutton2 = new JoystickButton(shooterJoy, 2),
			shooterbutton3 = new JoystickButton(shooterJoy, 3),
			shooterbutton4 = new JoystickButton(shooterJoy, 4),
			shooterbutton5 = new JoystickButton(shooterJoy, 5),
			shooterbutton6 = new JoystickButton(shooterJoy, 6),
			shooterbutton7 = new JoystickButton(shooterJoy, 7),
			shooterbutton8 = new JoystickButton(shooterJoy, 8),
			shooterbutton9 = new JoystickButton(shooterJoy, 9),
			shooterbutton10 = new JoystickButton(shooterJoy, 10);
	
	static final double MaxAimDistanceAdjustment = 60;

	//Joystick shooterJoy til new Joystick(4);
	/**
	 * Bind the press of each button to a specific command or command group.
	 */
	public OI() {
		//System.out.println("IO: OperatingMode BEGIN : " + OI.OperatingMode);
		//edu.wpi.first.wpilibj.networktables2.util.List ntutillist = new edu.wpi.first.wpilibj.networktables2.util.List(); 
		//edu.wpi.first.wpilibj.networktables2.util.Stack ntutilstack = new edu.wpi.first.wpilibj.networktables2.util.Stack(); 
		//System.out.print("ntstack : " + ntutilstack + "\n");

		//rightbutton7.whenPressed(new ShooterMotorForward());
		// need to map buttons to commands 
		// BUTTON1 is the trigger
		
		leftbutton2.whenPressed(new SetOperatingMode(tankModeLeftandRight));
	    leftbutton3.whileHeld(new SetOperatingMode(StraightDriveForward));
		leftbutton3.whenReleased(new SetOperatingMode(tankModeLeftandRight)); 
		leftbutton4.whenPressed(new SetOperatingMode(climberModeLeft));
		leftbutton5.whenPressed(new SetOperatingMode(shooterModeLeft)); 
		leftbutton8.whenPressed(new FeederPush());
		leftbutton9.whenPressed(new SetOperatingMode(AutoAim));
		leftbutton10.whenPressed(new ShooterMotorForward());
		leftbutton11.whenPressed(new ShooterMotorStop());

		rightbutton2.whenPressed(new SetOperatingMode(tankModeLeftandRight));		
		rightbutton3.whileHeld(new SetOperatingMode(StraightDriveForward));
		rightbutton3.whenReleased(new SetOperatingMode(tankModeLeftandRight));
		rightbutton4.whenPressed(new SetOperatingMode(climberModeRight));
		rightbutton5.whenPressed(new SetOperatingMode(shooterModeRight));
		rightbutton8.whenPressed(new FeederPush());
		rightbutton9.whenPressed(new SetOperatingMode(AutoAim));
		rightbutton10.whenPressed(new ShooterMotorForward());
		rightbutton11.whenPressed(new ShooterMotorStop());

		shooterbutton1.whenPressed(new SetOperatingMode(AutoAim));
		shooterbutton2.whenPressed(new SetOperatingMode(tankModeLeftandShooter));
		shooterbutton3.whenPressed(new SetOperatingMode(tankModeLeftandRight));
		shooterbutton4.whenPressed(new SetOperatingMode(tankModeRightandShooter));
		shooterbutton7.whenPressed(new ShooterMotorStop());
		shooterbutton5.whenPressed(new SetOperatingMode(climberModeShooter));
		shooterbutton6.whenPressed(new SetOperatingMode(shooterModeShooter));
		shooterbutton9.whenPressed(new ShooterMotorForward());
		shooterbutton10.whenPressed(new FeederPush());

		ITableListener itl = new ITableListener() 
		{
			public void valueChanged(ITable table, String name, Object o, boolean bln) {
				X5MULT = table.getNumber("X5MULT");
				X4MULT = table.getNumber("X4MULT");
				X3MULT = table.getNumber("X3MULT");
				X2MULT = table.getNumber("X2MULT");
				X1MULT = table.getNumber("X1MULT");
				X0MULT = table.getNumber("X0MULT");

				Mult1[0] = table.getNumber("X0MULT");
				Mult1[1] = table.getNumber("X1MULT");
				Mult1[2] = table.getNumber("X2MULT");
				Mult1[3] = table.getNumber("X3MULT");
				Mult1[4] = table.getNumber("X4MULT");
				Mult1[5] = table.getNumber("X5MULT");
			}
		};
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putNumber("X5MULT", X5MULT);
		table.putNumber("X4MULT", X4MULT);
		table.putNumber("X3MULT", X3MULT);
		table.putNumber("X2MULT", X2MULT);
		table.putNumber("X1MULT", X1MULT);
		table.putNumber("X0MULT", X0MULT);
		table.addTableListener(itl);
		//System.out.println("IO: OperatingMode END : " + OI.OperatingMode);
	}

	public double speedf(double speed) {
		return speed;
	}
	/*
	 public double conditionDriveTrainSpeed(double speed) {
	 if (Math.abs(speed) < .13) { return 0; }
	 double sign = Math.abs(speed)/speed;
	 return SmartDashboard.getNumber("DriveSpeed", 0.0) * sign; 
	 }
	 */
	static double[] Mult1 = {
		0.3015,
		0.3731,
		0, 0,
		0, 0,};
	static double[] Mult2 = {
		1.1636,
		-2.1269,
		1.7839,};
	static double X5MULT = 0,
			X4MULT = 0,
			X3MULT = 0,
			X2MULT = 0,
			X1MULT = 0.3731,
			X0MULT = 0.3015;

	public double conditionDriveTrainSpeed(double speed) {
		double aspeed = Math.abs(speed);
		double value;
		if (aspeed < 0.13) {
			return 0;
		}
		if (aspeed > 0.95) {
			value = 1;
		} else if (aspeed >= .8 && aspeed <= .95) {
			value =
					6 * MathUtils.pow(aspeed, 2)
					+ -9.18 * MathUtils.pow(aspeed, 1)
					+ 4.055;
		} else {
			value =
					X5MULT * MathUtils.pow(aspeed, 5)
					+ X4MULT * MathUtils.pow(aspeed, 4)
					+ X3MULT * MathUtils.pow(aspeed, 3)
					+ X2MULT * MathUtils.pow(aspeed, 2)
					+ X1MULT * MathUtils.pow(aspeed, 1)
					+ X0MULT;
		}
		value *= aspeed / speed; // re-add the sign
		return value;
	}

	public double getLeftSpeed() {
		double speed = conditionDriveTrainSpeed(leftJoy.getY());
		SmartDashboard.putNumber("LSpeed", speed);
		return speed;
	}

	public double getLeftHorizontal() {

		double lefthorizontal = conditionDriveTrainSpeed(leftJoy.getX());
		lefthorizontal = lefthorizontal * (-1);
		if (Math.abs(lefthorizontal) < JoyStickSoftener) {
			lefthorizontal = 0;
		}
		return lefthorizontal;
	}

	/**
	 * @return The value of the right joystick. Note: this uses raw axis because
	 * we have a logitech joystick that resembles a PS controller.
	 */
	public double getRightSpeed() {
		double speed = conditionDriveTrainSpeed(rightJoy.getY());
		SmartDashboard.putNumber("RSpeed", speed);
		return speed;
	}

	public double getRightHorizontal() {
		double righthorizontal = conditionDriveTrainSpeed(rightJoy.getX());
		if (Math.abs(righthorizontal) < JoyStickSoftener) {
			righthorizontal = 0;
		}
		return righthorizontal;
	}

	public double getShooterDrivepeed() {
		double Speed = conditionDriveTrainSpeed(shooterJoy.getY());
		//double VerticalAimSpeed =shooterJoy.getRawAxis(7);
		//double VerticalAimSpeed =shooterJoy.getRawAxis(4);
		if (Math.abs(Speed) < JoyStickSoftener) {
			Speed = 0;
		}
		return Speed;
	}

	public double getVerticalAimSpeed() {
		double speed = shooterJoy.getY();
		double sign=1;
		if (Math.abs(speed) < 0.13) {
			speed = 0;
		} else 
		{
			speed = 1;
		}
			speed = speed * sign; 
		return speed;
	}

	/*
	 feederEncoder.start();
	 return feederEncoder.getRate();
	 /*
	 if (1 ==0){
	 double rawHopper = feederEncoder.getRaw();}
	 double rate = feederEncoder.getRate();
	 double ditance = feederEncoder.getDistance();
	 double VerticalAimSpeed = shooterJoy.getY();   
		
	 //double VerticalAimSpeed =shooterJoy.getRawAxis(7);
	 //double VerticalAimSpeed =shooterJoy.getRawAxis(4);
	 if(Math.abs(VerticalAimSpeed) < JoyStickSoftener)
	 {
	 VerticalAimSpeed=0;
	 } 
	 return VerticalAimSpeed;*/
	//}
	public double getAutoAimVerticalSpeed() {
		double AimSpeed = 0;
		double AimDelta = 0;
		double Distance = 0;
		Distance += SmartDashboard.getNumber("Distance", 0);
		Distance += SmartDashboard.getNumber("Distance1", 0);
		Distance += SmartDashboard.getNumber("Distance2", 0);
		Distance += SmartDashboard.getNumber("Distance3", 0);
		Distance += SmartDashboard.getNumber("Distance4", 0);
		Distance += SmartDashboard.getNumber("Distance5", 0);
		AimDelta += SmartDashboard.getNumber("/10.46.11.30/VOff", 0);

		String test = SmartDashboard.getString("mytest");
		System.out.print("mytest : " + test + "\n");

		AimDelta += SmartDashboard.getNumber("/SmartDashboard/VOff", 0);
		AimDelta += SmartDashboard.getNumber("/SmartDashboard/VOff", 0);
		AimDelta += SmartDashboard.getNumber("/RoboRealm/VOff", 0);
		AimDelta += SmartDashboard.getNumber("/RoboRealm/VOff", 0);
		AimDelta += SmartDashboard.getNumber("VOff", 0);
		AimDelta += SmartDashboard.getNumber("Vff1", 0);
		AimDelta += SmartDashboard.getNumber("VOff2", 0);
		AimDelta += SmartDashboard.getNumber("VOff3", 0);
		AimDelta += SmartDashboard.getNumber("VOff4", 0);
		AimDelta += SmartDashboard.getNumber("VOff5", 0);
		System.out.print("V AimDelta : " + AimDelta + "\n");
		double AimDeltaAvg = AimDelta / 5;
		double AimDistanceAvg = AimDelta / 5;
		int idx;
		for (idx = 0; idx < AimDistanceAdjustment.length; idx++) {
			if (AimDistanceAvg < AimDistanceAdjustment[idx][0]) {
				AimSpeed = AimDeltaAvg - AimDistanceAdjustment[idx][0];
				break;
			}
		}
		if (idx == AimDistanceAdjustment.length) {
			AimSpeed = AimDeltaAvg - MaxAimDistanceAdjustment;
		}
		if (Math.abs(AimSpeed) > AimVerticalSoftener) {
			AimSpeed = AimDefaultSpeed; // aim set to a specific speed
			SmartDashboard.putString("Aim Vertical Lock :", "Not Locked");
		} else {
			AimSpeed = 0; // locked within tolerance
			SmartDashboard.putString("Aim Vertical Lock :", "Locked");
		}
		return AimSpeed;
	}

	public double getAutoAimHorizontalSpeed() {
		double AimSpeed = 0;
		double AimDelta = 0;
		double Distance = 0;
		Distance += SmartDashboard.getNumber("Distance", 0);
		Distance += SmartDashboard.getNumber("Distance1", 0);
		Distance += SmartDashboard.getNumber("Distance2", 0);
		Distance += SmartDashboard.getNumber("Distance3", 0);
		Distance += SmartDashboard.getNumber("Distance4", 0);
		Distance += SmartDashboard.getNumber("Distance5", 0);
		AimDelta += SmartDashboard.getNumber("HOff", 0);
		AimDelta += SmartDashboard.getNumber("HOff1", 0);
		AimDelta += SmartDashboard.getNumber("HOff2", 0);
		AimDelta += SmartDashboard.getNumber("HOff3", 0);
		AimDelta += SmartDashboard.getNumber("HOff4", 0);
		AimDelta += SmartDashboard.getNumber("HOff5", 0);
		System.out.print("H AimDelta : " + AimDelta + "\n");
		System.out.print("Distance : " + AimDelta + "\n");
		double AimDeltaAvg = AimDelta / 5;
		double AimDistanceAvg = AimDelta / 5;
		int idx = 0;
		if (Math.abs(AimSpeed) > AimHorizontalSoftener) {
			AimSpeed = AimDefaultSpeed; // aim set to a specific speed
			SmartDashboard.putString("Aim Horizonal Lock :", "Not Locked");
		} else {
			AimSpeed = 0; // locked within tolerance
			SmartDashboard.putString("Aim Horizontal Lock :", "Locked");
		}
		return AimSpeed;
	}

	public double getHorizontalAimSpeed() {
		double speed = shooterJoy.getX();
		if (Math.abs(speed) < 0.13) {
			speed = 0;
		} else {
			double sign = Math.abs(speed) / speed;
			//speed = 0.35 * sign;
		}
		return speed;
	}
	public double acceleration(){
	double daccel = acell.getAcceleration();
	double placeHolder = 180 * Math.sin(daccel);
	angle = placeHolder / Math.PI;
	   return angle;
	}
// encoder methods
public int getRaw(){
rawHopper = feederEncoder.getRaw();
    return rawHopper;

}
public double getRate(){
   rate = feederEncoder.getRate();
   return rate;        }

public boolean getDirection(){
   towards = feederEncoder.getDirection();
       return towards;
                             }

public void pulseDistance(){
    feederEncoder.setDistancePerPulse(360.0);                       
                           }
public double distance(){
distance = feederEncoder.getDistance();
   return distance;     }

public void reset(){
feederEncoder.reset();
                   }


}
