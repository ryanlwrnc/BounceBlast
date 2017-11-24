package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class BowlingBall implements GameBall
{
	public static Circle ball;
	public static double radius;
	public static double ballX;
	public static double ballY;
	public static double speed;
	public static double boostMultiplier;
	public static Image ballImg;
	
	public BowlingBall(){
		radius = 55.0;
		ballX = 400; 	// To be changed
		ballY = 400; 	// To be changed
		speed = 5;
		boostMultiplier = 1.5;
		ball = new Circle(ballX, ballY, radius, Color.RED);
		ballImg = new Image("file:bowlingball.gif");
		ball.setFill(new ImagePattern(ballImg));
	}
	
	public boolean atRightBorder(int maxWidth)
	{
		if(ballX + ball.getRadius() >= maxWidth)
			return true;
		else
			return false;
	}
	
	public boolean atLeftBorder(int minWidth)
	{
		if(ballX - ball.getRadius() <= minWidth)
			return true;
		else
			return false;
	}
	
	public boolean atTopBorder(int maxHeight)
	{
		if(ballY + ball.getRadius() >= maxHeight)
			return true;
		else
			return false;
	}
	
	public boolean atBottomBorder(int minHeight)
	{
		if(ballY - ball.getRadius() <= minHeight)
			return true;
		else
			return false;
	}
	
	public void setBallX(double newX)
	{
		ballX = newX;
	}
	
	public void setBallY(double newY)
	{
		ballY = newY;
	}
	
	public double getBallRadius()
	{
		return ball.getRadius();
	}
	
	public void moveUp(boolean withBoost)
	{
		System.out.println(ballY);
		if(withBoost)
			ballY -= speed * boostMultiplier;
		else
			ballY -= speed;
	}
	
	public void moveDown(boolean withBoost)
	{
		if(withBoost)
			ballY += speed * boostMultiplier;
		else
			ballY += speed;
	}
	
	public void moveLeft(boolean withBoost)
	{
		if(withBoost)
  			ballX -= speed * boostMultiplier;
		else
			ballX -= speed;
	}
	
	public void moveRight(boolean withBoost)
	{
		if(withBoost)
			ballX += speed * boostMultiplier;
		else
			ballX += speed;
	}
}