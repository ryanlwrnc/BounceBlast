package layout;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.MainMenuButton;

public class MainMenu extends Scene{
	
	// JavaFX
	private GridPane gridpane;
	
	// Log in
	private boolean loggedIn = false;
	String username = null;
	
	// Components
	private Button login;
	private Button playOnline;
	private Button playOffline;
	private Button leaderboard;
	private Button settings;
	private Button tutorial;
	private Button exit;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	private static final String  BORDER3 = "-fx-border-width: 3;";
	private static final String BORDERWHITE = "-fx-border-color: white;";
	private static final String TEXTFILLWHITE = "-fx-text-fill: white;";
	private static final String FONT16 = "-fx-font-size: 16;";
	
	public MainMenu(Main app) {
		super(new GridPane(), 800, 600);
		
		if (app.getCurrentUser() != null) {
			username = app.getCurrentUser();
			loggedIn = true;
		}
		
		// GridPane
		gridpane = (GridPane) getRoot();
		/*ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        gridpane.getColumnConstraints().add(cons1);
        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        gridpane.getRowConstraints(
        		).addAll(rcons1, rcons2);
		
        gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");*/
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		 
		// BounceBlast text
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, SCREENBUTTONCOL, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		// User logged-in text
		if (this.loggedIn) {
			Text user = new Text();
			user.setFont(new Font(20));
			user.setFill(Color.WHITE);
			user.setText("Welcome " + this.username);
			user.setStyle("-fx-font: 40 arial;");
			user.setTextAlignment(TextAlignment.CENTER);
			GridPane.setHalignment(gameTitle, HPos.CENTER);
			gridpane.add(user, SCREENBUTTONCOL, 0);
			GridPane.setMargin(user, new Insets(5, 10, 5, 10));
		}
		
		// Main menu text
		Text screenTitle = new Text();
		screenTitle.setFont(new Font(20));
		screenTitle.setFill(Color.WHITE);
		screenTitle.setText("Main Menu");
		screenTitle.setStyle("-fx-font: 50 arial;");
		screenTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(screenTitle, HPos.CENTER);
		gridpane.add(screenTitle, SCREENBUTTONCOL, 1);
		GridPane.setMargin(screenTitle, new Insets(5, 10, 5, 10));
		
		// Login & Profile button
		
		/* Delete 
		app.setUsername("anand");
		loggedIn = true;
		 Delete */
		
		if(this.loggedIn)
			login = new MainMenuButton(app, "Profile", new Profile(app,this.username));
		else
			login = new MainMenuButton(app, "Log In", new Login(app));	// CHANGED
		gridpane.add(login, SCREENBUTTONCOL, 2);
		GridPane.setHalignment(login, HPos.CENTER);
		GridPane.setMargin(login, new Insets(5, 10, 5, 10));
		
		// Play online button
		playOnline = new MainMenuButton(app, "Play Online", null);
		playOnline.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	if (loggedIn) {
	        		app.updateScene(new PlayOnline(app));
	        	}
	        	else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setContentText("Must be logged in to play online.");
				alert.showAndWait();
	        		//JOptionPane.showMessageDialog(null, "Must be logged in to play online", "BounceBlast", JOptionPane.INFORMATION_MESSAGE);
	        	}
	        }
	    });
		
		gridpane.add(playOnline, SCREENBUTTONCOL, 3);
		GridPane.setHalignment(playOnline, HPos.CENTER);
		GridPane.setMargin(playOnline, new Insets(5, 10, 5, 10));
		
		// Play offline button
		playOffline = new MainMenuButton(app, "Play Offline", new PlayOffline(app));
		gridpane.add(playOffline, SCREENBUTTONCOL, 4);
		GridPane.setHalignment(playOffline, HPos.CENTER);
		GridPane.setMargin(playOffline, new Insets(5, 10, 5, 10));
		
		// Settings button
		settings = new MainMenuButton(app, "Settings", new Settings(app));
		gridpane.add(settings, SCREENBUTTONCOL, 5);
		GridPane.setHalignment(settings, HPos.CENTER);
		GridPane.setMargin(settings, new Insets(5, 10, 5, 10));
		
		// Leaderboard button
		leaderboard = new MainMenuButton(app, "Leaderboard", Leaderboard.getInstance(app));
		gridpane.add(leaderboard, SCREENBUTTONCOL, 6);
		GridPane.setHalignment(leaderboard, HPos.CENTER);
		GridPane.setMargin(leaderboard, new Insets(5, 10, 5, 10));
		
		// Tutorial button
		tutorial = new MainMenuButton(app, "Tutorial", new TutorialRules(app));
		gridpane.add(tutorial, SCREENBUTTONCOL, 7);
		GridPane.setHalignment(tutorial, HPos.CENTER);
		GridPane.setMargin(tutorial, new Insets(5, 10, 5, 10));
		
		// Exit button
		exit = new Button("Exit");
		exit.setPrefHeight(25);
		exit.setPrefWidth(60);
		exit.setStyle(BORDER3 + 
				BORDERWHITE + 
				"-fx-background-color: #24618F;" +
				FONT16 + 
				TEXTFILLWHITE);
		gridpane.add(exit, 0, 10);
		GridPane.setHalignment(exit, HPos.CENTER);
		GridPane.setMargin(exit, new Insets(5, 10, 5, 10));
		// Exit the application when exit pressed
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		exit.setStyle(BORDER3 + 
	        				BORDERWHITE + 
	        				"-fx-background-color: #003399;" +
	        				FONT16 + 
	        				TEXTFILLWHITE);
	        }
	    });

		exit.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		exit.setStyle(BORDER3 + 
	        				BORDERWHITE + 
	        				"-fx-background-color: #24618F;" +
	        				FONT16 + 
	        				TEXTFILLWHITE);
	        }
	    });
	}
	
	public void logIn(String username) {
		this.username = username;
		this.loggedIn = true;
	}
	public String getUsername() {
		return this.username;
	}
}
