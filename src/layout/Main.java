package layout;
import game.GameEngine;
import game.SimpleGameEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	protected static Thread thread = null;
    protected static GameEngine runnable = null;
	
	
	static Scene myScene;
	static Stage myStage;
	public static void main(String[] args) {
        launch(args);
    	}
	@Override
	public void start(Stage stage) throws Exception{
		myStage = stage;
		Screen mainMenu = new MainMenu();
		myScene = mainMenu.getScene();
		myStage.setScene(myScene);
		myStage.setResizable(false);
		myStage.show();
	}
	
	public void updateScene(Scene s)
	{
		myScene = s;
		myStage.setScene(myScene);
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
