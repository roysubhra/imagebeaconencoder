package roy.subhra.encoder;

import junit.framework.TestCase;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
import roy.subhra.encoder.impl.IntTruncator;
import roy.subhra.encoder.impl.TruncationStyleHolder;
import roy.subhra.encoder.impl.Truncator;

public class IntTruncatorTestCase extends TestCase {

	 
	Truncator truncator = new IntTruncator();
	TruncationStyleHolder holder = new TruncationStyleHolder(TruncationStyle.INTEGER, 5);
	public void testTruncate() {
		assertTrue(truncator.truncate(holder, 123456).equals("99999"));
		assertTrue(truncator.truncate(holder, -123456).equals("-9999"));
	}
	public void testNoTruncate() {
		assertTrue(truncator.truncate(holder, 12345).equals("12345"));
		assertTrue(truncator.truncate(holder, 123).equals("123"));
		assertTrue(truncator.truncate(holder, -123).equals("-123"));
		assertTrue(truncator.truncate(holder, -1234).equals("-1234"));
	}
}
