
package edu.wpi.first.wpilibj.templates.commands;

import InsightLT.DecimalData;
import InsightLT.InsightLT;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john
 */
public class MessageTest extends Thread {
    
	InsightLT display;
	DriverStation station;
	DecimalData disp_voltage;
	
    public MessageTest() {
        display = new InsightLT(InsightLT.TWO_ONE_LINE_ZONES);
	    station = DriverStation.getInstance();
		
		display.startDisplay();
		disp_voltage = new DecimalData("Volts: ");
		display.registerData(disp_voltage, 1);
	}

    // Called repeatedly when this Command is scheduled to run
    public void run() {
		try {
			while(true) {
				updateData();
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}
    }
	
	public void updateData() {
		double voltage = station.getBatteryVoltage();
		disp_voltage.setData(voltage);
	}
}
