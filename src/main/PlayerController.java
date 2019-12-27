package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Parse keyboard input and update player accordingly.
 * 
 * @author sharvenp
 */
public class PlayerController implements EventHandler<KeyEvent> {

	private Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	public void handle(KeyEvent k) {
		
		if (k.getCode() == KeyCode.W) {
			this.player.moveForward();
		} else if (k.getCode() == KeyCode.S) {
			this.player.moveBackward();
		} 
		
		if (k.getCode() == KeyCode.A) {
			this.player.turnLeft();
		} else if (k.getCode() == KeyCode.D) {
			this.player.turnRight();
		}
	}
}
