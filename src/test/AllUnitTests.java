package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllTestsRyan.class, AllTestsElliot.class, AllTestsRey.class,
		AllTestsMark.class, AllTestsWon.class, AllTestsAnand.class })
public class AllUnitTests {

}
