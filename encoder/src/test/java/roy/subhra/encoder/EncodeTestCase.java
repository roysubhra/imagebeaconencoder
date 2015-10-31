package roy.subhra.encoder;

import java.util.SortedMap;
import java.util.TreeMap;

import junit.framework.TestCase;
import roy.subhra.encoder.impl.BeaconEncoderImpl;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
public class EncodeTestCase extends TestCase {

	
	@Override
	protected void setUp() throws Exception {
		encoder.addFieldTruncationRule("left2", TruncationStyle.STRING_LEFT, 2);
		encoder.addFieldTruncationRule("left3", TruncationStyle.STRING_LEFT, 3);
		encoder.addFieldTruncationRule("right2", TruncationStyle.STRING_RIGHT, 2);
		encoder.addFieldTruncationRule("right3", TruncationStyle.STRING_RIGHT, 3);
		encoder.addFieldTruncationRule("int2", TruncationStyle.INTEGER, 2);
		encoder.addFieldTruncationRule("int3", TruncationStyle.INTEGER, 3);
		encoder.addArrayTruncationRule("array1", 10, TruncationStyle.STRING_RIGHT, 3);
	}
	BeaconEncoder encoder =  new BeaconEncoderImpl();
	public void testEncode() {
		SortedMap<String, Object> data = new TreeMap<String, Object>() {{
			put("array1", new String[] { "ABC", "EF", "IJ" });
			put("int2", 100);
			put("int3", 100);
			put("left2", "ABC");
			put("left3", "ABC");
			put("right2", "ABC");
			put("right3", "ABC");
			put("ignored", "1234");
			}};
			assertTrue(encoder.encode(data).equals("array1=[ABC,EF]&int2=99&int3=100&left2=BC&left3=ABC&right2=AB&right3=ABC"));
	}

}
