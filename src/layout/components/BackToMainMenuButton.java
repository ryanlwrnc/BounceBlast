package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import layout.CustomScreen;
import layout.Main;
import layout.ScreenFactory;

public class BackToMainMenuButton extends BaseButton {

	private Main app;
	private ScreenFactory screenFactory;
	
	public BackToMainMenuButton(Main app, String label) {
		super(label);
		this.app = app;
		this.screenFactory = new ScreenFactory(app);
		
		setPrefHeight(25);
		setPrefWidth(65);
		setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		
		setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				CustomScreen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				app.updateScene(mainmenu.getScene());
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
