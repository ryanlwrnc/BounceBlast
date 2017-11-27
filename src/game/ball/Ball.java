package game.ball;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
	
	public static enum Button {
		UP, DOWN, LEFT, RIGHT, SPACE;
	}
	
	private Map<Button, Boolean> pressed = new HashMap<Button, Boolean>();
	
	// Have public setters
	private double F = 5;
	private double m = 10;
	
	// Don't have public setters
	private double ax = 0;
	private double ay = 0;
	private double vx = 0;
	private double vy = 0;
	private double maxSpeed = 50/m;
	private double t = 0.5;
	
	public Ball() {
		super();
	}
	
	public Ball(double centerX, double centerY, double radius, Paint fill) {
		super (centerX, centerY, radius, fill);
		pressed.put(Button.UP, false);
		pressed.put(Button.DOWN, false);
		pressed.put(Button.LEFT, false);
		pressed.put(Button.RIGHT, false);
		pressed.put(Button.SPACE, false);
	}
	
	public void updatePosition() {
		// set acceleration
		ax = 0;
		ay = 0;
		
		if (pressed.get(Button.UP)) {
			ay = -F / m;
		}
		if (pressed.get(Button.DOWN)) {
			ay = ay + F / m;
		}
		if (pressed.get(Button.LEFT)) {
			ax = -F / m;
		}
		if (pressed.get(Button.RIGHT)) {
			ax += F/m;
		}
		
		setCenterX(getNewX(getCenterX(), vx, t, ax));
		setCenterY(getNewY(getCenterY(), vy, t, ay));
		
		setVx(getVx(vx, ax, t));
		setVy(getVy(vy, ay, t));
	
	}
	
	public void reflectVertical() {
		this.vy *= -1;
	}
	
	public void reflectHorizontal() {
		this.vx *= -1;
	}

	public double getNewX(double xi, double vxi, double t, double ax) {
		return xi + (vxi * t) + (0.5 * ax * (t * t)); 
	}

	public double getNewY(double yi, double vyi, double t, double ay) {
		return yi + vyi * t + 0.5 * ay * (t * t);
	}
	
	public double getVx(double vxi, double ax, double t) {
		return vxi + ax * t;
	}
	
	public double getVy(double vyi, double ay, double t) {
		return vyi + ay * t;
	}
	
	public static void handleCollision(Ball b1, Ball b2) {
		double v1x = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.vx + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.vx; 
		double v1y = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.vy + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.vy;
		double v2x = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.vx +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.vx;
		double v2y = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.vy +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.vy;
		
		b1.setVx(v1x);
		b1.setVy(v1y);
		b2.setVx(v2x);
		b2.setVy(v2y);	
	}
	
	public void press(Button dir, boolean b) {
		pressed.replace(dir, b);
	}
	
	public boolean isPressed(Button dir) {
		return pressed.get(dir).booleanValue();
	}

	private void setVx(double vx) {
		// Set limit to speed
		if (vx > maxSpeed) {
			vx = maxSpeed;
		}
		if (vx < -maxSpeed) {
			vx = -maxSpeed;
		}
		this.vx = vx;
	}

	private void setVy(double vy) {
		if (vy > maxSpeed) {
			vy = maxSpeed;
		}
		if (vy < -maxSpeed) {
			vy = -maxSpeed;
		}
		this.vy = vy;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}
	
	public double getVx() {
		return vx;
	}
	
	public double getVy() {
		return vy;
	}
	
	public double getAx() {
		return ax;
	}
	
	public double getAy() {
		return ay;
	}
	
	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}
}