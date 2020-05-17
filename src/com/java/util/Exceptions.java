package com.java.util;

public class Exceptions {
	/**
	 * this method will freeze the browser 
	 * @param number
	 */
	public static void sleep(int number) {
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
