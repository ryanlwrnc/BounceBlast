package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import game.BasketBall;

public class TestBasketBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestBasketBallConstructor() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.ballX, 400, 0.0);
	}
	@Test
	public void TestBasketBallAtRightBorder() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.atRightBorder(1000000), false);
	}
	@Test
	public void TestBasketBallAtLeftBorder() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.atLeftBorder(10000), true);
	}
	@Test
	public void TestBasketBallAtTopBorder() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.atTopBorder(1000000), false);
	}
	@Test
	public void TestBasketBallAtBottomBorder() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.atBottomBorder(10000), true);
	}
	@Test
	public void TestBasketBallSetBallX() {
		BasketBall ball = new BasketBall();
		ball.setBallX(200.0);
		assertEquals(ball.ballX, 200, 0.0);
	}
	@Test
	public void TestBasketBallSetBallY() {
		BasketBall ball = new BasketBall();
		ball.setBallY(200.0);
		assertEquals(ball.ballY, 200, 0.0);
	}
	@Test
	public void TestBasketBallGetBallRadius() {
		BasketBall ball = new BasketBall();
		assertEquals(ball.getBallRadius(), 75, 0.0);
	}
	@Test
	public void TestBasketBallMoveUp() {
		BasketBall ball = new BasketBall();
		ball.moveUp(false);
		assertEquals(ball.ballY, 400 - 10, 0.0);
	}
	@Test
	public void TestBasketBallMoveDown() {
		BasketBall ball = new BasketBall();
		ball.moveDown(false);
		assertEquals(ball.ballY, 400 + 10, 0.0);
	}
	@Test
	public void TestBasketBallMoveLeft() {
		BasketBall ball = new BasketBall();
		ball.moveLeft(false);
		assertEquals(ball.ballX, 400 - 10, 0.0);
	}
	@Test
	public void TestBasketBallMoveRight() {
		BasketBall ball = new BasketBall();
		ball.moveRight(false);
		assertEquals(ball.ballX, 400 + 10, 0.0);
	}
}
