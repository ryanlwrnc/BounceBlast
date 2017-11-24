package game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class BallControlPrototype extends Application
{
	final int WIDTH = 1200;
	final int HEIGHT = 800;
	/*
	double ballRadius = 70;
	
	double ballX = 400;
	double ballY = 400;
	double xSpeed = 10;
	double boostMultiplier = 1.5;
	*/
	boolean goUp = false;
	boolean goDown = false;
	boolean goLeft = false;
	boolean goRight = false;
	boolean boost = false;
	/*
	BallFactory bFact = new BallFactory();
	GameBall gBall = bFact.newGameBall(BallFactory.BallType.BASKETBALL);
	*/
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage gameScreen)
	{
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		
		
		BasketBall gameBall = new BasketBall();
		//TennisBall gameBall = new TennisBall();
		//BowlingBall gameBall = new BowlingBall();
		//SoccerBall gameBall = new SoccerBall();
		
		root.getChildren().add(gameBall.ball);
		
		gameScreen.setScene(scene);
		gameScreen.setTitle("Bounce Blast!");
		gameScreen.show();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				switch (e.getCode()) 
				{
					case UP: goUp = true; break;
					case DOWN: goDown = true; break;
					case LEFT: goLeft = true; break;
					case RIGHT: goRight = true; break;
					case SHIFT: boost = true; break;
				}
			}
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				switch (e.getCode()) 
				{
					case UP: goUp = false; break;
					case DOWN: goDown = false; break;
					case LEFT: goLeft = false; break;
					case RIGHT: goRight = false; break;
					case SHIFT: boost = false; break;
				}
			}
		});
		
		
		// Game Loop
		AnimationTimer animator = new AnimationTimer()
	    {
	        @Override
	        public void handle(long arg0) 
	        {
	      	  // UPDATE
	      	  	// Prevent ball from leaving the right edge
	      	  		if(gameBall.atRightBorder(WIDTH))
	      	  		{
	      	  			//ballX = WIDTH - ball.getRadius();
	      	  			gameBall.setBallX(WIDTH - gameBall.getBallRadius());
	      	  		}
	      	  	// Prevent ball from leaving the left edge
	      	  		if(gameBall.atLeftBorder(0))
	      	  		{
	      	  			//ballX = ball.getRadius();
	      	  			gameBall.setBallX(gameBall.getBallRadius());
	      	  		}
	      	  	// Prevent ball from leaving the top edge
	      	  		if(gameBall.atTopBorder(HEIGHT))
	      	  		{
	      	  			//ballY = HEIGHT - ball.getRadius();
	      	  			gameBall.setBallY(HEIGHT - gameBall.getBallRadius());
	      	  		}
	      	  	// Prevent ball from leaving the bottom edge
	      	  		if(gameBall.atBottomBorder(0))
	      	  		{
	      	  			//ballY = ball.getRadius();
	      	  			gameBall.setBallY(gameBall.getBallRadius());
	      	  		}
	      	  		
	      	  		if(goUp)
	      	  		{
	      	  			gameBall.moveUp(boost);
	      	  		}
	      	  		if(goDown)
	      	  		{
	      	  			gameBall.moveDown(boost);
	      	  		}
	      	  		if(goLeft)
	      	  		{
	      	  			gameBall.moveLeft(boost);
	      	  		}
	      	  		if(goRight)
	      	  		{
	      	  			gameBall.moveRight(boost);
	      	  		}

	      	  	// RENDER   	  		
	      	  		gameBall.ball.setCenterY(gameBall.ballY);
	      	  		gameBall.ball.setCenterX(gameBall.ballX);
	        }
	    };
	    
	    animator.start();
	}
}

// All contents in JavaFX is organized in the Scene Graph.
// Node - Element of a scene graph
	// Every node has a parent node. Except for the root node.

// Group - A Node, which can have many "child" Nodes.
	// Affect to the group Node, will affect the child nodes.

// Scene - contains all contents for the Scene Graph.
	// Requires a root Node to bet set.
		// Most often a Group Node
