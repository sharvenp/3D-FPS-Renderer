package main;

import utils.Observable;
import utils.Observer;

/**
 * The backend game class. Maintains the map data, player position,
 * and ray-cast calculations.
 * 
 * @author sharvenp
 */
public class Game extends Observable implements Observer {

	
	private Player player;
	private PlayerController controller;
	
	public Game() {
		
		Map.readMap("map.png");
		this.player = new Player(0, 0);		
		player.addObserver(this);
		
		this.controller = new PlayerController(player);
	
	}

	public PlayerController getPlayerController() {
		return this.controller;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void update(Observable o) {
		this.notifyObservers();
	}
	
}
