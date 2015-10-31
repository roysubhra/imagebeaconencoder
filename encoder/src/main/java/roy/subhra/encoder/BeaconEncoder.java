package roy.subhra.encoder;

import java.util.SortedMap;

public interface BeaconEncoder {
	enum TruncationStyle {
		INTEGER, STRING_LEFT, STRING_RIGHT
	}
	/**
	 * Adds a truncation rule for a field 
	 * @param fieldName
	 * @param style
	 * @param maxWidth
	 */
	void addFieldTruncationRule(String fieldName, TruncationStyle style, int maxWidth);
	/**
	 * Adds a Truncation rule for an Array
	 * @param fieldName
	 * @param maxArrayWidth
	 * @param elemStyle
	 * @param maxElemWidth
	 */
	void addArrayTruncationRule(String fieldName, int maxArrayWidth, TruncationStyle elemStyle, int maxElemWidth);
	/**
	 * Encode the Fields
	 * @param data
	 * @return encoded String
	 */
	String encode(SortedMap<String, Object> data);
}
