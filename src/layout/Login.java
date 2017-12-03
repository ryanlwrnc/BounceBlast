package layout;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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

public class Login extends Scene {
	
	// JavaFX
	private GridPane gridpane;
	
	// Components
	BackToMainMenuButton back;
	Button doLogin;
	Button createAccount;
	Text gameTitle;
	Text username;
	Text password;
	GridPane box;
	ColumnConstraints cons1;
	ColumnConstraints cons2;
	RowConstraints rcons1;
	RowConstraints rcons2;
	final TextField usernameField;
	final PasswordField passwordField;
	boolean verified;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public Login(Main app) {
		super(new GridPane(),800,600);
		this.gridpane = (GridPane) getRoot();
		verified = false;
		
		cons1 = new ColumnConstraints();
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
		gridpane.setStyle("-fx-background-image: url('file:background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		 
		// BounceBlast text
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Login");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, SCREENBUTTONCOL, 0);
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
				 "-fx-border-color: white;-fx-border-width: 3;");
        
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
        
        // Login button
        doLogin = new Button("Login");
        doLogin.setPrefHeight(40);
        doLogin.setPrefWidth(100);
        doLogin.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		box.add(doLogin, 0, 10);
		GridPane.setHalignment(doLogin, HPos.CENTER);
		GridPane.setMargin(doLogin, new Insets(5, 10, 5, 10));
		
		// Login is pressed
		doLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// If username and password fields are filled.
				if (!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty()) {
					// Verify that the username exists and the password matches.
					//final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
					final FirebaseDatabase ref = FirebaseDatabase.getInstance();
					DatabaseReference database = ref.getReference("Users");
					
					database.child(usernameField.getText()).addValueEventListener(new ValueEventListener() {
						
						@Override
						public void onDataChange(DataSnapshot dataSnapshot) {
						        User note = dataSnapshot.getValue(User.class);
						        // If password matches
						        if(passwordField.getText().equals(note.getPassword())) {
					   					verified = true;
					   					app.currentUser = note.getUsername();
						        }
						}
						
						@Override
						public void onCancelled(DatabaseError arg0)
						{
							// still need to implement
						}
					});
					
					//Quarter second buffer to let firebase verify login
					try 
					{
						Thread.sleep(250);
					}
					catch(Exception e){
						Thread.currentThread().interrupt();
					}
					
					if(verified) {
						final DatabaseReference lobbyRef = FirebaseDatabase.getInstance().getReference("Lobby");
						DatabaseReference pushedPostRef = lobbyRef.push();

						// Get the unique ID generated by a push()
						String postId = pushedPostRef.getKey();
						Username u = new Username(app.currentUser);
						
						Map<String, Object> userNicknameUpdates = new HashMap<>();
						userNicknameUpdates.put(postId, u);
						
						lobbyRef.child(postId).setValue(u);
						app.updateScene(new MainMenu(app));
					}
					else 
						JOptionPane.showMessageDialog(null, "Game Over!", "BounceBlast", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		// Create Account button
		createAccount = new Button("Create New Account");
		createAccount.setPrefHeight(40);
		createAccount.setPrefWidth(190);
		createAccount.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		 box.add(createAccount, 1, 10);
		 GridPane.setHalignment(createAccount, HPos.CENTER);
		 GridPane.setMargin(createAccount, new Insets(5, 10, 5, 10));
		
		// Go to Create New Account Screen when button is pressed
		createAccount.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					app.updateScene(new CreateAccount(app));
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
