package game;

import javafx.application.Platform;
import javafx.scene.paint.Color;

public class GameEngine implements Runnable {

	private final double UPDATE_CAP = 1.0/60.0;
	private GameScene scene;
	
	
	public GameEngine(GameScene scene) {
		this.scene = scene;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		boolean render = false;
		
		double firstTime = 0, passedTime = 0, unprocessedTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double frameTime = 0, frames = 0, fps = 0;
		
		while(!Thread.currentThread().interrupted()) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
				//Update game
				if (scene.board.isTouchingTop(scene.ball1) || scene.board.isTouchingBottom(scene.ball1)) {
					scene.ball1.reflectVertical();
				}
				if (scene.board.isTouchingLeft(scene.ball1) || scene.board.isTouchingRight(scene.ball1)) {
					scene.ball1.reflectHorizontal();
				}
				scene.ball1.updatePosition();
				// Adjust frame values
				if (frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
			}
			
			if (render) {
				//TODO: Render game
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						scene.ball1.setFill(Color.GREEN);
					}
				});
				frames++;
			}
		}
		System.out.println("Game is done");
	}
}
