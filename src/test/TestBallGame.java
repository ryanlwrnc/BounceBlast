// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.Ball;
import game.ball.Ball.Button;
import javafx.scene.paint.Paint;

public class TestBallGame {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestBallGameConstructor() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getCenterX(), 10, 0.0);
	}
	@Test
	public void TestBallGameUp() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Button.UP, true);
		assertEquals(ball.isPressed(Button.UP), true);
	}
	@Test
	public void TestBallGameDown() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Button.DOWN, true);
		assertEquals(ball.isPressed(Button.DOWN), true);
	}
	@Test
	public void TestBallGameLeft() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Button.LEFT, true);
		assertEquals(ball.isPressed(Button.LEFT), true);
	}
	@Test
	public void TestBallGameRight() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Button.RIGHT, true);
		assertEquals(ball.isPressed(Button.RIGHT), true);
	}
	@Test
	public void TestBallGameShift() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Button.SPACE, true);
		assertEquals(ball.isPressed(Button.SPACE), true);
	}
	@Test
	public void TestBallGameGetVx() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getVx(), 0, 0.0);
	}
	@Test
	public void TestBallGameGetVy() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getVy(), 0, 0.0);
	}
	@Test
	public void TestBallGameUpdatePosition() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.press(Ball.Button.UP, true);
		ball.press(Button.DOWN, true);
		ball.press(Button.LEFT, true);
		ball.press(Button.RIGHT, true);
		assertEquals(ball.getCenterX(), 10.0, 0.0);
	}
	@Test
	public void TestBallGameReflectVertical() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.reflectVertical();
		assertEquals(ball.getVy(), 0, 0.0);
	}
	@Test
	public void TestBallGameReflectHorizontal() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.reflectHorizontal();
		assertEquals(ball.getVx(), 0, 0.0);
	}
	@Test
	public void TestBallGameGetNewX() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getNewX(1.0, 1.0, 2.0, 5.0), 13.0, 0.0);
	}
	@Test
	public void TestBallGameGetNewY() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getNewY(1.0, 1.0, 2.0, 5.0), 13.0, 0.0);
	}
	@Test
	public void TestBallGameGetVxOverride() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getVx(1.0, 2.0, 3.0), 7.0, 0.0);
	}
	@Test
	public void TestBallGameGetVyOverride() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getVy(1.0, 2.0, 3.0), 7.0, 0.0);
	}
	/*@Test
	public void TestBallGameHandleCollison() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getVy(1.0, 2.0, 3.0), 7.0, 0.0);
	}*/
	@Test
	public void TestBallGameF() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.setF(47.0);
		assertEquals(ball.getF(), 47.0, 0.0);
	}
	@Test
	public void TestBallGameM() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.setM(47.0);
		assertEquals(ball.getM(), 47.0, 0.0);
	}
	@Test
	public void TestBallGameAx() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getAx(), 0.0, 0.0);
	}
	@Test
	public void TestBallGameAy() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		assertEquals(ball.getAy(), 0.0, 0.0);
	}
	@Test
	public void TestBallGameT() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf("white"));
		ball.setT(10.0);
		assertEquals(ball.getT(), 10.0, 0.0);
	}
}