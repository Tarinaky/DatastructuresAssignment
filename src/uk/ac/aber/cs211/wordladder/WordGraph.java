/**
 * 
 */
package uk.ac.aber.cs211.wordladder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

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
	
	public String toString() {
		final int MAXLENGTH = 3;
		StringBuffer builder = new StringBuffer();
		int i = 0;
		for (Word word: words.values() ) {
			if (i++ >= MAXLENGTH) { break; }
			builder.append(word+" ");
		}
		if (i >= MAXLENGTH) { builder.append("... ["+(words.size()-MAXLENGTH)+" others]"); }
		
		return builder.toString();
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
	
	/**
	 * Adds a list of words to the dictionary from a text file and generates the Graph of word similarity.
	 * This generation step is O(n^2) in time so using a 'cached' format is preferred.
	 * 
	 * The text file must be UTF8 and formated with one word per line, any combination of CR/LF may be used
	 * to denote a new line. Whitespace will be stripped. Empty lines will be ignored.
	 * @param path The path to the text file to be used.
	 * @throws IOException 
	 */
	public void loadTextFile(String path) throws IOException {
		BufferedReader input = new BufferedReader(new java.io.FileReader(path)); 
		String line;
		while (input.ready() ) {
			line = input.readLine();
			StringBuffer word = new StringBuffer();
			for (int i = 0; i<line.length(); ++i) {
				char c = line.charAt(i);
				if (Character.isWhitespace(c)) { continue; }//Do nothing.
				word.append(c);				
			}
			if (word.length() < 1) { continue; }//Do nothing.
			add(word.toString() );
			
		}
		input.close();
	}
	

}
