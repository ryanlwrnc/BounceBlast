package layout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;
import layout.components.PlayOnlineButton;

public class PlayOnline extends Scene {
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Button start;
	private Text gameTitle;
	private Text ballTypes;
	private GridPane box;
	private ComboBox<String> cbBall;
	private ColumnConstraints cons1;
	private ColumnConstraints cons2;
	private RowConstraints rcons1;
	private RowConstraints rcons2;
	private TableView<Username> table;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public PlayOnline(Main app) {
		super(new GridPane(), 800, 600);
		this.gridpane =  (GridPane) getRoot();
		
		// Gridpane
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
		gameTitle.setText("Play Online");
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
				 "-fx-border-color: white;-fx-border-width: 3;");*/
		GridPane[] gridpanes = screenHelper.titleAndBox(gridpane, rcons1, rcons2,
    			cons1, cons2, SCREENBUTTONCOL, "Play Online");
        gridpane = gridpanes[0];
        box = gridpanes[1];
	    
	    ballTypes = new Text();
	    ballTypes.setFont(new Font(20));
	    ballTypes.setFill(Color.WHITE);
	    ballTypes.setText("Balls");
	    ballTypes.setStyle("-fx-font: 30 arial;");
	    ballTypes.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(ballTypes, HPos.LEFT);
		box.add(ballTypes, 0, 1);
		GridPane.setMargin(ballTypes, new Insets(5, 10, 5, 200));	
		
		cbBall = new ComboBox<>();
        cbBall.getItems().add("Basketball");
        cbBall.getItems().add("Bowling Ball");
        cbBall.getItems().add("Tennis Ball");
	    box.add(cbBall, 1, 1);
		
	    GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, SCREENBUTTONCOL, 1);

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
							
							app.setThread(new Thread(new GameEngine(app, scene)));
							Thread mainThread = app.getThread();
							mainThread.start();
							
					        //app.thread = new Thread(new GameEngine(app, scene));
					        //app.thread.start();
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
		//GridPane.setMargin(start, new Insets(5, 80, 30, 10));
		
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
				System.out.println(postSnapshot.toString());
				// Obtain the individual data
				Username post = postSnapshot.getValue(Username.class);
				System.out.println(post.toString());
				// Place the data into hashmap
				leaderboard.put(post.getUsername(), post);
		   }
			
			// ----- Utility code to help sort the leaderboard hashmap based on the score value.
	      Set<Entry<String, Username>> set = leaderboard.entrySet();
	      List<Entry<String, Username>> list = new ArrayList<>(set);
	      /*Collections.sort( list, new Comparator<Map.Entry<String, Username>>()
	      {
	      		public int compare( Map.Entry<String,Username> o1, Map.Entry<String,Username> o2 )
	      		{
	      			return o2.getValue().getUsername().compareTo(o1.getValue().getUsername());
	      		}
	      } );*/
	      Collections.sort(list, (Map.Entry<String,Username> o1, Map.Entry<String,Username> o2) -> o2.getValue().getUsername().compareTo(o1.getValue().getUsername()));
	      // -----
	      
	      // Now that the data from Firebase is sorted, now place each entry into the leaderboard.
	      	//int rank = 1;
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