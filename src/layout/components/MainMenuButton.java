package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import layout.Main;


public class MainMenuButton extends BaseButton {

	protected Main app;
	
	public MainMenuButton(Main app, String label, Scene scene) {
		super(label);
		this.app = app;

		this.setPrefHeight(50);
		this.setPrefWidth(200);
		
		this.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				app.updateScene(scene);
			}
		});
	}
}
