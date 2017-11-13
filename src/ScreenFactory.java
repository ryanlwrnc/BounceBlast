import javafx.scene.Scene;

public class ScreenFactory extends Main{
	
	public void newScreen(String screenType)
	{
		Screen screen = null;
		Scene scene = null;
		if(screenType.equals("Main Menu"))
			screen = new MainMenu();
		else if(screenType.equals("Login"))
			screen = new Login();
	/*	else if(screenType.equals("Play Online"))
			screen = new PlayOnline();
		else if(screenType.equals("Play Offline"))
			screen = new PlayOffline();
		else if(screenType.equals("Settings"))
			screen = new Settings();
		else if(screenType.equals("Leaderboard"))
			screen = new Leaderboard();
		else if(screenType.equals("Tutorial"))
			screen = new Tutorial();
	*/	
		scene = screen.getScene();
		updateScene(scene);
	}
}
