package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class PlayerController implements EventHandler<KeyEvent> {

	private Player player;
	private HashMap<KeyCode, Boolean> keyMap;
	
	public PlayerController(Player player) {
		this.player = player;
		this.keyMap = new HashMap<KeyCode, Boolean>();
		this.resetKeyMap();
	}
	
	public void handle(KeyEvent k) {
		
		this.keyMap.put(k.getCode(), true);
		this.execute();
		
	}
	
	private void resetKeyMap() {
		this.keyMap.put(KeyCode.W, false);
		this.keyMap.put(KeyCode.A, false);
		this.keyMap.put(KeyCode.S, false);
		this.keyMap.put(KeyCode.D, false);
	}
	
	public void execute() {
		
		if (this.keyMap.get(KeyCode.W)) {
			this.player.moveForward();
		} else if (this.keyMap.get(KeyCode.S)) {
			this.player.moveBackward();
		} 
		
		if (this.keyMap.get(KeyCode.A)) {
			this.player.turnLeft();
		} else if (this.keyMap.get(KeyCode.D)) {
			this.player.turnRight();
		}
		
		this.resetKeyMap();
	}
}
