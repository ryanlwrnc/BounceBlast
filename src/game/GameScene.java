package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import game.ball.Ball;
import game.ball.Ball.Button;
import game.ball.BasketBall;
import game.ball.BowlingBall;
import game.ball.SoccerBall;
import game.ball.TennisBall;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.Main;

public class GameScene extends Scene {
	
	// JavaFx
	//private Group root;
	Pane p;
	
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
	public final List<Ball> allPossiblePlayers;
	private static final String BASKETBALL = "Basketball";
	private static final String BOWLINGBALL = "Bowling Ball";
	private static final String TENNISBALL = "Tennis Ball";
	private static final String SOCCERBALL = "Soccer Ball";
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
	
	
	/*public GameScene() {
		super(new Group(), 800, 600);

		root = (Group) getRoot();
		// Create players
		mainPlayer = new BowlingBall(400, 400);
		playerOne = new TennisBall(300, 300);
		
		allPossiblePlayers = Arrays.asList(mainPlayer, playerOne, playerTwo, playerThree);
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
		List<Ball> playerOnePlayers = getAllPlayers();
		playerOnePlayers.remove(playerOne);
		playerOne.setAI(true, playerOnePlayers);
		
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
					case W: mainPlayer.press(Button.UP, true); break;
					case S: mainPlayer.press(Button.DOWN, true); break;
					case A: mainPlayer.press(Button.LEFT, true); break;
					case D: mainPlayer.press(Button.RIGHT, true); break;
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
					case W: mainPlayer.press(Button.UP, false); break;
					case S: mainPlayer.press(Button.DOWN, false); break;
					case A: mainPlayer.press(Button.LEFT, false); break;
					case D: mainPlayer.press(Button.RIGHT, false); break;
				default:
					break;
				}
			}
		});
	}*/
	
	// GameScene Constructor for Play Offline
	public GameScene(Main app, String numCPU, String chosenBall) {
		super(new Pane(), 800, 600);
		//VBox box = (VBox)getRoot();
		
		int numberCPUs = Integer.parseInt(numCPU);

		p = (Pane)getRoot();
		Group g = new Group();
		p.setStyle("-fx-background-image: url('file:background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		
		
		// Create Players
		/*
		mainPlayer = new BowlingBall(400, 400);
		playerOne = new TennisBall(300, 300);
		*/
		
		/*
		  cbBall.getItems().add("Basketball");
        cbBall.getItems().add("Bowling Ball");
        cbBall.getItems().add("Tennis Ball");
        cbBall.getItems().add("Soccer Ball");
		 */
		checkChosenBall(chosenBall, numberCPUs);
		/*if(chosenBall.equals(BASKETBALL)) {
			mainPlayer = new BasketBall(300,300);
			playerOne = new TennisBall(800, 300);
			if(numberCPUs>1)
				playerTwo = new BowlingBall(300,600);
			if(numberCPUs>2)
				playerThree = new SoccerBall(600,600);
		}else if(chosenBall.equals(BOWLINGBALL)) {
			mainPlayer = new BowlingBall(300, 300);
			playerOne = new TennisBall(800, 300);
			if(numberCPUs>1)
				playerTwo = new SoccerBall(600,600);
			if(numberCPUs>2)
				playerThree = new BasketBall(300,600);
		}else if(chosenBall.equals(TENNISBALL)) {
			mainPlayer = new TennisBall(400, 400);
			playerOne = new BasketBall(300, 300);
			if(numberCPUs>1)
				playerTwo = new SoccerBall(600,600);
			if(numberCPUs>2)
				playerThree = new BowlingBall(800,300);
		}else if(chosenBall.equals(SOCCERBALL)) {
			mainPlayer = new SoccerBall(400, 400);
			playerOne = new TennisBall(800, 300);
			if(numberCPUs>1)
				playerTwo = new BasketBall(300, 300);
			if(numberCPUs>2)
				playerThree = new BowlingBall(300,600);
		}*/
		
		/*
		if(numberCPUs == 1) {
			if(chosenBall.equals(BASKETBALL)) {
				mainPlayer = new BasketBall(300,300);
				playerOne = new TennisBall(800, 300);
			}else if(chosenBall.equals(BOWLINGBALL)) {
				mainPlayer = new BowlingBall(300, 300);
				playerOne = new TennisBall(800, 300);
			}else if(chosenBall.equals(TENNISBALL)) {
				mainPlayer = new TennisBall(400, 400);
				playerOne = new TennisBall(800, 300);
			}else if(chosenBall.equals(SOCCERBALL)) {
				mainPlayer = new SoccerBall(400, 400);
				playerOne = new TennisBall(800, 300);
			}
		}
		else if(numberCPUs == 2) {
			if(chosenBall.equals(BASKETBALL)) {
				mainPlayer = new BasketBall(300,300);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
			}else if(chosenBall.equals(BOWLINGBALL)) {
				mainPlayer = new BowlingBall(300, 300);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BasketBall(300, 600); 
			}else if(chosenBall.equals(TENNISBALL)) {
				mainPlayer = new TennisBall(400, 400);
				playerOne = new SoccerBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
			}else if(chosenBall.equals(SOCCERBALL)) {
				mainPlayer = new SoccerBall(400, 400);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
			}
		}
		else if(numberCPUs == 3) {
			if(chosenBall.equals(BASKETBALL)) {
				mainPlayer = new BasketBall(300,300);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
				playerThree = new SoccerBall(600, 600); 
			}else if(chosenBall.equals(BOWLINGBALL)) {
				mainPlayer = new BowlingBall(300, 300);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BasketBall(300, 600);
				playerThree = new SoccerBall(600, 600); 
			}else if(chosenBall.equals(TENNISBALL)) {
				mainPlayer = new TennisBall(400, 400);
				playerOne = new BasketBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
				playerThree = new SoccerBall(600, 600); 
			}else if(chosenBall.equals(SOCCERBALL)) {
				mainPlayer = new SoccerBall(400, 400);
				playerOne = new TennisBall(800, 300);
				playerTwo = new BowlingBall(300, 600); 
				playerThree = new BasketBall(600, 600); 
			}
		}*/
		
		allPossiblePlayers = Arrays.asList(mainPlayer, playerOne, playerTwo, playerThree);
		//Create text
		Text gameTitle;
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		
		// Create board
		board = new GameBoard(250, 250, 600, 400);
		h = new Line();
		v = new Line();
		h.setStrokeWidth(6);
		v.setStrokeWidth(6);
		h.setStroke(Color.ORANGE);
		v.setStroke(Color.ORANGE);
		
		g.getChildren().addAll(board, h, v);
		g.getChildren().addAll(getAllPlayers());
		p.getChildren().addAll(gameTitle,g);
		
		List<Ball> playerOnePlayers = getAllPlayers();
		//box.getChildren().addAll(g);//added
		
		if(numberCPUs == 1) {
			playerOnePlayers.remove(playerOne);
			playerOne.setAI(true, playerOnePlayers);
		}
		else if(numberCPUs == 2) {
			playerOnePlayers.remove(playerOne);
			playerOne.setAI(true, playerOnePlayers);
			playerOnePlayers.remove(playerTwo);
			playerTwo.setAI(true, playerOnePlayers);
		}
		else if(numberCPUs == 3) {
			playerOnePlayers.remove(playerOne);
			playerOne.setAI(true, playerOnePlayers);
			playerOnePlayers.remove(playerTwo);
			playerTwo.setAI(true, playerOnePlayers);
			playerOnePlayers.remove(playerThree);
			playerThree.setAI(true, playerOnePlayers);
		}
		
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
	
	public void checkChosenBall(String chosenBall, int numberCPUs) {
		if(chosenBall.equals(BASKETBALL)) {
			mainPlayer = new BasketBall(300,300);
			playerOne = new TennisBall(800, 300);
			checkNumberCPUsBasketball(numberCPUs);
			/*if(numberCPUs>1)
				playerTwo = new BowlingBall(300,600);
			if(numberCPUs>2)
				playerThree = new SoccerBall(600,600);*/
		}else if(chosenBall.equals(BOWLINGBALL)) {
			mainPlayer = new BowlingBall(300, 300);
			playerOne = new TennisBall(800, 300);
			checkNumberCPUsBowlingBall(numberCPUs);
			/*if(numberCPUs>1)
				playerTwo = new SoccerBall(600,600);
			if(numberCPUs>2)
				playerThree = new BasketBall(300,600);*/
		}else if(chosenBall.equals(TENNISBALL)) {
			mainPlayer = new TennisBall(400, 400);
			playerOne = new BasketBall(300, 300);
			checkNumberCPUsTennisBall(numberCPUs);
			/*if(numberCPUs>1)
				playerTwo = new SoccerBall(600,600);
			if(numberCPUs>2)
				playerThree = new BowlingBall(800,300);*/
		}else if(chosenBall.equals(SOCCERBALL)) {
			mainPlayer = new SoccerBall(400, 400);
			playerOne = new TennisBall(800, 300);
			checkNumberCPUsSoccerBall(numberCPUs);
			/*if(numberCPUs>1)
				playerTwo = new BasketBall(300, 300);
			if(numberCPUs>2)
				playerThree = new BowlingBall(300,600);*/
		}
	}
	public void checkNumberCPUsBasketball(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = new BowlingBall(300,600);
		if(numberCPUs>2)
			playerThree = new SoccerBall(600,600);
	}
	public void checkNumberCPUsBowlingBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = new SoccerBall(600,600);
		if(numberCPUs>2)
			playerThree = new BasketBall(300,600);
	}
	public void checkNumberCPUsTennisBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = new SoccerBall(600,600);
		if(numberCPUs>2)
			playerThree = new BowlingBall(800,300);
	}
	public void checkNumberCPUsSoccerBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = new BasketBall(300, 300);
		if(numberCPUs>2)
			playerThree = new BowlingBall(300,600);
	}
	
	public List<Ball> getAllPlayers() {
		return new ArrayList<>(allPossiblePlayers).stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
}