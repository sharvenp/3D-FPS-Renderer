package main;

import utils.UtilFunctions;
import java.lang.Math;

/**
 * Raycaster module for the player that handles the raycasting information.
 * 
 * @author sharvenp
 */
public class Raycaster {

	private Player player;
	
	public Raycaster(Player player) {
		this.player = player;
	}
	
	public RaycastHit[] castRays() {
		RaycastHit[] hits = new RaycastHit[Settings.numRays];
		
		int startAngle = this.player.getLookAngle() - (Settings.fov / 2);
		int angleDelta = Settings.fov / Settings.numRays;
		System.out.println(angleDelta);
		
		for (int ray = 1; ray < Settings.numRays; ray++) {
			int angle = startAngle + (angleDelta * ray);
			hits[ray] = this.castRay(UtilFunctions.clampAngle(angle));
		}
		
		return hits;
	}
	
	private RaycastHit castRay(int angle) {
		
		int x0 = player.getPosition()[0];
		int y0 = player.getPosition()[1];
		int x1 = x0 + (int) (Settings.maxRayDistance * Math.cos(Math.toRadians(angle)));
		int y1 = y0 + (int) (Settings.maxRayDistance * Math.sin(Math.toRadians(angle)));
		
	    boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
	    
	    if (steep) {
	        int[] swap1 = UtilFunctions.swap(x0, y0); 
	    	x0 = swap1[0];
	    	y0 = swap1[1];
	    	int[] swap2 = UtilFunctions.swap(x1, y1);
	        x1 = swap2[0];
	        y1 = swap2[1];
	    }

	    if (x0 > x1) {
	        int[] swap1 = UtilFunctions.swap(x0, x1); 
	    	x0 = swap1[0];
	    	x1 = swap1[1];
	    	int[] swap2 = UtilFunctions.swap(y0, y1);
	        y0 = swap2[0];
	        y1 = swap2[1];
	    }

	    int deltax = x1 - x0;
	    int deltay = Math.abs(y1 - y0);
	    int error = 0;
	    int ystep;
	    int y = y0;
	    
	    if (y0 < y1) ystep = 1; else ystep = -1;
	    for (int x = x0; x <= x1; x++) {
	       
	    	if (steep) {
	        	if (Map.getValue(y, x) == 1) {
	        		// hit wall
	        		return new RaycastHit(UtilFunctions.distance(x0, y0, y, x), Map.getValue(y, x));
	        	}
	        }
	        else {
	        	if (Map.getValue(x, y) == 1) {
	        		// hit wall
	        		return new RaycastHit(UtilFunctions.distance(x0, y0, x, y), Map.getValue(x, y));
	        	}
	        }

	        error += deltay;
	        if (2 * error >= deltax) {
	            y += ystep;
	            error -= deltax;
	        }
	    }
		
		return null;
	}
}
