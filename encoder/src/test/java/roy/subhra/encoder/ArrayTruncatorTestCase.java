package roy.subhra.encoder;

import junit.framework.TestCase;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
import roy.subhra.encoder.impl.ArrayTruncator;
import roy.subhra.encoder.impl.TruncationStyleHolder;
import roy.subhra.encoder.impl.Truncator;

public class ArrayTruncatorTestCase extends TestCase {
	Truncator truncator = new ArrayTruncator();
	TruncationStyleHolder stringLeftHolder = new TruncationStyleHolder(TruncationStyle.STRING_LEFT, 5, 12);
	TruncationStyleHolder stringRightHolder = new TruncationStyleHolder(TruncationStyle.STRING_RIGHT, 5, 12);
	TruncationStyleHolder intHolder = new TruncationStyleHolder(TruncationStyle.INTEGER, 3, 12);
	public void testStringLeftTruncate() {
		String[] data= {"abcd","abcdef","a"};
		assertTrue(truncator.truncate(stringLeftHolder,data).equals("[abcd,bcdef]"));
	}
	public void testStringRightTruncate() {
		String[] data= {"abcd","abcdef","a"};
		assertTrue(truncator.truncate(stringRightHolder,data).equals("[abcd,abcde]"));
	}
	public void testIntTruncate() {
		Integer[] data= {-103,123456,123};
		String res = truncator.truncate(intHolder,data);
		assertTrue(res.equals("[-99,999]"));
	}

}
