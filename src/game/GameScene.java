package game;

import java.util.LinkedList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import layout.CustomScreen;

public class GameScene implements CustomScreen {

	GameBoard board;
	Ball ball1;
	Ball ball2;
	Line h;
	Line v;
	
	@Override
	public Scene getScene() {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		ball1 = new Ball(400, 400, 10, Color.BLUE);
		ball2 = new Ball(300, 300, 10, Color.RED);
		List<Ball> balls = new LinkedList<Ball>();
		balls.add(ball1);
		balls.add(ball2);
		board = new GameBoard(250, 250, 600, 400);
		h = new Line();
		v = new Line();
		
		h.setStrokeWidth(6);
		v.setStrokeWidth(6);
		h.setStroke(Color.ORANGE);
		v.setStroke(Color.ORANGE);
		
		root.getChildren().addAll(board, ball1, ball2, h, v);
		
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
					default:
						break;
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
					default:
						break;
					}
				}
			}
		});
		
		return scene;
	}
}

