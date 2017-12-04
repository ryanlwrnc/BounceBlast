package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import layout.Main;
import layout.MainMenu;

public class BackToMainMenuButton extends BaseButton {

	public static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	public static final String BORDERCOLORWHITE = "-fx-border-color: white;";
	public static final String BACKGROUNDCOLOR24618F = "-fx-background-color: #24618F;";
	public static final String FONTSIZE16 = "-fx-font-size: 16;";
	public static final String TEXTFILLWHITE = "-fx-text-fill: white;";
	private boolean beenClicked = false;
	
	public BackToMainMenuButton(Main app, String label) {
		super(label);
		
		setPrefHeight(25);
		setPrefWidth(65);
		setStyle(BORDERWIDTH3 + 
				BORDERCOLORWHITE + 
				BACKGROUNDCOLOR24618F +
				FONTSIZE16 + 
				TEXTFILLWHITE);
		
		setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String path = BaseButton.class.getResource("button.mp3").toString();
				Media sound = new Media(path);
				MediaPlayer player = new MediaPlayer(sound);
				player.setVolume(0.5);
				player.play();
				beenClicked = true;
				app.updateScene(new MainMenu(app));
			}
		});
		setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		setStyle(BORDERWIDTH3 + 
	        				BORDERCOLORWHITE + 
	        				"-fx-background-color: #003399;" +
	        				FONTSIZE16 + 
	        				TEXTFILLWHITE);
	        }
	    });

		setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		setStyle(BORDERWIDTH3 + 
	        				BORDERCOLORWHITE + 
	        				BACKGROUNDCOLOR24618F +
	        				FONTSIZE16 + 
	        				TEXTFILLWHITE);
	        }
	    });
	}
	public boolean getBeenClicked() {
		return this.beenClicked;
	}
}
