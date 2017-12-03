package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class SoccerBall extends Ball
{
	private static final Image ballImg = new Image("file:resource/soccerball.jpg");
	private static final double RADIUS = 27;
	private static final double MASS = 15;
	
	public SoccerBall(double centerX, double centerY){
		super(centerX, centerY, RADIUS, new ImagePattern(ballImg));
		setM(MASS);
	}
}