package game;

import java.util.LinkedList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import layout.CustomScreen;

public class GameScene implements CustomScreen {

	GameBoard board;
	Ball ball1;
	Ball ball2;
	
	@Override
	public Scene getScene() {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		ball1 = new Ball(400, 400, 10, Color.BLUE);
		List<Ball> balls = new LinkedList<Ball>();
		balls.add(ball1);
		
//		ball2 = new Ball(300, 300, 10, Color.RED);
		board = new GameBoard(250, 250, 600, 400);
		board.setFill(Color.TRANSPARENT);
		board.setStroke(Color.BLUE);
		board.setStrokeWidth(5);
		root.getChildren().addAll(board, ball1);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				System.out.println("Pressing: " + e.getCode());
				for (Ball ball : balls) {
					switch (e.getCode()) 
					{
						case UP: ball.setUp(true); break;
						case DOWN: ball.setDown(true); break;
						case LEFT: ball.setLeft(true); break;
						case RIGHT: ball.setRight(true); break;
						case SHIFT: ball.setShift(true); break;
					}
				}
			}
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				for (Ball ball : balls) {
					switch (e.getCode()) 
					{
						case UP: ball.setUp(false); break;
						case DOWN: ball.setDown(false); break;
						case LEFT: ball.setLeft(false); break;
						case RIGHT: ball.setRight(false); break;
						case SHIFT: ball.setShift(false); break;
					}
				}
			}
		});
		
		return scene;
	}
}

