package game.ball;

public class BallFactory
{
	public enum BallType
	{
		BASKETBALL("Basketball"),
		TENNISBALL("Tennis Ball"),
		BOWLINGBALL("Bowling Ball"),
		SOCCERBALL("Soccer Ball");
		
		private String ballName;
		
		BallType(String ballName){
			this.ballName = ballName;
		}
		
		public String getBallName() {
			return this.ballName;
		}
	}
	
	public Ball newGameBall(BallType ballType,double centerX, double centerY) {
		Ball gameBall;
		
		switch(ballType) {
			case BASKETBALL:
				gameBall = new BasketBall(centerX,centerY);
				break;
			case TENNISBALL:
				gameBall = new TennisBall(centerX,centerY);
				break;
			case BOWLINGBALL:
				gameBall = new BowlingBall(centerX,centerY);
				break;
			case SOCCERBALL:
				gameBall = new SoccerBall(centerX,centerY);
				break;
			default:
				gameBall = null;
		}
		return gameBall;
	}
}