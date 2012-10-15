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
	private java.util.List<Word> edges;
	public void addEdge(Word other) {}
	public void testSimilarityAddEdges(Word other) {}
	
}

/**
 * 
 * @composed 1 - * Word
 *
 */
class WordGraph {
	private java.util.HashMap words;
	
	public void add(String string) {}
}