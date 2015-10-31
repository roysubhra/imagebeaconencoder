package roy.subhra.encoder;

import junit.framework.TestCase;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
import roy.subhra.encoder.impl.RightStringTruncator;
import roy.subhra.encoder.impl.TruncationStyleHolder;
import roy.subhra.encoder.impl.Truncator;

public class RightStringTruncatorTestCase extends TestCase {

	Truncator truncator = new RightStringTruncator();
	TruncationStyleHolder holder = new TruncationStyleHolder(TruncationStyle.STRING_RIGHT, 5);
	public void testTruncate() {
		assertTrue(truncator.truncate(holder, "abcdef").equals("abcde"));
	}
	public void testNoTruncate() {
		assertTrue(truncator.truncate(holder, "abcde").equals("abcde"));
		assertTrue(truncator.truncate(holder, "abcd").equals("abcd"));
	}

}
