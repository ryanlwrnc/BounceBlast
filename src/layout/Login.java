package layout;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Login extends Main implements Screen {

	@Override
	public Scene getScene() {
		Button back;
		ScreenFactory screenFactory = new ScreenFactory();
		int screenButtonCol = 2;
		GridPane gridpane = new GridPane();
		ColumnConstraints cons1 = new ColumnConstraints();
		cons1.setHgrow(Priority.NEVER);
		gridpane.getColumnConstraints().add(cons1);
		
		ColumnConstraints cons2 = new ColumnConstraints();
		cons2.setHgrow(Priority.ALWAYS);
		
		gridpane.getColumnConstraints().addAll(cons1, cons2);
		
		RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        gridpane.getRowConstraints().addAll(rcons1, rcons2);
		gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		 
		// BounceBlast text
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Login");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        GridPane box = new GridPane();
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
        Text username = new Text();
        username.setFont(new Font(20));
        username.setFill(Color.WHITE);
        username.setText("Username");
        username.setStyle("-fx-font: 30 arial;");
        username.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setHalignment(username, HPos.RIGHT);
        
        // Password text
        Text password = new Text();
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
        final TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        box.add(usernameField, 1, 0);
        
        // Password field
        final TextField passwordField = new TextField();
        passwordField.setPromptText("Enter your password");
        box.add(passwordField, 1, 1);
        
        // Login button
        Button login = new Button("login");
        login.setPrefHeight(40);
		login.setPrefWidth(100);
		login.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		box.add(login, 0, 10);
		GridPane.setHalignment(login, HPos.CENTER);
		GridPane.setMargin(login, new Insets(5, 10, 5, 10));
		// Login when login button is pressed
		login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Screen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				updateScene(mainmenu.getScene());
			}
		});
        
		gridpane.add(box, screenButtonCol, 1);
		
		// Back button
		back = new Button("Back");
		back.setPrefHeight(25);
		back.setPrefWidth(65);
		back.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		// Return to Main Menu when back is pressed
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Screen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				//	mainmenu.logIn(usernameField.getText());
				updateScene(mainmenu.getScene());
			}
		});
		
        Scene scene = new Scene(gridpane, 800, 600);
		return scene;
	}

}
