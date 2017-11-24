package game;

public class BallFactory
{
	public enum BallType
	{
		BASKETBALL,
		TENNISBALL,
		BOWLINGBALL,
		SOCCERBALL;
	}
	
	public GameBall newGameBall(BallType ballType)
	{
		GameBall ball;
		
		switch(ballType) {
			case BASKETBALL:
				ball = new BasketBall();
				break;
			default:
				ball = null;
		}
		return ball;
	}
}