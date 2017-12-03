package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import game.ball.Ball;

public class TestLoopBallAI {
	@Test
	public void testAIGetTarget() {
		List<Ball> players = new ArrayList<>();
		Ball ball1 = new Ball();
		ball1.setCenterX(70.0);
		ball1.setCenterY(70.0);
		players.add(ball1);
		Ball ball2 = new Ball();
		ball2.setCenterX(10.0);
		ball2.setCenterY(10.0);
		players.add(ball2);
		Ball ball3 = new Ball();
		ball3.setCenterX(80.0);
		ball3.setCenterY(80.0);
		players.add(ball3);
		
		Ball ai = new Ball();
		ai.setPlayers(players);
		ai.setCenterX(11.0);
		ai.setCenterY(11.0);
		Ball aiTarget = ai.AIgetTarget();
		
		assertEquals(aiTarget.getCenterX(), ball2.getCenterX(), 0.0);
		
	}
}
