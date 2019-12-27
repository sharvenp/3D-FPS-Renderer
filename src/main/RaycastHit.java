package main;

/**
 * Holds information about the object a ray has collided with.
 * 
 * @author sharvenp
 */
public class RaycastHit {

	private double distance;
	private int obstacleType;
	
	public RaycastHit(double distance, int obstacleType) {
		this.distance = distance;
		this.obstacleType = obstacleType;
	}

	public double getDistance() {
		return distance;
	}

	public int getObstacleType() {
		return obstacleType;
	}
	
}
