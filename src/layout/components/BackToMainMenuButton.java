package layout.components;

import game.ball.Ball;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import layout.Main;
import layout.MainMenu;

public class BackToMainMenuButton extends BaseButton {

	private Main app;
	
	public BackToMainMenuButton(Main app, String label) {
		super(label);
		this.app = app;
		
		setPrefHeight(25);
		setPrefWidth(65);
		setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		
		setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String path = BaseButton.class.getResource("button.mp3").toString();
				Media sound = new Media(path);
				MediaPlayer player = new MediaPlayer(sound);
				player.setVolume(0.5);
				player.play();
				
				app.updateScene(new MainMenu(app));
			}
		});
		setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #24618F;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });
	}
	
}
