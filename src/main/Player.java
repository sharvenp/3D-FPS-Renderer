package main;

import utils.Observable;
import java.lang.Math;

/**
 * 
 * This class maintains the state of the player.
 * 
 * @author sharvenp
 */
public class Player extends Observable {

	private int px;
	private int py;
	private int lookAngle;
	
	private int moveSpeed = 4;
	private int angularSpeed = 5;
	
	public Player(int px, int py) {
		this.setPosition(px, py);
		this.lookAngle = 0;
	}
	
	public void moveForward() {
		int dx = (int) (moveSpeed * Math.cos(Math.toRadians(this.lookAngle)));
		int dy = (int) (moveSpeed * Math.sin(Math.toRadians(this.lookAngle)));
		
		this.move(dx, dy);
	}
	
	public void moveBackward() {
		int dx = (int) (moveSpeed * Math.cos(Math.toRadians(this.lookAngle)));
		int dy = (int) (moveSpeed * Math.sin(Math.toRadians(this.lookAngle)));
		
		this.move(-dx, -dy);
	}
	
	public void turnLeft() {
		this.turn(-this.angularSpeed);
	}
	
	public void turnRight() {
		this.turn(this.angularSpeed);
	}
	
	private void move(int dx, int dy) {
		int newX = px + dx;
		int newY = py + dy;
		
		if (Map.checkInBound(newX, newY)) {
			if (Map.getValue(newX, newY) == 0) {
				this.setPosition(newX, newY);
			}
		}
	}
		
	private void turn(int dAngle) {
		this.lookAngle += dAngle;
		
		this.lookAngle %= 360;

		if (this.lookAngle < 0)
		{
		    this.lookAngle += 360;
		}
		
		this.notifyObservers();
	}
	
	private void setPosition(int px, int py) {
		this.px = px;
		this.py = py;
		this.notifyObservers();
	}
	
	public int[] getPosition() {
		int[] position = {this.px, this.py}; 
		return position;
	}
	
	public int getLookAngle() {
		return this.lookAngle;
	}
	
	public String toString() {
		return this.px + " " + this.py + " " + this.lookAngle; 
	}
	
}
