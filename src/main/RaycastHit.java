package main;

/**
 * Holds information about the object a ray has collided with.
 * 
 * @author sharvenp
 */
public class RaycastHit {

	private double planarDistance;
	private double trueDistance;
	private int obstacleType;
	
	public RaycastHit(double planarDistance, double trueDistance, int obstacleType) {
		this.planarDistance = planarDistance;
		this.trueDistance = trueDistance;
		this.obstacleType = obstacleType;
	}

	public double getPlanarDistance() {
		return planarDistance;
	}
	
	public double getTrueDistance() {
		return this.trueDistance;
	}

	public int getObstacleType() {
		return obstacleType;
	}
	
}
