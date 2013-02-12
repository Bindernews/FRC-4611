/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olentangyfrc.utils;

/**
 *
 * @author Bindernews
 */
public class Stopwatch {

	private long baseTime;
	
	public Stopwatch() {
		baseTime = currentTime();
	}
	
	public void reset() {
		baseTime = currentTime();
	}
	
	public long runTime() {
		return currentTime() - baseTime;
	}
	
	public boolean isBefore(long time) {
		return runTime() < time;
	}
	
	public boolean isAfter(long time) {
		return runTime() > time;
	}
	
	public boolean isAtAfter(long time) {
		return runTime() >= time;
	}
	
	public boolean isAtBefore(long time) {
		return runTime() <= time;
	}
	
	public boolean isBetween(long begin, long end) {
		return runTime() > begin && runTime() < end;
	}
	
	public boolean isAtBetween(long begin, long end) {
		return runTime() >= begin && runTime() <= end;
	}
	
	public static long currentTime() {
		return System.currentTimeMillis();
	}
	
}
