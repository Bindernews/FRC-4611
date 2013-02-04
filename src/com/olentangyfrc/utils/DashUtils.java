/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.utils;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Bindernews
 */
public class DashUtils {
	
	public static final String dashName = "SmartDashboard";
	
	public static void addListener(String key, ITableListener listen) {
		NetworkTable.getTable(dashName).addTableListener(key, listen, false);
	}
}
