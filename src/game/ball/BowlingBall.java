package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BowlingBall extends Ball
{
	private static final Image ballImg = new Image("file:bowlingball.gif");
	private static final double radius = 25;
	private static final double mass = 40;
	
	public BowlingBall(double centerX, double centerY){
		super(centerX, centerY, radius, new ImagePattern(ballImg));
		setM(mass);
	}
}
