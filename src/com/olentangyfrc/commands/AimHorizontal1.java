/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.sun.squawk.util.Arrays;
import com.sun.squawk.util.MathUtils;


/**
 *
 * @author Bindernews
 */
public class AimHorizontal1 extends DrivingCommand {

	private static final int SAMPLES = 10;
	private final double[]
			bufferH = new double[SAMPLES],
			bufferD = new double[SAMPLES];
	
	private double
			averageH = 0,
			averageD = 0,
			blank = SAMPLES,
			lastAverageV = 0;
	private final int
			CENTERX = 320,
			CENTERY = 240,
			THREEPOINT = 110,
			TWOPOINT = 99;
	
	public static final double LOW_SPEED = 0.351;
	
	public AimHorizontal1() {
		super("AimHorizontal");
	}

	protected void initialize() {
		driveLock();
		Arrays.fill(bufferH, 0);
		Arrays.fill(bufferD, 0);
	}

	protected void execute() {
		if (!driveEnabled()) { return; }
		for(int i=0; i<SAMPLES-1; i++) {
			bufferH[i] = bufferH[i+1];
			bufferD[i] = bufferD[i+1];
		}
		
		double HoffTemp = 0;
		double distTemp = 0;
		HoffTemp = ozone.getNumber("Hoff");
		distTemp = ozone.getNumber("distance");
		if (HoffTemp - averageH < Math.abs(averageH * 0.5)) {
			bufferH[SAMPLES - 1] = HoffTemp;
		}
		if (distTemp - averageD < Math.abs(averageD * 0.5)) {
			bufferD[SAMPLES - 1] = distTemp;
		}
		for( int i = 0; i < SAMPLES; i++) {
			if (bufferH[i] != 0){
				averageH += bufferH[i];
			}
			if (bufferD[i] != 0) {
				averageD += bufferD[i];
			}
			if (blank > 0) {
				blank --;
			}
		}
		averageH /= bufferH.length - blank;
		averageD /= bufferD.length - blank;
		
		double targetAngle = getTargetAngle3();
		// move motors
//		if (acceleration() - targetAngle > (250 / averageD)) {
//			elevatorSub.setSpeed(-LOW_SPEED);
//		}
//		if (acceleration() - targetAngle < -(250 / averageD)) {
//			elevatorSub.setSpeed(LOW_SPEED);
//		}
		
		if(CENTERX - (averageH) > (250 / averageD)) {
			driveTrain.tankDrive(-LOW_SPEED, -LOW_SPEED);
		}
		if (CENTERX - (averageH) < (250 / averageD)) {
			driveTrain.tankDrive(LOW_SPEED, LOW_SPEED);
		}
	}

	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		driveTrain.stop();
	}
	
	public double getTargetAngle3() {
		// courtesy of the Beshara Theorem
		double targetAngle = MathUtils.pow(127.66 * averageD, -.622);
		return targetAngle;
	}
	
	public double getAngle(){
		double theta = MathUtils.asin(THREEPOINT/averageD);
		return theta;
	}
	
}
