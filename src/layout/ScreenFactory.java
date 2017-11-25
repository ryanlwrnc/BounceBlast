package layout;
import game.GameScene;

public class ScreenFactory {
	
	private Main app;
	
	public ScreenFactory(Main app) {
		this.app =app;
	}
	
	public enum ScreenType {
		MAIN_MENU("Main Menu"),
		LOGIN("Login"),
		CREATE_NEW_ACCOUNT("Create New Account"),	// ADDED
		PLAY_ONLINE("Play Online"),
		PLAY_ONLINE_LOBBY("Play Online Lobby"),
		PLAY_OFFLINE("Play Offline"),
		IN_GAME("In Game"),
		SETTINGS("Settings"),
		LEADERBOARD("Leaderboard"),
		GAME_SCENE("Game Scene"),
		TUTORIAL_RULES("TutorialRules"),
		TUTORIAL_CONTROLS("TutorialControls"),
		TUTORIAL_STRATEGY("TutorialStrategy");
		
		private String screenName;
		
		ScreenType(String screenName) {
			this.screenName = screenName;
		}
		
		public String getScreenName() {
			return this.screenName;
		}
	};
	
	public CustomScreen newScreen(ScreenType screenType)
	{
		CustomScreen screen;
		switch (screenType) {
		case MAIN_MENU:
			screen =  new MainMenu(app);
			break;
		case LOGIN:
			screen =  new Login(app);
			break;
		case CREATE_NEW_ACCOUNT:
			screen = new CreateAccount(app);
			break;
		case PLAY_ONLINE:
			screen = new PlayOnline(app);
			break;
		case PLAY_ONLINE_LOBBY:
			screen = new PlayOnlineLobby(app);
			break;
		case PLAY_OFFLINE:
			screen = new PlayOffline(app);
			break;
		case SETTINGS:
			screen = new Settings(app);
			break;
		case IN_GAME:
			screen = new InGame();
			break;
		case GAME_SCENE:
			screen = new GameScene();
			break;
		case TUTORIAL_RULES:
			screen = new TutorialRules(app);
			break;
		case TUTORIAL_CONTROLS:
			screen = new TutorialControls(app);
			break;
		case TUTORIAL_STRATEGY:
			screen = new TutorialStrategy(app);
			break;
		case LEADERBOARD:
			screen =  new Leaderboard(app);
			break;
		default:
			screen = null;
		}
		return screen;
	}	
}
