/**
 * 
 * @opt hide
 *
 */
class String {}

/**
 * 
 * @assoc * - * Word
 *
 */
class Word {
	private String string;
	private enum Similarity {EQUAL, SIMILAR, DIFFERENT}
	public Word(String string) {}
	public String getString() {}
	public boolean isSimilar(String other) { return false; }
	public boolean isSimilar(Word other) { return false; }
	
	//Implementation of graph edges
	private java.util.ArrayList<Word> edges;
	public void addEdge(Word other) {}
	public void testSimilarityAddEdges(Word other) {}
	
}

/**
 * 
 * @composed 1 - * Word
 *
 */
class WordGraph {
	private java.util.HashMap<String,Word> words;
	
	public void add(String word) {}
	public Word get(String word) {}
	
	//Load from text file.
	public void loadTextFile(String path) {}
	
}