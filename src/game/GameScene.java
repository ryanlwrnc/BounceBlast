package game;

import java.util.LinkedList;
import java.util.List;

import game.ball.Ball;
import game.ball.Ball.Button;
import game.ball.BowlingBall;
import game.ball.TennisBall;
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
		ball1 = new BowlingBall(400, 400);
		ball2 = new TennisBall(300, 300);
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
						case UP: ball.press(Button.UP, true); break;
						case DOWN: ball.press(Button.DOWN, true); break;
						case LEFT: ball.press(Button.LEFT, true); break;
						case RIGHT: ball.press(Button.RIGHT, true); break;
						case SHIFT: ball.press(Button.SPACE, true); break;
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
						case UP: ball.press(Button.UP, false); break;
						case DOWN: ball.press(Button.DOWN, false); break;
						case LEFT: ball.press(Button.LEFT, false); break;
						case RIGHT: ball.press(Button.RIGHT, false); break;
						case SHIFT: ball.press(Button.SPACE, false); break;
					default:
						break;
					}
				}
			}
		});
		
		return scene;
	}
}

