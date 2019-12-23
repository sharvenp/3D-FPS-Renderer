package main;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Renderer  {

	Stage stage;
	PlayerController controller;
	Game game;
	
	public Renderer(Stage stage, PlayerController controller, Game game) {
		this.stage = stage;
		this.controller = controller;
		this.game = game;
		
		this.initUI();
	}
	
	private void initUI() {
		
		RenderCanvas renderCanvas = new RenderCanvas(Map.getWidth(), Map.getHeight());
		renderCanvas.setFocusTraversable(true);
//		renderCanvas.addEventHandler(KeyEvent.ANY, this.controller);
		game.addObserver(renderCanvas);
		
		Pane root = new Pane();
		root.setStyle("-fx-background-color: black");
		root.getChildren().add(renderCanvas);
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(controller);
		this.stage.setScene(scene);
		this.stage.setTitle("FPS Renderer");
		stage.show();
	}
	
}
