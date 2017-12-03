package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BowlingBall extends Ball
{
	private static final Image ballImg = new Image("file:resource/bowlingball.gif");
	private static final double RADIUS = 25;
	private static final double MASS = 40;
	
	public BowlingBall(double centerX, double centerY){
		super(centerX, centerY, RADIUS, new ImagePattern(ballImg));
		setM(MASS);
	}
}