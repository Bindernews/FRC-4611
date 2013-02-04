/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.utils;

import edu.wpi.first.wpilibj.NamedSendable;

/**
 *
 * @author Bindernews
 */
public class NamedMultiButton extends MultiButton implements NamedSendable {

	private String tableName;
	
	public NamedMultiButton(String name) {
		super();
		tableName = name;
	}
	
	public NamedMultiButton(String name, int numButtons) {
		super(numButtons);
		tableName = name;
	}
	
	public String getName() {
		return tableName;
	}
	
}
