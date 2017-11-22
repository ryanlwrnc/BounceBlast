package game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class GameEngine implements Runnable {

	private volatile boolean running;
	private final double UPDATE_CAP = 1.0/60.0;
	
	public void run() {
		running = true;
		
		boolean render = false;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while(running) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
				//TODO: Update game
				if (frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					Group root = new Group();
					Scene scene = new Scene(root, 800, 600);
					Ball ball1 = new Ball(400, 400, 10, Color.BLACK);
					Ball ball2 = new Ball(300, 300, 10, Color.RED);
					GameBoard board = new GameBoard(150, 150, 500, 300);
					board.setFill(Color.TRANSPARENT);
					board.setStroke(Color.BLUE);
					board.setStrokeWidth(5);
					root.getChildren().addAll(board, ball1, ball2);
					System.out.println("FPS: " + fps);
				}
			}
			
			if (render) {
				//TODO: Render game
				frames++;
			}
			else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Game ended");
					running = false;
				}
			}
		}
		System.out.println("Game is done");
	}
	private void dispose() {
		
	}
	
    public void terminate() {
        running = false;
    }
}
