/**
 * 
 */
package uk.ac.aber.cs211.wordladder;

/**
 * @author Jacob Smith, jas32
 *
 * The WordGraph is used to build the network of word similarity. It can then also be used to get a vector
 * into a particular part of the graph.
 */
public class WordGraph {

	private java.util.HashMap<String,Word> words;
	/**
	 * Default constructor.
	 */
	public WordGraph() {
		words = new java.util.HashMap<String,Word>(); 
	}
	
	/**
	 * 
	 * @param word Word to be added to the Graph.
	 */
	public void add(String word) {
		if (words.containsKey(word)) {
			return;//Do nothing.
		}
		Word node = new Word(word);
		
		for (Word other: words.values() ) {
			node.testSimilarityAddEdges(other);//Build the edges.
		}
		
		words.put(word, node);//Add to dictionary.
				
		
	}

	/**
	 * Provides a vector into the graph.
	 * @param word The String to look up in the dictionary.
	 * @return The corresponding Word object.
	 */
	public Word get(String word) {
		return words.get(word);
	}
}
