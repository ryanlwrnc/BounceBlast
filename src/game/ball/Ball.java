package game.ball;

import java.util.EnumMap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.List;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class Ball extends Circle {
	
	public enum Button {
		UP, DOWN, LEFT, RIGHT, SPACE, W, A, S, D;
	}
	
	//private Map<Button, Boolean> pressed = new HashMap<>();
	private EnumMap<Button, Boolean> pressed = new EnumMap<>(Button.class);
	
	// Have public setters
	private double f = 5;
	private double m = 10;
	private boolean exiting = false;
	
	
	// Don't have public setters
	private double ax = 0;
	private double ay = 0;
	private double vx = 0;
	private double vy = 0;
	private double maxSpeed = 50/m;
	private double t = 0.5;
	
	private boolean vertWallExiting = false;
	private boolean horizWallExiting = false;
	
	// AI ball fields
	private boolean ai = false;
	private List<Ball> players;
	
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
		// if the ball is controlled by an AI
		if (ai) {
			updatePositionAI();
		}
		// else if the ball is player-controlled
		else {
			updatePositionPlayer();
		}
	}
	
	public void updatePositionPlayer() {
		ax = 0;
		ay = 0;
		
		if (pressed.get(Button.UP)) {
			ay = -f / m;
		}
		if (pressed.get(Button.DOWN)) {
			ay = ay + f / m;
		}
		if (pressed.get(Button.LEFT)) {
			ax = -f / m;
		}
		if (pressed.get(Button.RIGHT)) {
			ax = f/m;
		}
		
		setCenterX(getNewX(getCenterX(), vx, t, ax));
		setCenterY(getNewY(getCenterY(), vy, t, ay));
		
		setVx(getVx(vx, ax, t));
		setVy(getVy(vy, ay, t));
	}
	
	public void updatePositionAI() {
		Ball target = AIgetTarget();
		ax = 0;
		ay = 0;
		
		// somewhat random movement
		// move towards target
		if (Math.random() > 0.33) {
			double[] newAccelerations = moveTowardTarget(target, ax, ay);
			ax = newAccelerations[0];
			ay = newAccelerations[1];
			/*if (target.getCenterX() + (target.getRadius() / 2) > getCenterX() + (this.getRadius() / 2)) {
				// move right
				ax = f/m;
				if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
					// move down
					ay = ay + f / m;
				}
				else {
					// move up
					ay = -f / m;
				}
			}
			if (target.getCenterX() + (target.getRadius() / 2) < getCenterX() + (this.getRadius() / 2)) {
				// move left
				ax = -f / m;
				if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
					// move down
					ay = ay + f / m;
				}
				else {
					// move up
					ay = -f / m;
				}
			}*/
		}
		// move away from target
		else {
			double[] newAccelerations = moveAwayFromTarget(target, ax, ay);
			ax = newAccelerations[0];
			ay = newAccelerations[1];
			/*if (target.getCenterX() + (target.getRadius() / 2) > getCenterX() + (this.getRadius() / 2)) {
				// move left
				ax = -f / m;
				if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
					// move up
					ay = -f / m;
				}
				else {
					// move down
					ay = ay + f / m;
				}
			}
			if (target.getCenterX() + (target.getRadius() / 2) < getCenterX() + (this.getRadius() / 2)) {
				// move right
				ax = f/m;
				if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
					// move up
					ay = -f / m;
				}
				else {
					// move down
					ay = ay + f / m;
				}
			}*/
		}
		
		
		setCenterX(getNewX(getCenterX(), vx, t, ax));
		setCenterY(getNewY(getCenterY(), vy, t, ay));
		
		setVx(getVx(vx, ax, t));
		setVy(getVy(vy, ay, t));
	}
	
	public double[] moveTowardTarget(Ball target, double ax, double ay) {
		double[] accelerations = new double[2];
		double newAx = ax;
		double newAy = ay;
		if (target.getCenterX() + (target.getRadius() / 2) > getCenterX() + (this.getRadius() / 2)) {
			// move right
			newAx = f/m;
			if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
				// move down
				newAy = newAy + f / m;
			}
			else {
				// move up
				newAy = -f / m;
			}
		}
		if (target.getCenterX() + (target.getRadius() / 2) < getCenterX() + (this.getRadius() / 2)) {
			// move left
			newAx = -f / m;
			if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
				// move down
				newAy = newAy + f / m;
			}
			else {
				// move up
				newAy = -f / m;
			}
		}
		accelerations[0] = newAx;
		accelerations[1] = newAy;
		return accelerations;
	}
	
	public double[] moveAwayFromTarget(Ball target, double ax, double ay) {
		double[] accelerations = new double[2];
		double newAx = ax;
		double newAy = ay;
		if (target.getCenterX() + (target.getRadius() / 2) > getCenterX() + (this.getRadius() / 2)) {
			// move left
			newAx = -f / m;
			if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
				// move up
				newAy = -f / m;
			}
			else {
				// move down
				newAy = newAy + f / m;
			}
		}
		if (target.getCenterX() + (target.getRadius() / 2) < getCenterX() + (this.getRadius() / 2)) {
			// move right
			newAx = f/m;
			if (target.getCenterY() + (target.getRadius() / 2) > getCenterY() + (this.getRadius() / 2)) {
				// move up
				newAy = -f / m;
			}
			else {
				// move down
				newAy = newAy + f / m;
			}
		}
		accelerations[0] = newAx;
		accelerations[1] = newAy;
		return accelerations;
	}
	
	public Ball AIgetTarget() {
		double minDistance = (double)(Integer.MAX_VALUE);
		Ball target = this.players.get(0); 
		
		for (Ball player : this.players) {
			double ballx = player.getCenterX();
			double bally = player.getCenterY();
			
			double distance = (Math.sqrt((ballx * ballx) + (bally * bally)));
			if ((distance < minDistance) && (distance != 0)) {
				minDistance = distance;
				target = player;
			}
		}
		return(target);
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
		String path = Ball.class.getResource("bounce.mp3").toString();
		Media sound = new Media(path);
		MediaPlayer player = new MediaPlayer(sound);
		
		double v1x = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.vx + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.vx; 
		double v1y = ( (b1.getM() - b2.getM()) / (b1.getM() + b2.getM())) * b1.vy + ( (2.0 * b2.getM()) / (b1.getM() + b2.getM())) * b2.vy;
		double v2x = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.vx +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.vx;
		double v2y = ( (2.0 * b1.getM()) / (b1.getM() + b2.getM())) * b1.vy +  ( (b2.getM() - b1.getM()) / (b1.getM() + b2.getM())) * b2.vy;
		
		double speed1 =  Math.sqrt((v1x * v1x) + (v1y * v1y));
		double speed2 =  Math.sqrt((v2x * v2x) + (v2y * v2y));
		double greaterSpeed = Math.max(speed1, speed2);
			
		player.setVolume(greaterSpeed / 25);
		player.play();
		
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
		double newVx = vx;
		// Set limit to speed
		if (vx > maxSpeed) {
			newVx = maxSpeed;
		}
		if (vx < -maxSpeed) {
			newVx = -maxSpeed;
		}
		this.vx = newVx;
	}

	private void setVy(double vy) {
		double newVy = vy;
		if (vy > maxSpeed) {
			newVy = maxSpeed;
		}
		if (vy < -maxSpeed) {
			newVy = -maxSpeed;
		}
		this.vy = newVy;
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
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}
	
	public void setAI(boolean enabled, List<Ball> players) {
		this.players = players;
		this.ai = enabled;
	}
	
	public boolean getHorizontalExiting() {
		return horizWallExiting;
	}
	
	public boolean getVertExiting() {
		return vertWallExiting;
	}
	
	public void setHorizontalExiting(boolean status) {
		this.horizWallExiting = status;
	}
	
	public void setVertExiting(boolean status) {
		this.vertWallExiting = status;
	}
	public void setPlayers(List<Ball> players) {
		this.players = players;
	}
	public boolean isExiting() {
		return exiting;
	}

	public void setExiting(boolean exiting) {
		this.exiting = exiting;
	}
}
