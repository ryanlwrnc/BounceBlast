package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import layout.CustomScreen;
import layout.Main;
import layout.ScreenFactory;

public class MainMenuButton extends BaseButton {

	protected Main app;
	private ScreenFactory screenFactory; 
	
	public MainMenuButton(Main app, String label, ScreenFactory.ScreenType type) {
		super(label);
		this.app = app;
		screenFactory = new ScreenFactory(app);
		this.setPrefHeight(50);
		this.setPrefWidth(200);
		
		this.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				CustomScreen loginScreen = screenFactory.newScreen(type);
				app.updateScene(loginScreen.getScene());
			}
		});
	}
}
