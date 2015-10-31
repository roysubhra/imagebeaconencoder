package roy.subhra.encoder.impl;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import roy.subhra.encoder.BeaconEncoder;

public class BeaconEncoderImpl implements BeaconEncoder {

	private static final String AMPERSAND = "&";
	private static final String EQUAL = "=";
	
	
	private SortedMap<String,TruncationStyleHolder> truncationRules = new TreeMap<String,TruncationStyleHolder>();
	/**
	 * {@inheritDoc}
	 */
	public void addFieldTruncationRule(String fieldName, TruncationStyle style, int maxWidth) {
		truncationRules.put(fieldName,new TruncationStyleHolder(style, maxWidth));
	}
	/**
	 * {@inheritDoc}
	 */
	public void addArrayTruncationRule(String fieldName, int maxArrayWidth, TruncationStyle elemStyle,
			int maxElemWidth) {
		truncationRules.put(fieldName,new TruncationStyleHolder(elemStyle, maxElemWidth,maxArrayWidth));
	}
	/**
	 * {@inheritDoc}
	 */
	public String encode(SortedMap<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		boolean ampersandNeeded = false;
		for(Entry<String,TruncationStyleHolder> rule : truncationRules.entrySet()) {
			String portion = TruncatorFactory.getTruncator(rule.getValue()).truncate(rule.getValue(),data.get(rule.getKey()));
			if(ampersandNeeded){				
				sb.append(AMPERSAND);
			}
			sb.append(rule.getKey()).append(EQUAL).append(portion);
			ampersandNeeded = true;
		}//end for
		return sb.toString();
	}
		
}
