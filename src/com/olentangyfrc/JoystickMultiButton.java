/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author Bindernews
 */
public class JoystickMultiButton extends Trigger {
	
	private GenericHID[] joystickArray;
	private int[] buttonIdArray;
	private int buttonCount;
	
	public JoystickMultiButton() {
		this(10);
	}
	
	public JoystickMultiButton(int numButtons) {
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
	
	/**
     * Starts the given command whenever the trigger just becomes active.
     * @param command the command to start
     */
    public void whenActive(final Command command) {
		Trigger.ButtonScheduler btn = new Trigger.ButtonScheduler() {
			boolean pressedLast = getAll();
			public void execute() {
				if (getAll()) {
					if (!pressedLast) {
						pressedLast = true;
						command.start();
					}
				} else {
					pressedLast = false;
				}
			}
		};
		Scheduler.getInstance().addButton(btn);
    }
	
	public void whileActive(final Command command) {
        Trigger.ButtonScheduler btn = new Trigger.ButtonScheduler() {
            boolean pressedLast = getAll();
            public void execute() {
                if (getAll()) {
                    pressedLast = true;
                    command.start();
                } else {
                    if (pressedLast) {
                        pressedLast = false;
                        command.cancel();
                    }
                }
            }
		};
		Scheduler.getInstance().addButton(btn);
    }

	public boolean get() {
		return getAll();
	}
	
}
