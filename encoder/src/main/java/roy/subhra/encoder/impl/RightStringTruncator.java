package roy.subhra.encoder.impl;

public class RightStringTruncator implements Truncator {
	/**
	 * Truncates String from Right
	 */
	public String truncate(TruncationStyleHolder style, Object data) {
		String convertedData = (String) data;
		if(style.getMaxElementWidth() > -1 &&  convertedData.length() > style.getMaxElementWidth() ){
			convertedData = convertedData.substring(0,style.getMaxElementWidth());
		}
		return convertedData;
	}

}
