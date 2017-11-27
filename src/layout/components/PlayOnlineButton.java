package layout.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import layout.Main;

public class PlayOnlineButton extends BaseButton {

	protected Main app;
	
	String buttonStyle = "-fx-border-width: 3;" + 
							"-fx-border-color: white;" + 
							"-fx-background-color: #24618F;" + 
							"-fx-font-size: 16;" + 
							"-fx-text-fill: white;";
	String buttonHoverStyle = "-fx-border-width: 3;" + 
			"-fx-border-color: white;" + 
			"-fx-background-color: #003399;" +
			"-fx-font-size: 16;" + 
			"-fx-text-fill: white;";
	
	public PlayOnlineButton(Main app, String label, Scene scene) {
		super(label);
		this.app = app;
		
		this.setStyle(buttonStyle);
		
		this.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				app.updateScene(scene);
			}
		});
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
	}
}
