package roy.subhra.encoder.impl;

public class IntTruncator implements Truncator {

	public String truncate(TruncationStyleHolder style, Object data) {
		int convertedData = (Integer) data;
		if(convertedData < 0 ){
			int minVal = getMinPossibleValueForSize(style.getMaxElementWidth());
			if(convertedData < minVal ){
				convertedData = minVal;
			}
		}else {
			int maxVal = getMaxPossibleValueForSize(style.getMaxElementWidth());
			if(convertedData > maxVal ){
				convertedData = maxVal;
			}
		}
		return Integer.toString(convertedData);
	}

	private int getMaxPossibleValueForSize(int size){
		return (int)Math.pow(10, size)-1;
	}
	private int getMinPossibleValueForSize(int size){
		return (int)(Math.pow(10, size-1)-1)*-1;
	}
	
}
