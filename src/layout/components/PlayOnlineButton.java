package layout.components;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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
		ButtonHelper buttonHelper = new ButtonHelper();
		buttonHelper.setClickAction(app, this, scene);
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
