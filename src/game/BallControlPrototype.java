package game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class BallControlPrototype extends Application
{
	final int WIDTH = 1200;
	final int HEIGHT = 800;
	
	double ballRadius = 75;
	double ballX = 400;
	double ballY = 400;
	double xSpeed = 10;
	double boostMultiplier = 1.5;
	
	boolean goUp = false;
	boolean goDown = false;
	boolean goLeft = false;
	boolean goRight = false;
	boolean boost = false;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage gameScreen)
	{
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		
		Circle ball = new Circle(ballX, ballY, ballRadius, Color.RED);
		root.getChildren().add(ball);
		
		
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
	      	  		if(ballX + ball.getRadius() >= WIDTH)
	      	  		{
	      	  			ballX = WIDTH - ball.getRadius();
	      	  		}
	      	  	// Prevent ball from leaving the left edge
	      	  		if(ballX - ball.getRadius() <= 0)
	      	  		{
	      	  			ballX = ball.getRadius();
	      	  		}
	      	  	// Prevent ball from leaving the top edge
	      	  		if(ballY + ball.getRadius() >= HEIGHT)
	      	  		{
	      	  			ballY = HEIGHT - ball.getRadius();
	      	  		}
	      	  	// Prevent ball from leaving the bottom edge
	      	  		if(ballY - ball.getRadius() <= 0)
	      	  		{
	      	  			ballY = ball.getRadius();
	      	  		}
	      	  		
	      	  		if(goUp)
	      	  		{
	      	  			ballY -= xSpeed;
	      	  		}
	      	  		if(goDown)
	      	  		{
	      	  			ballY += xSpeed;
	      	  		}
	      	  		if(goLeft)
	      	  		{
	      	  			ballX -= xSpeed;
	      	  		}
	      	  		if(goRight)
	      	  		{
	      	  			ballX += xSpeed;
	      	  		}
	      	  		
	      	  		if(goUp && boost)
	      	  		{
	      	  			ballY -= xSpeed * boostMultiplier;
	      	  		}
	      	  		if(goDown && boost)
	      	  		{
	      	  			ballY += xSpeed * boostMultiplier;
	      	  		}
	      	  		if(goLeft && boost)
	      	  		{
	      	  			ballX -= xSpeed * boostMultiplier;
	      	  		}
	      	  		if(goRight && boost)
	      	  		{
	      	  			ballX += xSpeed * boostMultiplier;
	      	  		}
	      	  	// RENDER
	      	  		ball.setCenterY(ballY);
	      	  		ball.setCenterX(ballX);
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
