package layout;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Leaderboard extends Main implements CustomScreen{
	private TableView<PlayerName> table;
	
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
		 
		// Leader Board text
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Leaderboard");
		gameTitle.setStyle("-fx-font: 60 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(3, 12, 3, 12));
		
		table = new TableView<PlayerName>(); 
		table.getColumns().addAll(PlayerName.getColumn(table));
		table.setItems(getPlayerDummy());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		VBox root = new VBox();
        root.getChildren().addAll(table);
		
        gridpane.add(root, screenButtonCol, 1);
        
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
	public static ObservableList<PlayerName> getPlayerDummy() {
		ObservableList<PlayerName> data = FXCollections.observableArrayList();
		
		data.addAll(new PlayerName(1, "DFalessi", 30));
		data.addAll(new PlayerName(2, "Mark", 24));
		data.addAll(new PlayerName(3, "Ryan", 23));
		data.addAll(new PlayerName(4, "Anand", 19));

		return data;
	}
}
