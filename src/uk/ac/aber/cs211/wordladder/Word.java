/**
 * 
 */
package uk.ac.aber.cs211.wordladder;

/**
 * @author Jacob Smith, jas32
 *
 * Encapsulates a single word. This class should generally be considered immutable, 
 * only its constructor may build it. 
 */
public class Word {

	private String string;
	
	/**
	 * @param string The string (no preceeding/trailing spaces) containing 
	 * the word to represent.
	 */
	public Word(String string) {
		this.string = string;
	}
	
	/**
	 * 
	 * @return The string object defining this word.
	 */
	public String getString() { return this.string; }
	
	public String toString() { return getString(); }
	
	/**
	 * 
	 * @author Jacob Smith, jas32
	 * EQUAL indicates that two words are identical. 
	 * SIMILAR indicates that two words (of presumed equal length) have only 
	 * a single difference (e.g. clash and flash).
	 * DIFFERENT indicates that two words have more than a single difference.
	 *
	 */
	private enum Similarity { EQUAL, SIMILAR, DIFFERENT }
	
	/**
	 * 
	 * @param other The second word to compare.
	 * @return True iff the two Words are separated by only a single character change.
	 */
	public boolean isSimilar(String other) {
		int length = string.length();
		
		Similarity similar = Similarity.EQUAL;
		
		for (int i = 0; i < length; i++) {
			if (string.charAt(i) == other.charAt(i) ) {
				continue;
			} else if ( similar == Similarity.SIMILAR ) {
				return false; // Two misses have occurred.
			} else {
				similar = Similarity.SIMILAR; // The first miss occurred. 
			}
		}
		if (similar == Similarity.SIMILAR) {
			return true; // Exactly one hit occurred.
		} else {
			return false; // No misses occurred - the words are equal.
		}
	}
	/**
	 * @see isSimilar(String)
	 * @param other The second word to compare.
	 * @return True iff the two words are seperated by only a single character change.
	 */
	public boolean isSimilar(Word other) {
		return isSimilar(other.getString() );
	}
	
}
