package roy.subhra.encoder;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import roy.subhra.encoder.impl.ArrayTruncator;
import roy.subhra.encoder.impl.IntTruncator;
import roy.subhra.encoder.impl.LeftStringTruncator;
import roy.subhra.encoder.impl.RightStringTruncator;
import roy.subhra.encoder.impl.TruncationStyleHolder;
import roy.subhra.encoder.impl.Truncator;
import roy.subhra.encoder.impl.TruncatorFactory;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;

public class TruncatorFactoryTestCase {

	@Test
	public void testGetTruncator() {
		TruncationStyleHolder holder = new TruncationStyleHolder( TruncationStyle.INTEGER, 0);
		Truncator truncator = TruncatorFactory.getTruncator(holder);
		assertTrue(truncator instanceof IntTruncator);
		holder = new TruncationStyleHolder( TruncationStyle.STRING_LEFT, 0);
		truncator = TruncatorFactory.getTruncator(holder);
		assertTrue(truncator instanceof LeftStringTruncator);
		holder = new TruncationStyleHolder( TruncationStyle.STRING_RIGHT, 0);
		truncator = TruncatorFactory.getTruncator(holder);
		assertTrue(truncator instanceof RightStringTruncator);
		holder = new TruncationStyleHolder( TruncationStyle.STRING_RIGHT, 0, 2);
		truncator = TruncatorFactory.getTruncator(holder);
		assertTrue(truncator instanceof ArrayTruncator);
	}

}
