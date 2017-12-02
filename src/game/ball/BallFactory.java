package game.ball;

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
		
		if (ballType == BallType.BASKETBALL)
			ball = new BasketBall(400, 400);
		else
			ball = null;
		/*switch(ballType) {
			case BASKETBALL:
				ball = new BasketBall(400, 400);
				break;
			default:
				ball = null;
		}*/
		return ball;
	}
}