package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class FPSApplication extends Application {

	Game game;
	Renderer renderer;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.game = new Game();
		this.renderer = new Renderer(stage, this.game.getPlayerController(), this.game);
	}

}
