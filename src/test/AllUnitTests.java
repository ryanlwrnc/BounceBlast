package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllBallTests.class, AllGameplayScreenTests.class, AllGameTests.class,
		AllHelperClassTests.class, AllUserProfileTests.class })
public class AllUnitTests {

}
