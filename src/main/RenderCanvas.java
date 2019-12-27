package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utils.Observable;
import utils.Observer;
import utils.UtilFunctions;

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
		
		// Draw roof
		gc.setFill(Settings.ceilColor);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight()/2);
		
		// Draw Floor
		gc.setFill(Settings.floorColor);
		gc.fillRect(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
				
		RaycastHit[] rayData = player.getRayData();
		
		for (int i = 0; i < Settings.numRays; i++) {
			RaycastHit ray = rayData[i];
			if (ray == null) {
				continue;
			}
			double planarDistance = ray.getPlanarDistance();
			if (planarDistance > 0) {
				int wallHeight = (int) (Settings.maxRectangleHeight / planarDistance);
				double percentage = ray.getTrueDistance() / Settings.maxRayDistance;
				int colorValue = (int) (255 * (1 - percentage));
				Color color = Color.rgb(colorValue, colorValue, colorValue);
				gc.setFill(color);
				System.out.println(wallHeight + " " + colorValue);
				gc.fillRect(Settings.rectangleWidth * i, (this.getHeight() - wallHeight) / 2, wallHeight, Settings.rectangleWidth);
			}
		}
		
	}
}
