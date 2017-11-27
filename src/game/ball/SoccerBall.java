package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

public class SoccerBall extends Ball
{
	private static final Image ballImg = new Image("file:soccerball.jpg");
	private static final double radius = 20;
	private static final double mass = 5;
	
	public SoccerBall(double centerX, double centerY){
		super(centerX, centerY, radius, new ImagePattern(ballImg));
		setM(mass);
	}
}