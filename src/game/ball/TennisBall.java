package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TennisBall extends Ball
{
	private static final Image ballImg = new Image("file:tennisball.png");
	private static final double radius = 20;
	private static final double mass = 5;
	
	public TennisBall(double centerX, double centerY){
		super(centerX, centerY, radius, new ImagePattern(ballImg));
		setF(3);
		setM(mass);
	}
}