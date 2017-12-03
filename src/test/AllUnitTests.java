package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllUnitTestsRyan.class, AllUnitTestsElliot.class, AllUnitTestsRey.class,
		AllUnitTestsMark.class, AllUnitTestsWon.class, AllUnitTestsAnand.class })
public class AllUnitTests {

}
