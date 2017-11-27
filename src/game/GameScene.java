package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

public class GameScene extends Scene {

	// JavaFx
	private Group root;
	
	// Components
	Button  exit;
	GameBoard board;
	Ball mainPlayer;
	Ball playerOne;
	Ball playerTwo;
	Ball playerThree;
	Line h;
	Line v;
	
	// Constants
	public final List<Ball> ALL_POSSIBLE_PLAYERS;
	int screenButtonCol = 2;
	String buttonStyle = "-fx-border-width: 3;" + 
			"-fx-border-color: white;" + 
			"-fx-background-color: #24618F;" +
			"-fx-font-size: 24;" + 
			"-fx-text-fill: white;";
	String buttonHoverStyle = "-fx-border-width: 3;" + 
			"-fx-border-color: white;" + 
			"-fx-background-color: #003399;" +
			"-fx-font-size: 24;" + 
			"-fx-text-fill: white;";
	
	
	public GameScene() {
		super(new Group(), 800, 600);
		
		
		root = (Group) getRoot();
		// Create players
		mainPlayer = new BowlingBall(400, 400);
		playerOne = new TennisBall(300, 300);
		playerOne.setAI(true, getAllPlayers());
		
		ALL_POSSIBLE_PLAYERS = Arrays.asList(mainPlayer, playerOne, playerTwo, playerThree);
		// Create board
		board = new GameBoard(250, 250, 600, 400);
		h = new Line();
		v = new Line();
		h.setStrokeWidth(6);
		v.setStrokeWidth(6);
		h.setStroke(Color.ORANGE);
		v.setStroke(Color.ORANGE);
		
		root.getChildren().addAll(board, h, v);
		root.getChildren().addAll(getAllPlayers());
		
		setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				switch (e.getCode()) 
				{
					case UP: mainPlayer.press(Button.UP, true); break;
					case DOWN: mainPlayer.press(Button.DOWN, true); break;
					case LEFT: mainPlayer.press(Button.LEFT, true); break;
					case RIGHT: mainPlayer.press(Button.RIGHT, true); break;
					case SHIFT: mainPlayer.press(Button.SPACE, true); break;
				default:
					break;
				}
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				switch (e.getCode()) 
				{
					case UP: mainPlayer.press(Button.UP, false); break;
					case DOWN: mainPlayer.press(Button.DOWN, false); break;
					case LEFT: mainPlayer.press(Button.LEFT, false); break;
					case RIGHT: mainPlayer.press(Button.RIGHT, false); break;
					case SHIFT: mainPlayer.press(Button.SPACE, false); break;
				default:
					break;
				}
			}
		});
	}
	
	public List<Ball> getAllPlayers() {
		return new ArrayList<>(ALL_POSSIBLE_PLAYERS).stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
	
}

