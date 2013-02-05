/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.commands;

import com.olentangyfrc.Ozone;

/**
 *
 * @author Bindernews
 */
public class ManualShoot extends ShootCommand {
	
	protected void execute() {
		if (Ozone.isDriveControl) { return; }
		super.execute();
	}
	
}
