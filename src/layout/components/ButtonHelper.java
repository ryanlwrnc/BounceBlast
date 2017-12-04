package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import layout.Main;

public class ButtonHelper {
	public void setClickAction(Main app, BaseButton button, Scene scene) {
		button.setOnAction(new EventHandler<ActionEvent>()
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
	}
}
