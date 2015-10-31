package roy.subhra.encoder;

import junit.framework.TestCase;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
import roy.subhra.encoder.impl.LeftStringTruncator;
import roy.subhra.encoder.impl.TruncationStyleHolder;
import roy.subhra.encoder.impl.Truncator;

public class LeftStringTruncatorTestCase extends TestCase {

	Truncator truncator = new LeftStringTruncator();
	TruncationStyleHolder holder = new TruncationStyleHolder(TruncationStyle.STRING_LEFT, 5);
	public void testTruncate() {
		assertTrue(truncator.truncate(holder, "abcdef").equals("bcdef"));
	}
	public void testNoTruncate() {
		assertTrue(truncator.truncate(holder, "abcde").equals("abcde"));
		assertTrue(truncator.truncate(holder, "abcd").equals("abcd"));
	}
}
