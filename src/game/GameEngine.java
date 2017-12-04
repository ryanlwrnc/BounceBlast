package game;

import game.ball.Ball;
import javafx.application.Platform;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;
import layout.Main;
import layout.MainMenu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import java.util.List;

public class GameEngine implements Runnable {
	
	private boolean goingRight = true; //initial direction
	private boolean goingDown = false;
	private boolean goingLeft = false;
	private boolean goingUp = false;

	public enum Dir{
		UP, LEFT, RIGHT, DOWN;
		
		public Dir nextDirection(Dir dir) {
			switch (dir) {
			case UP:
				return RIGHT;
			case LEFT:
				return UP;
			
			case RIGHT:
				return DOWN;
			
			case DOWN:
				return LEFT;
			default:
				return UP;
			}
		}
	}
	
	
	private static final double UPDATE_CAP = 1.0/60.0;
	//private static final int HANDLED = 1;
	private GameScene scene;
	private Main app;
	//
	private int remainingBalls;
	private boolean cpuOneExists = true;
	private boolean cpuTwoExists = true;
	private boolean cpuThreeExists = true;
	//
	
	
	private double delta = 5;
	private double podLength = 100;
	private int alertCount = 0;
	
	boolean[][] isExiting;
	
	public GameEngine(Main a, GameScene scene, String numCPU) {
		this.scene = scene;
		this.app = a;
		
		int numberCPUs = Integer.parseInt(numCPU);
		
		// Remaining balls equal to the number of cpus + 1, to take take into account the users ball.
		remainingBalls = numberCPUs + 1;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		boolean render = false;
		isExiting = new boolean[scene.getAllPlayers().size()][scene.getAllPlayers().size()];
		
		double firstTime = 0; 
		double passedTime = 0; 
		double unprocessedTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double frameTime = 0; 
		//double frames = 0; 
		//double fps = 0;
		
		scene.h.setStartX(scene.board.getX());
		scene.h.setStartY(scene.board.getY());
		scene.h.setEndX(scene.board.getX());
		scene.h.setEndY(scene.board.getY());
		
		scene.v.setStartX(-100);
		scene.v.setStartY(-100);
		scene.v.setEndX(-100);
		scene.v.setEndY(-100);
		
		//while(!Thread.currentThread().interrupted()) {
		while(!Thread.interrupted()) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
				// Adjust frame values
				if (frameTime >= 1.0) {
					frameTime = 0;
					//fps = frames;
					//frames = 0;
					//System.out.println("FPS: " + fps);
				}
			}
			
			if (render) {
				Platform.runLater(() -> {for (Ball player : scene.getAllPlayers()) {
							updateGame(player);
							player.updatePosition();
						}
						
						// Move Platform Clockwise
						movePlatforms();
						ballHitsPlatform();
						
						handleCollisions(scene.getAllPlayers());	});
				//frames++;
			}
		}
		System.out.println("Game is done");
	}
	
	public void updateGame(Ball player) {
		if (scene.board.isTouchingTop(player) || scene.board.isTouchingBottom(player)
				&& !player.getVertExiting()) {
			player.reflectVertical();
			player.setVertExiting(true);
		}
		if (scene.board.isTouchingLeft(player) || scene.board.isTouchingRight(player)
				&& !player.getHorizontalExiting()) {
			player.reflectHorizontal();
			player.setHorizontalExiting(true);
		}

		// Prevent ball from getting stuck in wall
		if (!(scene.board.isTouchingTop(player) || scene.board.isTouchingBottom(player)) && player.getVertExiting()) {
			player.setVertExiting(false);
		}
		
		if ( !(scene.board.isTouchingLeft(player) || scene.board.isTouchingRight(player)) && player.getHorizontalExiting()) {
			player.setHorizontalExiting(false);
		}
	}
	
	public void movePlatforms() {
		for (Dir d : Dir.values()) {
			if (isDir(d)) {
				movePlatform(d);
			}
		}
	}
	
	public void movePlatform(Dir dir) {
		double startX = (goingRight || goingDown ? scene.board.xmax(): scene.board.getX());
		double startY = (goingLeft || goingDown ? scene.board.ymax(): scene.board.getY());
		double endX = (goingRight || goingDown ? scene.board.xmax(): scene.board.getX());
		double endY = (goingLeft || goingDown ? scene.board.ymax(): scene.board.getY());
		
		Line mainDirection = (dir == Dir.RIGHT || dir == Dir.LEFT ? scene.v : scene.h);
		Line otherDirection = (dir == Dir.RIGHT || dir == Dir.LEFT ? scene.h : scene.v);
		
		if (!reachedEnd(dir)) {
			handleReachedEnd(dir);
		}
		else if (!isDir(dir.nextDirection(dir)) ) {
			setDir(dir.nextDirection(dir), true);
			mainDirection.setStartX(startX);
			mainDirection.setStartY(startY);
			mainDirection.setEndX(endX);
			mainDirection.setEndY(endY);
		}
		checkDirGrow(dir,otherDirection);
	}
	
	public void checkDirGrow(Dir dir, Line l)
	{
		if (podNeedsToGrow(dir)) {
			growPodIfNeeded(dir);
		}
		else {
			setDir(dir, false);
			l.setStartX(-100);
			l.setStartY(-100);
			l.setEndX(-100);
			l.setEndY(-100);
		}
	}
	
	public boolean eliminateBall(Ball player) {
		if (scene.v.getBoundsInParent().intersects(player.getBoundsInParent()) ||
				scene.h.getBoundsInParent().intersects(player.getBoundsInParent())) {
			remainingBalls--;
			
			// If only the mainPlayer is left.
			if(remainingBalls == 1) {
				gameOver("Game Over! You won!");
			}
			// Move the eliminated ball to far away from the screen so it doesn't show on the board anymore
			else {
				player.setFill(Color.WHITE);
				player.setCenterX(1000000);
				player.setCenterX(1000000);
			}
			return true;
		}
		return false;
	}
	
	public void ballHitsPlatform() {
		boolean eliminated;
		// If the user's ball hits the platform.
		if (scene.v.getBoundsInParent().intersects(scene.mainPlayer.getBoundsInParent()) ||
				scene.h.getBoundsInParent().intersects(scene.mainPlayer.getBoundsInParent())) {
			//scene.mainPlayer.setFill(Color.WHITE);
			gameOver("Game Over! You lost!");
		}
		
		if(cpuOneExists) {
			eliminated = eliminateBall(scene.playerOne);
			if (eliminated) {
				cpuOneExists = false;
			}
		}
		
		if(cpuTwoExists) {
			eliminated = eliminateBall(scene.playerTwo);
			if (eliminated) {
				cpuTwoExists = false;
			}
		}
		
		if(cpuThreeExists) {
			eliminated = eliminateBall(scene.playerThree);
			if (eliminated) {
				cpuThreeExists = false;
			}
		}

		
	}
	
	public void gameOver(String s)
	{
		if(alertCount==0)
		{
			alertCount++;
			Thread mainThread = app.getThread();
			mainThread.interrupt();
			
			//app.thread.interrupt();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("BounceBlast");
			alert.setContentText(s);
			alert.showAndWait();
			//JOptionPane.showMessageDialog(null, "Game Over!", "BounceBlast", JOptionPane.INFORMATION_MESSAGE);
			app.updateScene(new MainMenu(app));
		}
	}
	
	public void handleCollisions(List<Ball> players) {
		boolean[][] collisionsHandled = new boolean[players.size()][players.size()];
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < players.size(); j++) {
				// ball doesn't collide with itself
				Shape intersect = Shape.intersect(players.get(i), players.get(j));
				boolean isTouching = intersect.getBoundsInLocal().getWidth() != -1;
				if (isTouching && !isExiting[i][j] && i != j) {
					Ball.handleCollision(players.get(i), players.get(j));
					isExiting[i][j] = true;
					isExiting[j][i] = true;
					collisionsHandled[i][j] = true;
					collisionsHandled[j][i] = true;
				}
				if (isExiting[i][j] && intersect.getBoundsInLocal().getWidth() == -1 && i!=j) {
					isExiting[i][j] = false;
					isExiting[j][i] = false;
				}
				
			}
		}
	}
	
	public boolean isDir(Dir dir) {
		switch (dir) {
		case UP:
			return goingUp;
		
		case LEFT:
			return goingLeft;
		
		case RIGHT:
			return goingRight;
		
		case DOWN:
			return goingDown;
		default:
			return false;
		}
	}
	
	public void setDir(Dir dir, boolean b) {
		switch (dir) {
		case UP:
			goingUp = b;
			break;
		case LEFT:
			goingLeft = b;
			break;
		case RIGHT:
			goingRight = b;
			break;
		case DOWN:
			goingDown = b;
			break;
		default:
		}
	}
	
	public boolean reachedEnd(Dir dir) {
		switch (dir) {
		case UP:
			return (scene.board.getY() >= scene.v.getEndY());
		case LEFT:
			return (scene.board.getX() >= scene.h.getEndX());
		case RIGHT:
			return (scene.h.getEndX() >= scene.board.xmax());
		case DOWN:
			return (scene.v.getEndY() >= scene.board.ymax());
		default:
			return true;
		}
	}
	
	public void handleReachedEnd(Dir dir) {
		switch (dir) {
		case UP:
			scene.v.setEndY(scene.v.getEndY() - delta);
			break;
		case LEFT:
			scene.h.setEndX(scene.h.getEndX() - delta);
			break;
		case RIGHT:
			scene.h.setEndX(scene.h.getEndX() + delta);
			break;
		case DOWN:
			scene.v.setEndY(scene.v.getEndY() + delta);
			break;
		}
	}
	
	public boolean podNeedsToGrow(Dir dir) {
		switch (dir) {
		case UP:
			return (scene.board.getY() < scene.v.getStartY());
		case LEFT:
			return (scene.board.getX() < scene.h.getStartX());
		case RIGHT:
			return (scene.h.getStartX() < scene.board.xmax());
		case DOWN:
			return (scene.v.getStartY() < scene.board.ymax());
		default:
			return true;
		}
	}
	
	public void growPodIfNeeded(Dir dir) {
		switch (dir) {
		case UP:
			if ((podLength <= scene.board.ymax() - scene.v.getEndY()  ) || (scene.board.ymax() <= scene.v.getEndY())) {
				scene.v.setStartY(scene.v.getStartY() - delta);
			}
			break;
		case LEFT:
			if ((podLength <= scene.board.xmax() - scene.h.getEndX() ) || (scene.board.xmax() <= scene.h.getEndX()  )) {
				scene.h.setStartX(scene.h.getStartX() - delta);
			}
			break;
		case RIGHT:
			if ((podLength <= scene.h.getEndX() - scene.board.getX()) || (scene.board.xmax() <= scene.h.getEndX())) {
				scene.h.setStartX(scene.h.getStartX() + delta);
			}
			break;
		case DOWN:
			if ((podLength <= scene.v.getEndY() - scene.board.getY()) || (scene.board.ymax() <= scene.v.getEndY())) {
				scene.v.setStartY(scene.v.getStartY() + delta);
			}
			break;
		}
	}
	
}
