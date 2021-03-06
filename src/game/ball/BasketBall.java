package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BasketBall extends Ball
{
	private static final Image ballImg = new Image("file:resource/basketball.jpg");
	private static final double RADIUS = 30;
	private static final double MASS = 20;
	
	public BasketBall(double centerX, double centerY){
		super(centerX, centerY, RADIUS, new ImagePattern(ballImg));
		setM(MASS);
	}
}