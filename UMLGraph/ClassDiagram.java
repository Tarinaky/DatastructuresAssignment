/**
 * 
 * @opt hide
 *
 */
class String {}

class Word {
	private String string;
	private enum Similarity {EQUAL, SIMILAR, DIFFERENT}
	public Word(String string) {}
	public String getString() {}
	public boolean isSimilar(String other) { return false; }
	public boolean isSimilar(Word other) { return false; }
	
}

