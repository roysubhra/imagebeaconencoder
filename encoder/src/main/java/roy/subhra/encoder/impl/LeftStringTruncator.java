package roy.subhra.encoder.impl;

public class LeftStringTruncator implements Truncator {
	/**
	 * Truncates String from Left
	 */
	public String truncate(TruncationStyleHolder style, Object data) {
		String convertedData = (String) data;
		if(style.getMaxElementWidth() > -1 && convertedData.length() > style.getMaxElementWidth()){
			convertedData = convertedData.substring(convertedData.length()-style.getMaxElementWidth());
		}
		return convertedData;
	}
}
