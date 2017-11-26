package game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle { 
	
	// Physics Values
//	private double ax = 0;
//	private double ay = 0;
	private double vx = 0;
	private double vy = 0;
	private double x = 0;
	private double y = 0;
//	private final double MULTIPLIER = 1.5;
	
	// Keyboard Controls Being Pressed
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean shift;
	
	public Ball() {
		super();
	}
	
	public Ball(double centerX, double centerY, double radius, Paint fill) {
		super (centerX, centerY, radius, fill);
		x = centerX;
		y = centerY;
	}
	
	public void updatePosition() {
		
		double deltaAX = 0;
		double deltaAY = 0;
		double maxDelta = 3;
		
		// calculate new accelerations
		if (up) {
			System.out.println("Pressing up");
			deltaAY -= 1;
		} else if (down) {
			deltaAY += 1;
		} else if (left) {
			deltaAX -= 1;
		} else if (right) {
			deltaAX += 1;
		} 
//		else if (shift) {
//			deltaAX *= MULTIPLIER;
//			deltaAY *= MULTIPLIER;
//		}
		vx += deltaAX;
		vy += deltaAY;
		
		if (vx > maxDelta) {
			vx = maxDelta;
		}
		if (vx < (maxDelta * -1)) {
			vx = (maxDelta * -1);
		}
		if (vy > maxDelta) {
			vy = maxDelta;
		}
		if (vy < (maxDelta * -1)) {
			vy = (maxDelta * -1);
		}		
		// calculate new positions
		setCenterX(getCenterX() + vx);
		setCenterY(getCenterY() + vy);
	}
	
	public void reflectVertical() {
		this.vy *= -1;
	}
	
	public void reflectHorizontal() {
		this.vx *= -1;
	}

	public void setUp(boolean up) {
		System.out.println("Setting up to: " + up);
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setShift(boolean shift) {
		this.shift = shift;
	}
}
