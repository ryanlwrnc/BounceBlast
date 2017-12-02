package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import layout.Main;

public class PlayOnlineButton extends BaseButton {

	protected Main app;
	
	String style = "-fx-border-width: 3;" + 
							"-fx-border-color: white;" + 
							"-fx-background-color: #24618F;" + 
							"-fx-font-size: 16;" + 
							"-fx-text-fill: white;";
	String hoverStyle = "-fx-border-width: 3;" + 
			"-fx-border-color: white;" + 
			"-fx-background-color: #003399;" +
			"-fx-font-size: 16;" + 
			"-fx-text-fill: white;";
	
	public PlayOnlineButton(Main app, String label, Scene scene) {
		super(label);
		this.app = app;
		
		this.setStyle(style);
		
		this.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				String path = BaseButton.class.getResource("button.mp3").toString();
				Media sound = new Media(path);
				MediaPlayer player = new MediaPlayer(sound);
				player.setVolume(0.5);
				player.play();
				
				app.updateScene(scene);
			}
		});
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	setStyle(hoverStyle);
	        }
	    });
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	setStyle(style);
	        }
	    });
	}
}
