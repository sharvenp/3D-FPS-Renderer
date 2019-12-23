package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utils.Observable;
import utils.Observer;

import java.lang.Math;

public class RenderCanvas extends Canvas implements Observer {

	public RenderCanvas(int width, int height) {
		super(width, height);
	}
	
	public void update(Observable o) {
		
		Game game = (Game) o;
		Player player = game.getPlayer();
		
		GraphicsContext gc = this.getGraphicsContext2D();
		
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
		gc.setFill(Color.RED);
		
		int px = player.getPosition()[0];
		int py = player.getPosition()[1];
		int angle = player.getLookAngle();
		
		gc.fillOval(px, py, 10, 10);
		
		gc.setStroke(Color.GREEN);
		gc.strokeLine(px + 5, py + 5, px + 5 + 20*Math.cos(Math.toRadians(angle)), py + 5 + 20*Math.sin(Math.toRadians(angle)));
	}
}
