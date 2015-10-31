package roy.subhra.encoder.impl;
import roy.subhra.encoder.BeaconEncoder.TruncationStyle;

/**
 * Truncator Factory
 * @author Subhra
 *
 */
public class TruncatorFactory {
	/**
	 * Constructs and returns the correct Truncator for the styleHolder
	 * @param styleHolder
	 * @return
	 */
	public static Truncator getTruncator(TruncationStyleHolder styleHolder){
		if(styleHolder.isArrayStyle()){
			return new ArrayTruncator();
		}else if(styleHolder.getStyle().equals(TruncationStyle.INTEGER)){
			return new IntTruncator();
		}else if(styleHolder.getStyle().equals(TruncationStyle.STRING_LEFT)){
			return new LeftStringTruncator();
		}else{
			return new RightStringTruncator();
		}
	}
}
