package roy.subhra.encoder.impl;

import roy.subhra.encoder.BeaconEncoder.TruncationStyle;
/**
 * holder class to hold the truncation rule
 * @author Subhra
 */
public class TruncationStyleHolder {
	private TruncationStyle style;
	private int maxElementWidth = -1 ;//default means no truncation 
	private int maxArrayWidth =  -1; //default means not truncation, when present denotes array
	
	public TruncationStyleHolder(TruncationStyle style, int maxWidth){
		this.style = style;
		this.maxElementWidth = maxWidth;
	}
	public TruncationStyleHolder(TruncationStyle style, int maxWidth, int maxArrayWidth){
		this(style, maxWidth);
		this.maxArrayWidth = maxArrayWidth;
	}
	public TruncationStyle getStyle() {
		return style;
	}
	
	public int getMaxArrayWidth() {
		return maxArrayWidth;
	}
	
	public int getMaxElementWidth() {
		return maxElementWidth;
	}
	
	public boolean isArrayStyle(){
		return maxArrayWidth != -1;
	}
}
