package layout;
import game.GameEngine;
import game.SimpleGameEngine;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class Main extends Application{
	
	protected static Thread thread = null;
   protected static GameEngine runnable = null;
   
   // --- Used to obtain screen bounds for maximizing screen resolution
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	// --- 
	
	static Scene myScene;
	static Stage myStage;
	public static void main(String[] args) {
        launch(args);
    	}
	@Override
	public void start(Stage stage) throws Exception{
		myStage = stage;
		CustomScreen mainMenu = new MainMenu();
		myScene = mainMenu.getScene();
		myStage.setScene(myScene);
		myStage.setResizable(false);
		// --- Maximized screen resolution
		myStage.setX(bounds.getMinX());
		myStage.setY(bounds.getMinY());
		myStage.setWidth(bounds.getWidth());
		myStage.setHeight(bounds.getHeight());
		//myStage.setFullScreen(true);
		// --- 
		myStage.show();
	}
	
	public void updateScene(Scene s)
	{
		myScene = s;
		myStage.setScene(myScene);
		// --- Maximized screen resolution
		myStage.setResizable(false);
		myStage.setX(bounds.getMinX());
		myStage.setY(bounds.getMinY());
		//myStage.setFullScreen(true);
		// ---
		myStage.show();
	}
	@Override
	public void stop() throws Exception {
		super.stop();
		if (thread != null) {
			thread.interrupt();
		}
		System.out.println("Stopping application");
	}
}
