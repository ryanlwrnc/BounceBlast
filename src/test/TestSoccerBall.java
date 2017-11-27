// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import game.SoccerBall;

public class TestSoccerBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestSoccerBallConstructor() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.ballX, 400, 0.0);
	}
	@Test
	public void TestSoccerBallAtRightBorder() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.atRightBorder(1000000), false);
	}
	@Test
	public void TestSoccerBallAtLeftBorder() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.atLeftBorder(10000), true);
	}
	@Test
	public void TestSoccerBallAtTopBorder() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.atTopBorder(1000000), false);
	}
	@Test
	public void TestSoccerBallAtBottomBorder() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.atBottomBorder(10000), true);
	}
	@Test
	public void TestSoccerBallSetBallX() {
		SoccerBall ball = new SoccerBall();
		ball.setBallX(200.0);
		assertEquals(ball.ballX, 200, 0.0);
	}
	@Test
	public void TestSoccerBallSetBallY() {
		SoccerBall ball = new SoccerBall();
		ball.setBallY(200.0);
		assertEquals(ball.ballY, 200, 0.0);
	}
	@Test
	public void TestSoccerBallGetBallRadius() {
		SoccerBall ball = new SoccerBall();
		assertEquals(ball.getBallRadius(), 70, 0.0);
	}
	@Test
	public void TestSoccerBallMoveUp() {
		SoccerBall ball = new SoccerBall();
		ball.moveUp(false);
		assertEquals(ball.ballY, 400 - 40, 0.0);
	}
	@Test
	public void TestSoccerBallMoveDown() {
		SoccerBall ball = new SoccerBall();
		ball.moveDown(false);
		assertEquals(ball.ballY, 400 + 40, 0.0);
	}
	@Test
	public void TestSoccerBallMoveLeft() {
		SoccerBall ball = new SoccerBall();
		ball.moveLeft(false);
		assertEquals(ball.ballX, 400 - 40, 0.0);
	}
	@Test
	public void TestSoccerBallMoveRight() {
		SoccerBall ball = new SoccerBall();
		ball.moveRight(false);
		assertEquals(ball.ballX, 400 + 40, 0.0);
	}
}
