package roy.subhra.encoder.impl;

public interface Truncator {
	/**
	 * Truncates data as per style
	 * @param style
	 * @param data
	 * @return truncated string
	 */
	String truncate(TruncationStyleHolder style, Object data);
}
