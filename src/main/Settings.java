package main;

import javafx.scene.paint.Color;

public class Settings {

	// Player FOV in degrees. Needs to be between 0 and 180 (not inclusive)
	public static int fov = 135;
		
	// The width of the drawn rectangles
	public static int rectangleWidth = 30;
	
	// The max height of a drawn rectangle
	public static int maxRectangleHeight = 300;
	
	// The number of rays casted by the raycaster
	public static int numRays = 20;
	
	// The max distance a ray will travel
	public static double maxRayDistance = 100f;
	
	
	// Colors
	public static Color floorColor = Color.GRAY;
	public static Color ceilColor = Color.DARKGRAY;
}
