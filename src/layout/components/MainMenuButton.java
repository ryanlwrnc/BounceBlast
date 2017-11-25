package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import layout.CustomScreen;
import layout.Main;
import layout.ScreenFactory;

public class MainMenuButton extends Button {

	protected Main app;
	private ScreenFactory screenFactory; 
	
	public MainMenuButton(Main app, String label, ScreenFactory.ScreenType type) {
		super(label);
		this.app = app;
		screenFactory = new ScreenFactory(app);
		String buttonStyle = "-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 24;" + 
				"-fx-text-fill: white;";
		String buttonHoverStyle = "-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #003399;" +
				"-fx-font-size: 24;" + 
				"-fx-text-fill: white;";
		this.setPrefHeight(50);
		this.setPrefWidth(200);
		this.setStyle(buttonStyle);
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	setStyle(buttonHoverStyle);
	        }
	    });
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	setStyle(buttonStyle);
	        }
	    });
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
