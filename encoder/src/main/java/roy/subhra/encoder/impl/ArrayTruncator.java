package roy.subhra.encoder.impl;

public class ArrayTruncator implements Truncator {

	private static final String COMMA = ",";
	private static final String END_BRACKET = "]";
	private static final String START_BRACKET = "[";

	/**
	 * Handle Arrays
	 */
	public String truncate(TruncationStyleHolder style, Object data) {
		Object[] arr = (Object[]) data;
		StringBuilder sb = new StringBuilder(START_BRACKET);
		TruncationStyleHolder localStyle = new TruncationStyleHolder(style.getStyle(), style.getMaxElementWidth());
		Truncator localTruncator = TruncatorFactory.getTruncator(localStyle);
		boolean commaNeeded = false;
		boolean close = true; 
		for(Object val : arr){
			String truncatedVal = localTruncator.truncate(localStyle, val);
			if(sb.length()+truncatedVal.length()+ (commaNeeded?2:1) > style.getMaxArrayWidth()){ //adding the new value and closing
				sb.append(END_BRACKET);
				close = false;
				break;
			}else{
				if(commaNeeded){
					sb.append(COMMA);
				}
				sb.append(truncatedVal);
				commaNeeded =true;
			}
		}
		if(close){
			sb.append(END_BRACKET);
		}
		return sb.toString();
	}

}
