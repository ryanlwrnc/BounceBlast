package layout.components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BaseButton extends Button {
	
	public BaseButton(String label) {
		super(label);
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
	}
}