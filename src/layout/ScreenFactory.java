package layout;
import game.GameScene;

public class ScreenFactory {
	public enum ScreenType {
		MAIN_MENU("Main Menu"),
		LOGIN("Login"),
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
	
	public Screen newScreen(ScreenType screenType)
	{
		Screen screen;
		switch (screenType) {
		case MAIN_MENU:
			screen =  new MainMenu();
			break;
		case LOGIN:
			screen =  new Login();
			break;
		case PLAY_ONLINE:
			screen = new PlayOnline();
			break;
		case PLAY_ONLINE_LOBBY:
			screen = new PlayOnlineLobby();
			break;
		case PLAY_OFFLINE:
			screen = new PlayOffline();
			break;
		case SETTINGS:
			screen = new Settings();
			break;
		case IN_GAME:
			screen = new InGame();
			break;
		case GAME_SCENE:
			screen = new GameScene();
			break;
		case TUTORIAL_RULES:
			screen = new TutorialRules();
			break;
		case TUTORIAL_CONTROLS:
			screen = new TutorialControls();
			break;
		case TUTORIAL_STRATEGY:
			screen = new TutorialStrategy();
			break;
			/*
		case ScreenType.LEADERBOARD.getScreenName():
			return new LeaderBoard();
			break;
		case ScreenType.LEADERBOARD.getScreenName():
			return new Tutorial();
			break;
			*/
		default:
			screen = null;
		}
		return screen;
	}	
}
