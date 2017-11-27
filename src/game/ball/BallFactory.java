package game.ball;

import javafx.scene.paint.Color;

public class BallFactory
{
	public enum BallType
	{
		BASKETBALL,
		TENNISBALL,
		BOWLINGBALL,
		SOCCERBALL;
	}
	
	public Ball newGameBall(BallType ballType)
	{
		Ball ball;
		
		switch(ballType) {
			case BASKETBALL:
				ball = new BasketBall(400, 400);
				break;
			default:
				ball = null;
		}
		return ball;
	}
}