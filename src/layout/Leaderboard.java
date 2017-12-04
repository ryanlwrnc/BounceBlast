package layout;
import java.util.ArrayList;
//
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class Leaderboard extends Scene {
	//Leaderboard instance
	private static Leaderboard instance = null;
	
	//JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Text gameTitle;
	private TableView<PlayerName> table;
		
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	private Leaderboard(Main app) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
	
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		 
		// Leader Board text
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Leaderboard");
		gameTitle.setStyle("-fx-font: 60 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, SCREENBUTTONCOL, 0);
		GridPane.setMargin(gameTitle, new Insets(3, 12, 3, 12));
		
		table = new TableView<>(); 
		table.getColumns().addAll(PlayerName.getColumn(table));
		table.setItems(getPlayerDummy());
//		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
        GridPane.setHalignment(table, HPos.CENTER);
        gridpane.add(table, SCREENBUTTONCOL, 1);
        table.setMaxWidth(800);
        table.setMaxHeight(500);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        // Back button
 		back = new BackToMainMenuButton(app, "Back");
 		gridpane.add(back, 0, 10);
 		GridPane.setHalignment(back, HPos.CENTER);
 		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		
	}
		
	public static ObservableList<PlayerName> getPlayerDummy() {
		ObservableList<PlayerName> data = FXCollections.observableArrayList();
		
		// Fill data object with data from Firebase
		final DatabaseReference database = FirebaseDatabase.getInstance().getReference("Users");
		database.addValueEventListener(new ValueEventListener() {
			
		@Override
		public void onDataChange(DataSnapshot snapshot) {
			// Create a new hashmap to place leaderboard data from Firebase
			HashMap<String,User> leaderboard = new HashMap<>();
			
			// For each data entry in Firebase
			for (DataSnapshot postSnapshot: snapshot.getChildren()) {
				// Obtain the individual data
				User post = postSnapshot.getValue(User.class);
				// Place the data into hashmap
				leaderboard.put(post.getUsername(), post);
		   }
			
			// ----- Utility code to help sort the leaderboard hashmap based on the score value.
	      Set<Entry<String, User>> set = leaderboard.entrySet();
	      List<Entry<String, User>> list = new ArrayList<>(set);
	      /*Collections.sort( list, new Comparator<Map.Entry<String, User>>()
	      {
	      		public int compare( Map.Entry<String,User> o1, Map.Entry<String,User> o2 )
	      		{
	      			return o2.getValue().getScore().compareTo(o1.getValue().getScore());
	      		}
	      } );*/
	      Collections.sort(list, (Map.Entry<String,User> o1, Map.Entry<String,User> o2) -> o2.getValue().getScore().compareTo(o1.getValue().getScore()));
	      // -----
	      
	      // Now that the data from Firebase is sorted, now place each entry into the leaderboard.
	      	int rank = 1;
	      	for(Map.Entry<String, User> entry:list){
	      		data.addAll(new PlayerName(rank++, entry.getKey(), entry.getValue().getScore(), entry.getValue().getWin(), entry.getValue().getLoss()));
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
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
	
	public static Leaderboard getInstance(Main m)
	{
		if(instance == null)
			instance = new Leaderboard(m);
		return instance;
	}
}
