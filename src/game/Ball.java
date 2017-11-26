package game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle { 
	
	// Physics Values
	// F = ma;
	// F direction depends on keyboard key being pressed
	private double F = 5;
	private double m = 10;
	private double maxSpeed = 5;
	
	private double ax = 0;
	private double ay = 0;
	private double vx = 0;
	private double vy = 0;
	private double t = 0.5;
	
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

	}
	
	public void updatePosition() {
		// set acceleration
		ax = 0;
		ay = 0;
		
		if (up) {
			ay = -F / m;
		}
		if (down) {
			ay = ay + F / m;
		}
		if (left) {
			ax = -F / m;
		}
		if (right) {
			ax += F/m;
		}
		
		//System.out.println("x: " + getNewX(x, vx, t, ax) + "y: " + getNewY(y, vy, t, ay));
		setCenterX(getNewX(getCenterX(), vx, t, ax));
		setCenterY(getNewY(getCenterY(), vy, t, ay));
		
		this.vx = getVx(vx, ax, t);
		this.vy = getVy(vy, ay, t);
	
	}
	
	public void reflectVertical() {
		this.vy *= -1;
	}
	
	public void reflectHorizontal() {
		this.vx *= -1;
	}

	public void setUp(boolean up) {
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
		double v1x = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.getVx() + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.getVx(); 
		double v1y = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.getVy() + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.getVy();
		double v2x = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.getVx() +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.getVx();
		double v2y = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.getVy() +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.getVy();
		
		b1.setVx(v1x);
		b1.setVy(v1y);
		b2.setVx(v2x);
		b2.setVy(v2y);
		
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

	public double getAx() {
		return ax;
	}

	public void setAx(double ax) {
		this.ax = ax;
	}

	public double getAy() {
		return ay;
	}

	public void setAy(double ay) {
		this.ay = ay;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}
	
}
