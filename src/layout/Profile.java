package layout;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class Profile extends Scene {
	
	// JavaFX
	GridPane gridpane;
	
	// Components
	BackToMainMenuButton back;
	Text gameTitle;
	Text username;
	Text password;
	GridPane box;
	ColumnConstraints cons1;
	ColumnConstraints cons2;
	RowConstraints rcons1;
	RowConstraints rcons2;
	final PasswordField passwordField;
	final PasswordField confirmPasswordField;
	
	//Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public Profile(Main app, String name) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);

		 //Adding GridPane
        box = new GridPane();
        box.setMaxHeight(250);
        box.setPadding(new Insets(20,20,20,20));
        box.setVgap(5);
        box.setMaxWidth(650);	
        box.setHgap(5);
        
        cons1 = new ColumnConstraints();
		cons1.setHgrow(Priority.NEVER);
		gridpane.getColumnConstraints().add(cons1);
        rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
		
		cons2 = new ColumnConstraints();
		cons2.setHgrow(Priority.ALWAYS);
		
		gridpane.getColumnConstraints().addAll(cons1, cons2);
		
		rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        box.getColumnConstraints().addAll(cons1, cons2);
        box.getRowConstraints().addAll(rcons1, rcons2);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");
		GridPane[] gridpanes = screenHelper.titleAndBox(gridpane, rcons1, rcons2,
    			cons1, cons2, SCREENBUTTONCOL, "User Profile");
        box = gridpanes[1];
        gridpane = gridpanes[0];
        
        // User name text
        username = new Text();
        // Will get the current user's name from the database
        username.setFont(new Font(20));
        username.setFill(Color.WHITE);
        username.setStyle("-fx-font: 30 arial;");
        username.setText("Username: " + name);
        username.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setHalignment(username, HPos.RIGHT);
        
        // Password text
        password = new Text();
        password.setFill(Color.WHITE);
        password.setFont(new Font(20));
        password.setText("Change Password");
        password.setTextAlignment(TextAlignment.RIGHT);
        password.setStyle("-fx-font: 30 arial;");
        GridPane.setHalignment(password, HPos.RIGHT);
        
        box.add(password, 0, 1);
        box.add(username, 0, 0);
        
        GridPane.setMargin(password, new Insets(5, 10, 5, 10));
        GridPane.setMargin(username, new Insets(5, 10, 5, 10));
   
        // Change password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your new password");
        box.add(passwordField, 1, 1);
        
        // Confirm change password field
        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm new password");
        box.add(confirmPasswordField, 1, 2);
        GridPane.setHalignment(box, HPos.CENTER);
        gridpane.add(box, SCREENBUTTONCOL, 1);
        
		// Back button
		back = new BackToMainMenuButton(app, "Back");
		
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}
