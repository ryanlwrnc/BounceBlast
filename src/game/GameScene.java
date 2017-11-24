package game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import layout.Main;
import layout.CustomScreen;

public class GameScene implements CustomScreen {

	GameBoard board;
	Ball ball1;
	Ball ball2;
	
	@Override
	public Scene getScene() {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		ball1 = new Ball(400, 400, 10, Color.BLACK);
		ball2 = new Ball(300, 300, 10, Color.RED);
		board = new GameBoard(150, 150, 500, 300);
		board.setFill(Color.TRANSPARENT);
		board.setStroke(Color.BLUE);
		board.setStrokeWidth(5);
		
		Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);
		
		root.getChildren().addAll(board, ball1, ball2);
		
		
		
		return scene;
	}
}

