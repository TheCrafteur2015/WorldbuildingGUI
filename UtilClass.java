/**
 * 
 */
package com.atlonos.actions;

import java.util.Random;

/**
 * {@code UtilClass} is a multi-purpose utility class with various methods.
 * 
 * Date : 19 janv. 2023
 * 
 * @author Gabriel ROCHE
 * @version 1.0
 */
public class UtilClass {

	static Random rd = new Random();
	
	private UtilClass() {
	}

	/**
	 * 
	 * @param in
	 * @return
	 * @since 1.0
	 */
	public static int length(int in) {
		return ("" + in).length();
	}

	/**
	 * 
	 * @param x
	 * @since 1.0
	 */
	public static void sleep(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			System.out.println("Timed out!");
		}
	}

	/**
	 * 
	 * @param c
	 * @return
	 * @since 1.0
	 */
	public static boolean isLetter(char c) {
		if (c >= 'A' && c <= 'Z')
			return true;
		
		if (c >= 'a' && c <= 'z')
			return true;

		return false;
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double randomDouble(double min, double max) throws IllegalArgumentException {
		if ( min >= max ) throw new IllegalArgumentException("Mininum value cannot be superior than maximum: " + min + " > " + max);
		return rd.nextDouble(max - min + 1) + min;
	}
	
	public static int randomInt(int min, int max) throws IllegalArgumentException {
		if ( min >= max ) throw new IllegalArgumentException("Mininum value cannot be superior than maximum: " + min + " > " + max);
		return rd.nextInt(max - min + 1) + min;
	}
	
	public static String randomVal(String... arr) {
		return arr[ rd.nextInt( arr.length ) ];
	}
	
	public static char randomVal(char... arr) {
		return arr[ rd.nextInt( arr.length ) ];
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean containInt(String s) {
		try {
			for (int i = 0; i < s.length(); i++) {
				Integer.parseInt( s.substring(i, i + 1) );
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static boolean isBoolean(String s) {
		return Boolean.parseBoolean(s);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static int toInt(String s) {
		if ( isInt(s) ) {
			return Integer.parseInt(s);
		} else {
			return -1;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static double toDouble(String s) {
		if ( isDouble(s) ) {
			return Double.parseDouble(s);
		} else {
			return -1.0;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @since 1.0
	 */
	public static boolean toBoolean(String s) {
		return Boolean.parseBoolean(s);
	}

	/**
	 * 
	 * @param c
	 * @return
	 * @since 1.0
	 */
	public static char toUpperCase(char c) {
		return ("" + c).toUpperCase().charAt(0);
	}

	/**
	 * 
	 * @param c
	 * @return
	 * @since 1.0
	 */
	public static char toLowerCase(char c) {
		return ("" + c).toLowerCase().charAt(0);
	}

	/**
	 * 
	 * @param value
	 * @param sign
	 * @return
	 * @since 1.0
	 */
	public static double round(double value, double sign) {
		return Math.round( value * sign ) / sign;
	}
	
	public static int charNum(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if ( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ) num++;
			if ( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) num++;
		}
		return num;
	}
	
	public static void timeout() {
		timeout(10);
	}
	
	public static void timeout(int delay) {
		
		sleep(delay);
		Object object = new Object();
		try {
			object.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String charToString(char[] arrC) {
		
		String res = "";
		
		for (int i = 0; i < arrC.length; i++)
			res += arrC[i];
		
		return res;
		
	}

}