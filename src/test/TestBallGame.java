// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.Ball;
import game.ball.Ball.Button;
import javafx.scene.paint.Paint;

public class TestBallGame {
	public static final String WHITE = "white";
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void testBallGameConstructor() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getCenterX(), 10, 0.0);
	}
	@Test
	public void testBallGameUp() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Button.UP, true);
		assertEquals(ball.isPressed(Button.UP), true);
	}
	@Test
	public void testBallGameDown() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Button.DOWN, true);
		assertEquals(ball.isPressed(Button.DOWN), true);
	}
	@Test
	public void testBallGameLeft() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Button.LEFT, true);
		assertEquals(ball.isPressed(Button.LEFT), true);
	}
	@Test
	public void testBallGameRight() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Button.RIGHT, true);
		assertEquals(ball.isPressed(Button.RIGHT), true);
	}
	@Test
	public void testBallGameShift() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Button.SPACE, true);
		assertEquals(ball.isPressed(Button.SPACE), true);
	}
	@Test
	public void testBallGameGetVx() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getVx(), 0, 0.0);
	}
	@Test
	public void testBallGameGetVy() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getVy(), 0, 0.0);
	}
	@Test
	public void testBallGameUpdatePosition() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.press(Ball.Button.UP, true);
		ball.press(Button.DOWN, true);
		ball.press(Button.LEFT, true);
		ball.press(Button.RIGHT, true);
		assertEquals(ball.getCenterX(), 10.0, 0.0);
	}
	@Test
	public void testBallGameReflectVertical() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.reflectVertical();
		assertEquals(ball.getVy(), 0, 0.0);
	}
	@Test
	public void testBallGameReflectHorizontal() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.reflectHorizontal();
		assertEquals(ball.getVx(), 0, 0.0);
	}
	@Test
	public void testBallGameGetNewX() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getNewX(1.0, 1.0, 2.0, 5.0), 13.0, 0.0);
	}
	@Test
	public void testBallGameGetNewY() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getNewY(1.0, 1.0, 2.0, 5.0), 13.0, 0.0);
	}
	@Test
	public void testBallGameGetVxOverride() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getVx(1.0, 2.0, 3.0), 7.0, 0.0);
	}
	@Test
	public void testBallGameGetVyOverride() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getVy(1.0, 2.0, 3.0), 7.0, 0.0);
	}
	@Test
	public void testBallGameF() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.setF(47.0);
		assertEquals(ball.getF(), 47.0, 0.0);
	}
	@Test
	public void testBallGameM() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.setM(47.0);
		assertEquals(ball.getM(), 47.0, 0.0);
	}
	@Test
	public void testBallGameAx() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getAx(), 0.0, 0.0);
	}
	@Test
	public void testBallGameAy() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		assertEquals(ball.getAy(), 0.0, 0.0);
	}
	@Test
	public void testBallGameT() {
		Ball ball = new Ball(10, 10, 20, Paint.valueOf(WHITE));
		ball.setT(10.0);
		assertEquals(ball.getT(), 10.0, 0.0);
	}
}