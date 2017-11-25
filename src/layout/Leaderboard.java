package layout;
import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

import java.util.ArrayList;
//
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Leaderboard implements CustomScreen{
	private TableView<PlayerName> table;
	private Main app;
	
	public Leaderboard(Main app) {
		this.app = app;
	}
	
	public Scene getScene() {
		Button back;
		ScreenFactory screenFactory = new ScreenFactory(app);
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
 				app.updateScene(mainmenu.getScene());
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
		
		// Fill data object with data from Firebase
		final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
		
		database.addValueEventListener(new ValueEventListener() {
		@Override
		public void onDataChange(DataSnapshot snapshot) {
			HashMap<String,Integer> leaderboard = new HashMap<String, Integer>();
			
			for (DataSnapshot postSnapshot: snapshot.getChildren()) {
				User post = postSnapshot.getValue(User.class);
				System.out.println(post.score);
				leaderboard.put(post.username, post.score);
		   }
			
			Set<Entry<String, Integer>> set = leaderboard.entrySet();
	        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	            {
	                return (o2.getValue()).compareTo( o1.getValue() );
	            }
	        } );
	        
	        int rank = 1;
	        for(Map.Entry<String, Integer> entry:list){
	            data.addAll(new PlayerName(rank++, entry.getKey(), entry.getValue()));
	        }
		}

		@Override
		public void onCancelled(DatabaseError error)
		{
			// TODO Auto-generated method stub
			
		}

		});
		//
		/*
		data.addAll(new PlayerName(1, "DFalessi", 30));
		data.addAll(new PlayerName(2, "Mark", 24));
		data.addAll(new PlayerName(3, "Ryan", 23));
		*/
		return data;
	}
}
