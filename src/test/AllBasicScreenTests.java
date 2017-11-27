// Author: Anand Batjargal
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestLeaderboard.class, TestMainMenu.class, TestScreenFactory.class, TestSettings.class,
	TestTutorialControls.class, TestTutorialRules.class, TestTutorialStrategy.class })
public class AllBasicScreenTests {

}
