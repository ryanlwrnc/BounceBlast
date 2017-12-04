package layout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import game.GameEngine;
import game.GameScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import layout.components.BackToMainMenuButton;
import layout.components.PlayOnlineButton;

public class PlayOnline extends Scene {
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Button start;
	private GridPane box;
	private ComboBox<String> cbBall;
	private TableView<Username> table;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public PlayOnline(Main app) {
		super(new GridPane(), 800, 600);
		this.gridpane =  (GridPane) getRoot();
		
		// Gridpane
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		 
        gridpane = screenHelper.setTitle(gridpane, "Play Online", SCREENBUTTONCOL);
		
		 //Adding GridPane
        box = new GridPane();
        box.setPadding(new Insets(20,20,20,20));
        box.setMaxWidth(650);
        box.setMaxHeight(250);
        box.setHgap(5);
        box.setVgap(5);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");
	    
        gridpane = screenHelper.setupPlayGame(gridpane, box, SCREENBUTTONCOL);
	    cbBall = screenHelper.getCbBall();

		// Start Button
		start = new PlayOnlineButton(app, "Start", new GameScene(app, "3", "Basketball"));
		start.setPrefHeight(25);
		start.setPrefWidth(65);
		start.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		// Go to the temporary game scene when the button is pressed.
				start.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						// Make sure NumberOfCPUs and SelectGameBall are selected
						if(cbBall.getValue() != null) {

							// Create a new GameScene, that is created based on what the users ball is as well as the number of CPUs.
							GameScene scene = new GameScene(app, "3", cbBall.getValue());

							app.updateScene(scene);
							
							app.setThread(new Thread(new GameEngine(app, scene, "3")));
							Thread mainThread = app.getThread();
							mainThread.start();
							
						}
					}
				});
		
		
		gridpane.add(start, 2, 5);
		GridPane.setHalignment(start, HPos.CENTER);
		GridPane.setMargin(start, new Insets(5, 80, 30, 10));
		
		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		
		// Lobby
		table = new TableView<>(); 
		table.setPrefHeight(200);
		table.setPrefWidth(300);
		gridpane.add(table, 2, 2);
		GridPane.setHalignment(table, HPos.CENTER);
		
		table.getColumns().addAll(Username.getColumn(table));
		table.setItems(getPlayerDummy());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setMaxWidth(300);
		// Return to Main Menu when back is pressed
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
	
	public static ObservableList<Username> getPlayerDummy() {
		
		ObservableList<Username> data = FXCollections.observableArrayList();
		
		// Fill data object with data from Firebase
		final DatabaseReference database = FirebaseDatabase.getInstance().getReference("Lobby");
		
		database.addValueEventListener(new ValueEventListener() {
			
		@Override
		public void onDataChange(DataSnapshot snapshot) {
			// Create a new hashmap to place leaderboard data from Firebase
			HashMap<String, Username> leaderboard = new HashMap<>();
			
			// For each data entry in Firebase
			for (DataSnapshot postSnapshot: snapshot.getChildren()) {
				// Obtain the individual data
				Username post = postSnapshot.getValue(Username.class);
				// Place the data into hashmap
				leaderboard.put(post.getUsername(), post);
		   }
			
			// ----- Utility code to help sort the leaderboard hashmap based on the score value.
	      Set<Entry<String, Username>> set = leaderboard.entrySet();
	      List<Entry<String, Username>> list = new ArrayList<>(set);
	      Collections.sort(list, (Map.Entry<String,Username> o1, Map.Entry<String,Username> o2) -> o2.getValue().getUsername().compareTo(o1.getValue().getUsername()));
	      // -----
	      
	      // Now that the data from Firebase is sorted, now place each entry into the leaderboard.
	      	for(Map.Entry<String, Username> entry : list) {
	      		data.addAll(entry.getValue());
	      	}
		}

		@Override
		public void onCancelled(DatabaseError error)
		{
			// still need to implement
		}

		});
		
		return data;
	}
}