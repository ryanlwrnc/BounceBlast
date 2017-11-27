package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.concurrent.Task;

public class GameBoard extends Rectangle {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private double wallThickness = 5;
	
	public GameBoard() {
		super();
		setFill(Color.TRANSPARENT);
		setStroke(Color.BLUE);
		setStrokeWidth(wallThickness);

	}
	
	public GameBoard(double x, double y, double width, double height) {
		super(x, y, width, height);
		setFill(Color.TRANSPARENT);
		setStroke(Color.BLUE);
		setStrokeWidth(wallThickness);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double xmax() {
		return this.x + this.width - wallThickness/2;
	}
	
	public double ymax() {
		return this.y + this.height - wallThickness/2;
	}
	
	public boolean isTouchingBottom(Ball ball) {
		return (ball.getCenterY() + ball.getRadius() >= this.ymax()) ? true : false;
	}
	public boolean isTouchingTop(Ball ball) {
		return (ball.getCenterY() - ball.getRadius() <= this.y) ? true : false;
	}
	public boolean isTouchingLeft(Ball ball) {
		return (ball.getCenterX() - ball.getRadius() <= this.x) ? true : false;
	}
	public boolean isTouchingRight(Ball ball) {
		return (ball.getCenterX() + ball.getRadius() >= this.xmax()) ? true : false;
	}
}
