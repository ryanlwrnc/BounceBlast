package layout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import game.GameEngine;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class Main extends Application {

	protected static Thread thread = null;
	protected static Thread pod = null; //platform of death

	// --- Used to obtain screen bounds for maximizing screen resolution
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	// ---

	static Scene myScene;
	static Stage myStage;

	public static void main(String[] args) throws IOException {
		// TESTING Firebase, to be removed later
		FileInputStream serviceAccount = new FileInputStream(
				"bounceblast-12d9c-firebase-adminsdk-5agr2-4d1fd4fbc0.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://bounceblast-12d9c.firebaseio.com/").build();

		FirebaseApp.initializeApp(options);
		/*
		 * final DatabaseReference database =
		 * FirebaseDatabase.getInstance().getReference(); //DatabaseReference ref =
		 * database.getReference("accounts"); //DatabaseReference usersRef =
		 * database.child("users");
		 * 
		 * // Write to database Map<String,User> users = new HashMap<>();
		 * users.put("dfalessi", new User("123qwe@", 1000));
		 * database.setValueAsync(users);
		 * 
		 * /* // Read from database database.child("dfalessi").addValueEventListener(new
		 * ValueEventListener() {
		 * 
		 * @Override public void onDataChange(DataSnapshot dataSnapshot) { User note =
		 * dataSnapshot.getValue(User.class); System.out.println(note.password);
		 * System.out.println(note.score); }
		 * 
		 * @Override public void onCancelled(DatabaseError arg0) { // TODO
		 * Auto-generated method stub
		 * 
		 * } }); //
		 * 
		 * // TESTING Firebase, to be removed later
		 */
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		myStage = stage;
		CustomScreen mainMenu = new MainMenu(this);
		myScene = mainMenu.getScene();
		myStage.setScene(myScene);
		myStage.setResizable(false);
		// --- Maximized screen resolution
		myStage.setX(bounds.getMinX());
		myStage.setY(bounds.getMinY());
		myStage.setWidth(bounds.getWidth());
		myStage.setHeight(bounds.getHeight());
		// myStage.setFullScreen(true);
		// ---
		myStage.show();
	}

	public void updateScene(Scene s) {
		myScene = s;
		myStage.setScene(myScene);
		// --- Maximized screen resolution
		myStage.setResizable(false);
		myStage.setX(bounds.getMinX());
		myStage.setY(bounds.getMinY());
		// myStage.setFullScreen(true);
		// ---
		myStage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		if (thread != null) {
			thread.interrupt();
		}
		if (pod != null) {
			pod.interrupt();
		}
		System.out.println("Stopping application");
	}
}
