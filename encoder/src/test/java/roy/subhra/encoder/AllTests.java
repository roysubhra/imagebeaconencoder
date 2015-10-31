package roy.subhra.encoder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayTruncatorTestCase.class, EncodeTestCase.class, IntTruncatorTestCase.class,
		LeftStringTruncatorTestCase.class, RightStringTruncatorTestCase.class, TruncatorFactoryTestCase.class })
public class AllTests {

}
