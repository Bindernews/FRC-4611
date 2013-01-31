/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 * @author Bindernews
 */
public class MultiButton extends Trigger {
	
	private GenericHID[] joystickArray;
	private int[] buttonIdArray;
	private int buttonCount;
	
	public MultiButton() {
		this(10);
	}
	
	public MultiButton(int numButtons) {
		joystickArray = new GenericHID [ numButtons ];
		buttonIdArray = new int [ numButtons ];
		buttonCount = 0;
	}
	
	public void add(GenericHID joystick, int buttonId) {
		joystickArray[buttonCount] = joystick;
		buttonIdArray[buttonCount] = buttonId;
		buttonCount++;
	}
	
	public boolean getAll() {
		for(int i=0; i<buttonCount; i++) {
			if (get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean get(int i) {
		return joystickArray[i].getRawButton(buttonIdArray[i]);
	}

	public boolean get() {
		return getAll();
	}
	
}
