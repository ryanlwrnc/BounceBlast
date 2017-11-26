package game;

import javafx.application.Platform;
import javafx.scene.paint.Color;
public class GameEngine implements Runnable {

	private final double UPDATE_CAP = 1.0/60.0;
	private GameScene scene;
	
	private boolean goingRight = true; //initial direction
	private boolean goingDown = false;
	private boolean goingLeft = false;
	private boolean goingUp = false;
	private double delta = 5;
	private double podLength = 50;
	
	public GameEngine(GameScene scene) {
		this.scene = scene;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		boolean render = false;
		
		double firstTime = 0, passedTime = 0, unprocessedTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double frameTime = 0, frames = 0, fps = 0;
		
		scene.h.setStartX(scene.board.getX());
		scene.h.setStartY(scene.board.getY());
		scene.h.setEndX(scene.board.getX());
		scene.h.setEndY(scene.board.getY());
		
		scene.v.setStartX(-100);
		scene.v.setStartY(-100);
		scene.v.setEndX(-100);
		scene.v.setEndY(-100);
		
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
						//Update game
						if (scene.board.isTouchingTop(scene.ball1) || scene.board.isTouchingBottom(scene.ball1)) {
							scene.ball1.reflectVertical();
						}
						if (scene.board.isTouchingLeft(scene.ball1) || scene.board.isTouchingRight(scene.ball1)) {
							scene.ball1.reflectHorizontal();
						}
						scene.ball1.updatePosition();
						
						// Move Platform Clockwise
						movePlatform();
						ballHitsPlatform();
					}
				});
				frames++;
			}
		}
		System.out.println("Game is done");
	}
	
	public void movePlatform() {
		if (goingRight) {
			//end
			//hasn't reached the end yet
			if (scene.h.getEndX() < scene.board.xmax()) {
				scene.h.setEndX(scene.h.getEndX() + delta);
			}
			else if (!goingDown){
				goingDown = true;
				scene.v.setStartX(scene.board.xmax());
				scene.v.setStartY(scene.board.getY());
				scene.v.setEndX(scene.board.xmax());
				scene.v.setEndY(scene.board.getY());
			}
			if (scene.h.getStartX() < scene.board.xmax()) {
				// pod growing in size
				if (scene.h.getEndX() - scene.board.getX() >= podLength) {
					scene.h.setStartX(scene.h.getStartX() + delta);
				}
				else if (scene.h.getEndX() >= scene.board.xmax()) {
					scene.h.setStartX(scene.h.getStartX() + delta);
				}
			}
			else {
				goingRight = false;
				scene.h.setStartX(-100);
				scene.h.setStartY(-100);
				scene.h.setEndX(-100);
				scene.h.setEndY(-100);
			}
		}
		if (goingDown) {
			//end
			//hasn't reached the end yet
			if (scene.v.getEndY() < scene.board.ymax()) {
				scene.v.setEndY(scene.v.getEndY() + delta);
			}
			else if (!goingLeft){
				goingLeft = true;
				scene.h.setStartX(scene.board.xmax());
				scene.h.setStartY(scene.board.ymax());
				scene.h.setEndX(scene.board.xmax());
				scene.h.setEndY(scene.board.ymax());
			}
			
			if (scene.v.getStartY() < scene.board.ymax()) {
				// pod growing in size
				if (scene.v.getEndY() - scene.board.getY() >= podLength) {
					scene.v.setStartY(scene.v.getStartY() + delta);
				}
				else if (scene.v.getEndY() >= scene.board.ymax()) {
					scene.v.setStartY(scene.v.getStartY() + delta);
				}
			}
			else {
				goingDown = false;
				scene.v.setStartX(-100);
				scene.v.setStartY(-100);
				scene.v.setEndX(-100);
				scene.v.setEndY(-100);
			}
		}
		if (goingLeft) {
			//end
			//hasn't reached the end yet
			if (scene.h.getEndX() > scene.board.getX()) {
				scene.h.setEndX(scene.h.getEndX() - delta);
			}
			else if (!goingUp){
				goingUp = true;
				scene.v.setStartX(scene.board.getX());
				scene.v.setStartY(scene.board.ymax());
				scene.v.setEndX(scene.board.getX());
				scene.v.setEndY(scene.board.ymax());
			}
			
			if (scene.h.getStartX() > scene.board.getX()) {
				// pod growing in size
				if (scene.board.xmax() - scene.h.getEndX() >= podLength) {
					scene.h.setStartX(scene.h.getStartX() - delta);
				}
				else if (scene.h.getEndX() >= scene.board.xmax()) {
					scene.h.setStartX(scene.h.getStartX() - delta);
				}
			}
			else {
				goingLeft = false;
				scene.h.setStartX(-100);
				scene.h.setStartY(-100);
				scene.h.setEndX(-100);
				scene.h.setEndY(-100);
			}
		}
		
		if (goingUp) {
			//end
			//hasn't reached the end yet
			if (scene.v.getEndY() > scene.board.getY()) {
				scene.v.setEndY(scene.v.getEndY() - delta);
			}
			else if (!goingRight){
				goingRight = true;
				scene.h.setStartX(scene.board.getX());
				scene.h.setStartY(scene.board.getY());
				scene.h.setEndX(scene.board.getX());
				scene.h.setEndY(scene.board.getY());
			}
			
			if (scene.v.getStartY() > scene.board.getY()) {
				// pod growing in size
				if (scene.board.ymax() - scene.v.getEndY() >= podLength) {
					scene.v.setStartY(scene.v.getStartY() - delta);
				}
				else if (scene.v.getEndY() >= scene.board.ymax()) {
					scene.v.setStartY(scene.v.getStartY() - delta);
				}
			}
			else {
				goingUp = false;
				scene.v.setStartX(-100);
				scene.v.setStartY(-100);
				scene.v.setEndX(-100);
				scene.v.setEndY(-100);
			}		
		}
	}
	
	public void ballHitsPlatform() {
		if (scene.v.getBoundsInParent().intersects(scene.ball1.getBoundsInParent()) ||
				scene.h.getBoundsInParent().intersects(scene.ball1.getBoundsInParent())) {
			scene.ball1.setFill(Color.WHITE);
		}
	}
}
