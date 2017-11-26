package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import game.BowlingBall;

public class TestBowlingBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestBowlingBallConstructor() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.ballX, 400, 0.0);
	}
	@Test
	public void TestBowlingBallAtRightBorder() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.atRightBorder(1000000), false);
	}
	@Test
	public void TestBowlingBallAtLeftBorder() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.atLeftBorder(10000), true);
	}
	@Test
	public void TestBowlingBallAtTopBorder() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.atTopBorder(1000000), false);
	}
	@Test
	public void TestBowlingBallAtBottomBorder() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.atBottomBorder(10000), true);
	}
	@Test
	public void TestBowlingBallSetBallX() {
		BowlingBall ball = new BowlingBall();
		ball.setBallX(200.0);
		assertEquals(ball.ballX, 200, 0.0);
	}
	@Test
	public void TestBowlingBallSetBallY() {
		BowlingBall ball = new BowlingBall();
		ball.setBallY(200.0);
		assertEquals(ball.ballY, 200, 0.0);
	}
	@Test
	public void TestBowlingBallGetBallRadius() {
		BowlingBall ball = new BowlingBall();
		assertEquals(ball.getBallRadius(), 55, 0.0);
	}
	@Test
	public void TestBowlingBallMoveUp() {
		BowlingBall ball = new BowlingBall();
		ball.moveUp(false);
		assertEquals(ball.ballY, 400 - 5, 0.0);
	}
	@Test
	public void TestBowlingBallMoveDown() {
		BowlingBall ball = new BowlingBall();
		ball.moveDown(false);
		assertEquals(ball.ballY, 400 + 5, 0.0);
	}
	@Test
	public void TestBowlingBallMoveLeft() {
		BowlingBall ball = new BowlingBall();
		ball.moveLeft(false);
		assertEquals(ball.ballX, 400 - 5, 0.0);
	}
	@Test
	public void TestBowlingBallMoveRight() {
		BowlingBall ball = new BowlingBall();
		ball.moveRight(false);
		assertEquals(ball.ballX, 400 + 5, 0.0);
	}
}
