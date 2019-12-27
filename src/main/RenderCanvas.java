package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utils.Observable;
import utils.Observer;

import java.lang.Math;

/**
 * Renderer for the Canvas.
 * 
 * @author sharvenp
 */
public class RenderCanvas extends Canvas implements Observer {
	
	public RenderCanvas(int width, int height) {
		super(width, height);
	}
	
	public void update(Observable o) {
		
		Game game = (Game) o;
		Player player = game.getPlayer();
		
		GraphicsContext gc = this.getGraphicsContext2D();
		
		// Clear screen
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		gc.setFill(Settings.floorColor);
		gc.fillRect(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		gc.setFill(Settings.ceilColor);
		gc.fillRect(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		
		
		int px = player.getPosition()[0];
		int py = player.getPosition()[1];
		int angle = player.getLookAngle();
		
		
	}
}
