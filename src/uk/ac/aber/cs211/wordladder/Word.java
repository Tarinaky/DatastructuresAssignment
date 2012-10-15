/**
 * 
 */
package uk.ac.aber.cs211.wordladder;

/**
 * @author Jacob Smith, jas32
 *
 * Encapsulates a single word as well as links to 'similar' words.
 */
public class Word {

	/**
	 * Internal representation of this particular word as a string of characters.
	 */
	private String string;
	private java.util.List<Word> edges;
	
	/**
	 * @param string The string (no precceding/trailing spaces) containing 
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
	
	/**
	 * Marks a particular word as being 'similar' to this one. This method must be called
	 * on both Word objects to make the relationship reciprocal.
	 * @param other The similar word.
	 */
	public void addEdge(Word other) {
		edges.add(other);
	}
	
	/**
	 * Iff this Word and other are similar a reciprocal relationship is added marking both
	 * as similar to each other. Otherwise no action is taken.
	 * @param other The word to test against this one.
	 */
	public void testSimilarityAddEdges (Word other) {
		if (isSimilar(other)) {
			this.addEdge(other);
			other.addEdge(this);
		}
	}
	
}
