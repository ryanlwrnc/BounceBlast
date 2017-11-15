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

public class MainMenu extends Main implements Screen{
	public Scene getScene() {
		Button login, playOnline, playOffline, leaderboard, settings, tutorial, exit;
		int screenButtonCol = 2;
		ScreenFactory screenFactory = new ScreenFactory();
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
		login = new Button("Login");
		login.setPrefHeight(50);
		login.setPrefWidth(200);
		login.setStyle(buttonStyle);
		gridpane.add(login, screenButtonCol, 2);
		GridPane.setHalignment(login, HPos.CENTER);
		GridPane.setMargin(login, new Insets(5, 10, 5, 10));
		login.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		login.setStyle(buttonHoverStyle);
	        }
	    });
		login.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		login.setStyle(buttonStyle);
	        }
	    });
		login.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen loginScreen = screenFactory.newScreen(ScreenFactory.ScreenType.LOGIN);
				updateScene(loginScreen.getScene());
			}
		});
		
		// Play online button
		playOnline = new Button("Play Online");
		playOnline.setPrefHeight(50);
		playOnline.setPrefWidth(200);
		playOnline.setStyle(buttonStyle);
		gridpane.add(playOnline, screenButtonCol, 3);
		GridPane.setHalignment(playOnline, HPos.CENTER);
		GridPane.setMargin(playOnline, new Insets(5, 10, 5, 10));
		playOnline.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		playOnline.setStyle(buttonHoverStyle);
	        }
	    });
		playOnline.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		playOnline.setStyle(buttonStyle);
	        }
	    });
		playOnline.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen playOnline = screenFactory.newScreen(ScreenFactory.ScreenType.PLAY_ONLINE);
				updateScene(playOnline.getScene());
				
			}
		});
		
		// Play offline button
		playOffline = new Button("Play Offline");
		playOffline.setPrefHeight(50);
		playOffline.setPrefWidth(200);
		playOffline.setStyle(buttonStyle);
		gridpane.add(playOffline, screenButtonCol, 4);
		GridPane.setHalignment(playOffline, HPos.CENTER);
		GridPane.setMargin(playOffline, new Insets(5, 10, 5, 10));
		playOffline.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		playOffline.setStyle(buttonHoverStyle);
	        }
	    });
		playOffline.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		playOffline.setStyle(buttonStyle);
	        }
	    });
		playOffline.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen playOffline = screenFactory.newScreen(ScreenFactory.ScreenType.PLAY_OFFLINE);
				updateScene(playOffline.getScene());
			}
		});
		
		// Settings button
		settings = new Button("Settings");
		settings.setPrefHeight(50);
		settings.setPrefWidth(200);
		settings.setStyle(buttonStyle);
		gridpane.add(settings, screenButtonCol, 5);
		GridPane.setHalignment(settings, HPos.CENTER);
		GridPane.setMargin(settings, new Insets(5, 10, 5, 10));
		settings.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		settings.setStyle(buttonHoverStyle);
	        }
	    });
		settings.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		settings.setStyle(buttonStyle);
	        }
	    });
		settings.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen settings = screenFactory.newScreen(ScreenFactory.ScreenType.SETTINGS);
				updateScene(settings.getScene());
			}
		});
		
		// Leaderboard button
		leaderboard = new Button("Leaderboard");
		leaderboard.setPrefHeight(50);
		leaderboard.setPrefWidth(200);
		leaderboard.setStyle(buttonStyle);
		gridpane.add(leaderboard, screenButtonCol, 6);
		GridPane.setHalignment(leaderboard, HPos.CENTER);
		GridPane.setMargin(leaderboard, new Insets(5, 10, 5, 10));
		leaderboard.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		leaderboard.setStyle(buttonHoverStyle);
	        }
	    });
		leaderboard.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		leaderboard.setStyle(buttonStyle);
	        }
	    });
		leaderboard.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen leaderboard = screenFactory.newScreen(ScreenFactory.ScreenType.LEADERBOARD);
				updateScene(leaderboard.getScene());
			}
		});
		
		// Tutorial button
		tutorial = new Button("Tutorial");
		tutorial.setPrefHeight(50);
		tutorial.setPrefWidth(200);
		tutorial.setStyle(buttonStyle);
		gridpane.add(tutorial, screenButtonCol, 7);
		GridPane.setHalignment(tutorial, HPos.CENTER);
		GridPane.setMargin(tutorial, new Insets(5, 10, 5, 10));
		tutorial.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		tutorial.setStyle(buttonHoverStyle);
	        }
	    });
		tutorial.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		tutorial.setStyle(buttonStyle);
	        }
	    });
		tutorial.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Screen tutorial = screenFactory.newScreen(ScreenFactory.ScreenType.TUTORIAL);
				updateScene(tutorial.getScene());
			}
		});
		
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
}
