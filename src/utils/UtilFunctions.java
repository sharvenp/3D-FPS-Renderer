package utils;

import java.lang.Math;

/**
 * Contains all utility functions that are used by various classes.
 * 
 * @author sharvenp
 */
public class UtilFunctions {

	public static int clampAngle(int angle) {
		angle %= 360;

		if (angle < 0)
		{
			angle += 360;
		}
		
		return angle;
	}
	
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public static int[] swap(int a, int b) {
		int[] swapped = {b, a};
		return swapped;
	}
	
}
