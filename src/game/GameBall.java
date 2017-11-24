package game;

import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

public interface GameBall
{
	
	public boolean atRightBorder(int maxWidth);
	
	public boolean atLeftBorder(int minWidth);
	
	public boolean atTopBorder(int maxHeight);
	
	public boolean atBottomBorder(int minHeight);
	
	public void setBallX(double newX);
	
	public void setBallY(double newY);
	
	public double getBallRadius();
	
	public void moveUp(boolean withBoost);
	
	public void moveDown(boolean withBoost);
	
	public void moveLeft(boolean withBoost);
	
	public void moveRight(boolean withBoost);
}
