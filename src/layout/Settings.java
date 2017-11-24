package layout;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Settings extends Main implements CustomScreen {

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
		gameTitle.setText("Settings");
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
        
        Text sound = new Text();
        sound.setFont(new Font(20));
        sound.setFill(Color.WHITE);
        sound.setText("Sound");
        sound.setStyle("-fx-font: 30 arial;");
        sound.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(sound, HPos.RIGHT);
		box.add(sound, 0, 0);
		GridPane.setMargin(sound, new Insets(5, 10, 5, 10));	

		 
		Slider soundSlider = new Slider(0, 1, 0.5);
		box.add(soundSlider, 1, 0);
	
		Text directionKeys = new Text();
		directionKeys.setFont(new Font(20));
		directionKeys.setFill(Color.WHITE);
		directionKeys.setText("Direction Keys");
		directionKeys.setStyle("-fx-font: 30 arial;");
		directionKeys.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(directionKeys, HPos.RIGHT);
		box.add(directionKeys, 0, 1);
		GridPane.setMargin(directionKeys, new Insets(5, 10, 5, 10));	
		
		ComboBox<String> cbDirection = new ComboBox<String>();
        cbDirection.getItems().add("Arrow Keys");
        cbDirection.getItems().add("WASD");
        cbDirection.getItems().add("FGHJ");
	    box.add(cbDirection, 1, 1);
	    
	    Text colorScheme = new Text();
	    colorScheme.setFont(new Font(20));
	    colorScheme.setFill(Color.WHITE);
	    colorScheme.setText("Color Scheme");
	    colorScheme.setStyle("-fx-font: 30 arial;");
	    colorScheme.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(colorScheme, HPos.RIGHT);
		box.add(colorScheme, 0, 2);
		GridPane.setMargin(colorScheme, new Insets(5, 10, 5, 10));	
		
		ComboBox<String> cbColorScheme = new ComboBox<String>();
        cbColorScheme.getItems().add("Bounce White");
        cbColorScheme.getItems().add("Blast Dark");
        cbColorScheme.getItems().add("Gamer Green");
	    box.add(cbColorScheme, 1, 2);
		
		/*MenuButton menuButton = new MenuButton();
		menuButton.getItems().addAll(new MenuItem("Arrow Keys"), new MenuItem("WASD"),
				new MenuItem("FGHJ"));
		box.add(menuButton, 1, 1);*/
		
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
				CustomScreen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				updateScene(mainmenu.getScene());
			}
		});
		back.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		back.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		back.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		back.setStyle("-fx-border-width: 3;" + 
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
