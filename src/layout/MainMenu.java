package layout;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class MainMenu implements CustomScreen{	
	private boolean loggedIn = false;
	private String username = null;
	private Main app;
	
	private MainMenuButton login;
	
	public MainMenu(Main app) {
		this.app =app;
	}
	
	public Scene getScene() {
		Button playOnline, playOffline, leaderboard, settings, tutorial, exit;
		int screenButtonCol = 2;
		ScreenFactory screenFactory = new ScreenFactory(app);
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
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		// User logged-in text
		if (this.loggedIn) {
			Text user = new Text();
			user.setFont(new Font(20));
			user.setFill(Color.WHITE);
			user.setText(this.username);
			user.setStyle("-fx-font: 40 arial;");
			user.setTextAlignment(TextAlignment.CENTER);
			GridPane.setHalignment(gameTitle, HPos.CENTER);
			gridpane.add(user, screenButtonCol, 0);
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
		gridpane.add(screenTitle, screenButtonCol, 1);
		GridPane.setMargin(screenTitle, new Insets(5, 10, 5, 10));
		
		// Login button
		login = new MainMenuButton(app, "Login", ScreenFactory.ScreenType.LOGIN);
		gridpane.add(login, screenButtonCol, 2);
		GridPane.setHalignment(login, HPos.CENTER);
		GridPane.setMargin(login, new Insets(5, 10, 5, 10));
		
		// Play online button
		playOnline = new MainMenuButton(app, "Play Online", ScreenFactory.ScreenType.PLAY_ONLINE);
		gridpane.add(playOnline, screenButtonCol, 3);
		GridPane.setHalignment(playOnline, HPos.CENTER);
		GridPane.setMargin(playOnline, new Insets(5, 10, 5, 10));
		
		// Play offline button
		playOffline = new MainMenuButton(app, "Play Offline", ScreenFactory.ScreenType.PLAY_OFFLINE);
		gridpane.add(playOffline, screenButtonCol, 4);
		GridPane.setHalignment(playOffline, HPos.CENTER);
		GridPane.setMargin(playOffline, new Insets(5, 10, 5, 10));
		
		// Settings button
		settings = new MainMenuButton(app, "Settings", ScreenFactory.ScreenType.SETTINGS);
		gridpane.add(settings, screenButtonCol, 5);
		GridPane.setHalignment(settings, HPos.CENTER);
		GridPane.setMargin(settings, new Insets(5, 10, 5, 10));
		
		// Leaderboard button
		leaderboard = new MainMenuButton(app, "Leaderboard", ScreenFactory.ScreenType.LEADERBOARD);
		gridpane.add(leaderboard, screenButtonCol, 6);
		GridPane.setHalignment(leaderboard, HPos.CENTER);
		GridPane.setMargin(leaderboard, new Insets(5, 10, 5, 10));
		
		// Tutorial button
		tutorial = new MainMenuButton(app, "Tutorial", ScreenFactory.ScreenType.TUTORIAL_RULES);
		gridpane.add(tutorial, screenButtonCol, 7);
		GridPane.setHalignment(tutorial, HPos.CENTER);
		GridPane.setMargin(tutorial, new Insets(5, 10, 5, 10));
		
		// Exit button
		exit = new Button("Exit");
		exit.setPrefHeight(25);
		exit.setPrefWidth(60);
		exit.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
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
	        		exit.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		exit.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		exit.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #24618F;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });
		 
		Scene scene = new Scene(gridpane, 800, 600);
		return scene;
	}
	
	public void logIn(String username) {
		this.username = username;
		this.loggedIn = true;
	}
}
