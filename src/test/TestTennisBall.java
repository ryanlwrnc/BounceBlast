// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.TennisBall;

public class TestTennisBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestTennisBallConstructor() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.ballX, 400, 0.0);
	}
	@Test
	public void TestTennisBallAtRightBorder() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.atRightBorder(1000000), false);
	}
	@Test
	public void TestTennisBallAtLeftBorder() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.atLeftBorder(10000), true);
	}
	@Test
	public void TestTennisBallAtTopBorder() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.atTopBorder(1000000), false);
	}
	@Test
	public void TestTennisBallAtBottomBorder() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.atBottomBorder(10000), true);
	}
	@Test
	public void TestTennisBallSetBallX() {
		TennisBall ball = new TennisBall();
		ball.setBallX(200.0);
		assertEquals(ball.ballX, 200, 0.0);
	}
	@Test
	public void TestTennisBallSetBallY() {
		TennisBall ball = new TennisBall();
		ball.setBallY(200.0);
		assertEquals(ball.ballY, 200, 0.0);
	}
	@Test
	public void TestTennisBallGetBallRadius() {
		TennisBall ball = new TennisBall();
		assertEquals(ball.getBallRadius(), 30, 0.0);
	}
	@Test
	public void TestTennisBallMoveUp() {
		TennisBall ball = new TennisBall();
		ball.moveUp(false);
		assertEquals(ball.ballY, 400 - 30, 0.0);
	}
	@Test
	public void TestTennisBallMoveDown() {
		TennisBall ball = new TennisBall();
		ball.moveDown(false);
		assertEquals(ball.ballY, 400 + 30, 0.0);
	}
	@Test
	public void TestTennisBallMoveLeft() {
		TennisBall ball = new TennisBall();
		ball.moveLeft(false);
		assertEquals(ball.ballX, 400 - 30, 0.0);
	}
	@Test
	public void TestTennisBallMoveRight() {
		TennisBall ball = new TennisBall();
		ball.moveRight(false);
		assertEquals(ball.ballX, 400 + 30, 0.0);
	}
	*/
}
