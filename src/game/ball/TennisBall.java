package game.ball;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TennisBall extends Ball
{
	private static final Image ballImg = new Image("file:resource/tennisball.png");
	private static final double RADIUS = 10;
	private static final double MASS = 5;
	
	public TennisBall(double centerX, double centerY){
		super(centerX, centerY, RADIUS, new ImagePattern(ballImg));
		setF(3);
		setM(MASS);
	}
}