package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.concurrent.Task;

public class GameBoard extends Rectangle {
	
	private double x;
	private double y;
	private double width;
	private double height;
	
	public GameBoard() {
		super();
		setFill(Color.TRANSPARENT);
		setStroke(Color.BLUE);
		setStrokeWidth(5);

	}
	
	public GameBoard(double x, double y, double width, double height) {
		super(x, y, width, height);
		setFill(Color.TRANSPARENT);
		setStroke(Color.BLUE);
		setStrokeWidth(5);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double xmax() {
		return this.x + this.width;
	}
	
	public double ymax() {
		return this.y + this.height;
	}
	
	public boolean isTouchingBottom(Ball ball) {
		return (ball.getCenterY() + ball.getRadius() >= getLayoutBounds().getMaxY()) ? true : false;
	}
	public boolean isTouchingTop(Ball ball) {
		return (ball.getCenterY() - ball.getRadius() <= getLayoutBounds().getMinY()) ? true : false;
	}
	public boolean isTouchingLeft(Ball ball) {
		return (ball.getCenterX() - ball.getRadius() <= getLayoutBounds().getMinX()) ? true : false;
	}
	public boolean isTouchingRight(Ball ball) {
		return (ball.getCenterX() + ball.getRadius() >= getLayoutBounds().getMaxX()) ? true : false;
	}
}
