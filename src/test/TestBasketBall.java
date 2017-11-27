// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.BasketBall;
import javafx.scene.paint.Color;

public class TestBasketBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestBasketBallConstructor() {
		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
		assertEquals(ball.getCenterX(), 400, 0.0);
	}
	*/
//	@Test
//	public void TestBasketBallSetBallX() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.setCenterX(200.0);
//		assertEquals(ball.ballX, 200, 0.0);
//	}
//	@Test
//	public void TestBasketBallSetBallY() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.setBallY(200.0);
//		assertEquals(ball.ballY, 200, 0.0);
//	}
//	@Test
//	public void TestBasketBallGetBallRadius() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		assertEquals(ball.getBallRadius(), 75, 0.0);
//	}
//	@Test
//	public void TestBasketBallMoveUp() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.moveUp(false);
//		assertEquals(ball.ballY, 400 - 10, 0.0);
//	}
//	@Test
//	public void TestBasketBallMoveDown() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.moveDown(false);
//		assertEquals(ball.ballY, 400 + 10, 0.0);
//	}
//	@Test
//	public void TestBasketBallMoveLeft() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.moveLeft(false);
//		assertEquals(ball.ballX, 400 - 10, 0.0);
//	}
//	@Test
//	public void TestBasketBallMoveRight() {
//		BasketBall ball = new BasketBall(400, 400, 10, Color.BLUE);
//		ball.moveRight(false);
//		assertEquals(ball.ballX, 400 + 10, 0.0);
//	}
}
