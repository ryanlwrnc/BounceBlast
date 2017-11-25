package game;

import javafx.scene.shape.Rectangle;

public class GameBoard extends Rectangle {
	public GameBoard() {
		super();
	}
	
	public GameBoard(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	public boolean isTouchingTop(Ball ball) {
		return (ball.getCenterY() + ball.getRadius() > getLayoutBounds().getMaxY()) ? true : false;
	}
	public boolean isTouchingBottom(Ball ball) {
		return (ball.getCenterY() + ball.getRadius() < getLayoutBounds().getMinY()) ? true : false;
	}
	public boolean isTouchingLeft(Ball ball) {
		return (ball.getCenterX() + ball.getRadius() < getLayoutBounds().getMinX()) ? true : false;
	}
	public boolean isTouchingRight(Ball ball) {
		return (ball.getCenterX() + ball.getRadius() > getLayoutBounds().getMaxX()) ? true : false;
	}
}
