package layout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class CreateAccount extends Scene {
	
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Button makeAccount;
	private Text gameTitle;
	private Text username;
	private Text password;
	public final TextField usernameField;
	public final PasswordField passwordField;
	public final PasswordField confirmPasswordField;
	private ColumnConstraints cons1;
	private ColumnConstraints cons2;
	private RowConstraints rcons1;
	private RowConstraints rcons2;
	private GridPane box;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public CreateAccount(Main app) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
		
		/*cons1 = new ColumnConstraints();
		cons1.setHgrow(Priority.NEVER);
		gridpane.getColumnConstraints().add(cons1);
		
		cons2 = new ColumnConstraints();
		cons2.setHgrow(Priority.ALWAYS);
		
		gridpane.getColumnConstraints().addAll(cons1, cons2);
		
		rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        gridpane.getRowConstraints().addAll(rcons1, rcons2);
		gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");*/
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		 
		// BounceBlast text
		/*gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Create Account");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, SCREENBUTTONCOL, 0);		// ADDEd
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        box = new GridPane();
        box.setPadding(new Insets(20,20,20,20));
        box.setMaxWidth(650);	
        box.setMaxHeight(250);
        box.setHgap(5);
        box.setVgap(5);
        box.getColumnConstraints().addAll(cons1, cons2);
        box.getRowConstraints().addAll(rcons1, rcons2);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");*/
		
		GridPane[] gridpanes = screenHelper.titleAndBox(gridpane, rcons1, rcons2,
    			cons1, cons2, SCREENBUTTONCOL, "Create Account");
        gridpane = gridpanes[0];
        box = gridpanes[1];
        
        // User name text
        username = new Text();
        username.setFont(new Font(20));
        username.setFill(Color.WHITE);
        username.setText("Username");
        username.setStyle("-fx-font: 30 arial;");
        username.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setHalignment(username, HPos.RIGHT);
        
        // Password text
        password = new Text();
        password.setFont(new Font(20));
        password.setFill(Color.WHITE);
        password.setText("Password");
        password.setStyle("-fx-font: 30 arial;");
        password.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setHalignment(password, HPos.RIGHT);
        
        box.add(username, 0, 0);
        box.add(password, 0, 1);
        
        GridPane.setMargin(username, new Insets(5, 10, 5, 10));
        GridPane.setMargin(password, new Insets(5, 10, 5, 10));
        
        // User name field
        usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        box.add(usernameField, 1, 0);
        
        // Password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        box.add(passwordField, 1, 1);
        
        // Confirm Password field
        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm password");
        box.add(confirmPasswordField, 1, 2);
        
        // Create Account button
        makeAccount = new Button("Create Account");
        makeAccount.setPrefHeight(40);
        makeAccount.setPrefWidth(150);
        makeAccount.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		box.add(makeAccount, 0, 10);
		GridPane.setHalignment(makeAccount, HPos.CENTER);
		GridPane.setMargin(makeAccount, new Insets(5, 10, 5, 10));
		
		// Create Account Pressed
		makeAccount.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/*
				CustomScreen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				updateScene(mainmenu.getScene());
				*/
				
				// Verify users input
				// If username field is not empty:
				if ((!usernameField.getText().trim().isEmpty()) && 
						(!passwordField.getText().trim().isEmpty() && !confirmPasswordField.getText().trim().isEmpty()) &&
						(passwordField.getText().equals(confirmPasswordField.getText()))) {
					// Verify if the two password fields are not empty
					//if(!passwordField.getText().trim().isEmpty() && !confirmPasswordField.getText().trim().isEmpty())
						// Make sure the two password fields match
						//if(passwordField.getText().equals(confirmPasswordField.getText()))
						//{
							//System.out.println("Passwords match!");
							// Write to database
					// final DatabaseReference database = FirebaseDatabase.getInstance().getReference(usernameField.getText());
					final DatabaseReference database = FirebaseDatabase.getInstance().getReference("Users").child(usernameField.getText());
					
					//Map<String,User> user = new HashMap<>();
					//user.put(usernameField.getText(), new User(passwordField.getText()));
					database.setValueAsync(new User(usernameField.getText(), passwordField.getText()));
					
					// Go back to the main menu
					//	mainmenu.logIn(usernameField.getText());
					app.updateScene(new Profile(app, usernameField.getText()));
						//}
				}
			}
		});
		     
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
