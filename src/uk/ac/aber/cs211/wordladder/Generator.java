package uk.ac.aber.cs211.wordladder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Generator {
	
	private WordGraph words;
	private Random random;
	int depth = 5;
	int wordLength;
	Word start;

	public Generator() {
		words = new WordGraph();
		random = new Random();
	}
	
	public Generator setStart(String string) {
		wordLength = string.length();
		
		try {
			words.loadTextFile("data/wordlist_"+wordLength+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		start = words.get(string);
		if (start == null) {
			words.add(string);
			start = words.get(string);
		}
		return this;
		
	}
	
	public Generator setDepth(int depth) { 
		this.depth = depth; 
		return this; 
	}
	
	public List<String> run() {
		Stack<Word> visitedNodes = new java.util.Stack<Word>();
		Word cursor = start;
		visitedNodes.push(cursor);
		
		for (int i = 1; i < depth && i >= 1; ++i) {
			List<Word> edges = cursor.getEdges();
			for (Word word: visitedNodes) {
				edges.remove(word); // Prune visited nodes from the list of valid edges.
			}
			
			if (edges.size() < 1) {
				//Backtrack!
				i -= 2;
				cursor = visitedNodes.pop();
				
			} else {			
				cursor = edges.get(random.nextInt(edges.size() ) );
				visitedNodes.push(cursor);
			
			}
		}	
		if (visitedNodes.size() >= depth) {
			List<String> returnList = new ArrayList<String>(depth);
			for (Word word: visitedNodes) {
				returnList.add(word.getString());
			}
			return returnList;
		}
		
		return null;//No path possible.
		

	}
}
