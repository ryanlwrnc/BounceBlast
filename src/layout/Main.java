package layout;

import java.io.FileInputStream;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class Main extends Application {
	
	private Thread thread = null;
	private Thread pod = null; //platform of death
	private String currentUser = null;

	// --- Used to obtain screen bounds for maximizing screen resolution
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	// ---

	protected Scene myScene;
	protected Stage myStage;

	//Player name
	private String username = null;
	
	public static void main(String[] args) throws IOException {
		// TESTING Firebase, to be removed later
		FileInputStream serviceAccount = new FileInputStream(
				"bounceblast-12d9c-firebase-adminsdk-5agr2-4d1fd4fbc0.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://bounceblast-12d9c.firebaseio.com/").build();

		FirebaseApp.initializeApp(options);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		myStage = stage;
		myScene = new MainMenu(this);
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
	}
	
	public void setUsername(String s)
	{
		username = s;
	}
	
	public String getUsername()
	{
		return username;
	}
	public Scene getMyScene() {
		return this.myScene;
	}
	public void setStage(Stage stage) {
		this.myStage = stage;
	}
	public String getCurrentUser() {
		return this.currentUser;
	}
	public void setCurrentUser(String user) {
		this.currentUser = user;
	}
	public Thread getThread() {
		return this.thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public Thread getPod() {
		return this.pod;
	}
	public void setPod(Thread pod) {
		this.pod = pod;
	}
}
