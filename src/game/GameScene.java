package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import game.ball.Ball;
import game.ball.Ball.Button;
import game.ball.BallFactory;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
	BallFactory ballFactory = new BallFactory();
	
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
	
	// GameScene Constructor for Play Offline
	public GameScene(Main app, String numCPU, String chosenBall) {
		super(new Pane(), 800, 600);
		//VBox box = (VBox)getRoot();
		
		int numberCPUs = Integer.parseInt(numCPU);

		p = (Pane)getRoot();
		Group g = new Group();
		p.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		
		// Create Players
		checkChosenBall(chosenBall, numberCPUs);
		
		allPossiblePlayers = Arrays.asList(mainPlayer, playerOne, playerTwo, playerThree);
		//Create text
		Text gameTitle;
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		gameTitle.setY(100);
		//gameTitle.setX(400);
		gameTitle.layoutXProperty().bind(p.widthProperty().subtract(gameTitle.xProperty()).divide(2));
		
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
		if(chosenBall.equals(BallFactory.BallType.BASKETBALL.getBallName())) {
			mainPlayer = ballFactory.newGameBall(BallFactory.BallType.BASKETBALL,300,300);
			playerOne = ballFactory.newGameBall(BallFactory.BallType.TENNISBALL,800,300);
			checkNumberCPUsBasketball(numberCPUs);
		}
		else if(chosenBall.equals(BallFactory.BallType.BOWLINGBALL.getBallName())) {
			mainPlayer = ballFactory.newGameBall(BallFactory.BallType.BOWLINGBALL,300,300);
			playerOne = ballFactory.newGameBall(BallFactory.BallType.TENNISBALL,800,300);
			checkNumberCPUsBowlingBall(numberCPUs);
		}else if(chosenBall.equals(BallFactory.BallType.TENNISBALL.getBallName())) {
			mainPlayer = ballFactory.newGameBall(BallFactory.BallType.TENNISBALL,300,300);
			playerOne = ballFactory.newGameBall(BallFactory.BallType.BASKETBALL,800,300);
			checkNumberCPUsTennisBall(numberCPUs);
		}else if(chosenBall.equals(BallFactory.BallType.SOCCERBALL.getBallName())) {
			mainPlayer = ballFactory.newGameBall(BallFactory.BallType.SOCCERBALL,300,300);
			playerOne = ballFactory.newGameBall(BallFactory.BallType.TENNISBALL,800,300);
			checkNumberCPUsSoccerBall(numberCPUs);
		}
	}
	
	public void checkNumberCPUsBasketball(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = ballFactory.newGameBall(BallFactory.BallType.BOWLINGBALL,300,600);
		if(numberCPUs>2)
			playerThree = ballFactory.newGameBall(BallFactory.BallType.SOCCERBALL,800,600);
	}
	public void checkNumberCPUsBowlingBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = ballFactory.newGameBall(BallFactory.BallType.SOCCERBALL,300,600);
		if(numberCPUs>2)
			playerThree = ballFactory.newGameBall(BallFactory.BallType.BASKETBALL,800,600);
	}
	public void checkNumberCPUsTennisBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = ballFactory.newGameBall(BallFactory.BallType.SOCCERBALL,300,600);
		if(numberCPUs>2)
			playerThree = ballFactory.newGameBall(BallFactory.BallType.BOWLINGBALL,800,600);
	}
	public void checkNumberCPUsSoccerBall(int numberCPUs) {
		if(numberCPUs>1)
			playerTwo = ballFactory.newGameBall(BallFactory.BallType.BASKETBALL,300,600);
		if(numberCPUs>2)
			playerThree = ballFactory.newGameBall(BallFactory.BallType.BOWLINGBALL,800,600);
	}
	
	public List<Ball> getAllPlayers() {
		return new ArrayList<>(allPossiblePlayers).stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
}