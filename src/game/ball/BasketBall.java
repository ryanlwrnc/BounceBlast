package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BasketBall extends Ball
{
	private static final Image ballImg = new Image("file:basketball.jpg");
	private static final double radius = 30;
	private static final double mass = 20;
	
	public BasketBall(double centerX, double centerY){
		super(centerX, centerY, radius, new ImagePattern(ballImg));
		setM(mass);
	}
}