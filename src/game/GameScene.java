package game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import layout.Screen;

public class GameScene implements Screen {

	@Override
	public Scene getScene() {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		
		root.getChildren().add(new Circle(50, 50, 50, Color.RED));
		return scene;
	}
	
}
