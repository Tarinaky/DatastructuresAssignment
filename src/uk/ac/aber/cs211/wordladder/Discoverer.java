package uk.ac.aber.cs211.wordladder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * Produces the shortest word ladder possible for a given start and end string of the same length.
 * @author Jacob Smith, jas32
 */
public class Discoverer {

	private WordGraph words;
	private Word start, goal, cursor;
	private Queue<ArrayList<Word> > frontier;
	private ArrayList<Word> visited;
	
	/**
	 * Also loads the dictionary according to the length of the start word.
	 * @param string The word to start the word ladder with.
	 * @return The Discoverer under construction.
	 * @throws IOException If the WordGraph is unable to load its dictionary.
	 */
	public Discoverer setStart(String string) throws IOException {
		int length = string.length();
		
		words = new WordGraph();
		words.loadTextFile("data/wordlist_"+length+".txt");
		
		Word word = words.get(string);
		if (word == null) {
			words.add(string);
			word = words.get(string);
		}
			
		
		this.start = word;
		frontier = new LinkedList<ArrayList<Word> >();
		frontier.offer(new ArrayList<Word>() );
		frontier.peek().add(start);
		
		this.visited = new ArrayList<Word>();
		visited.add(start);
		
		return this;
		
		
	}
	
	/**
	 * 
	 * @param string Sets the word the word ladder must end with.
	 * @return The Discoverer under construction.
	 */
	public Discoverer setGoal(String string) {
		this.goal = words.get(string);
		if (goal == null) {
			words.add(string);
			goal = words.get(string);
		}

		return this;
		
	}
	
	/**
	 * 
	 * @return The shortest word-ladder possible, or null if no ladder can be found.
	 */
	public List<Word> run() {
		while (!frontier.isEmpty() ) {
			ArrayList<Word> solution = frontier.poll();
			
			//System.out.println(solution);
			
			cursor = solution.get(solution.size()-1);
			
			if (cursor == goal) { //Check if goal is reached.
				return solution;
			}
			
			List<Word> edges = cursor.getEdges();
			for (Word seen: visited) { // Remove visited edges.
				edges.remove(seen);
				//System.out.println(seen);
			}
			
			for (Word next: edges) {
				@SuppressWarnings("unchecked")
				ArrayList<Word> expand = (ArrayList<Word>) solution.clone();
				expand.add(next);
				visited.add(next);
				frontier.offer(expand);
				
				
			}
			
			
		}
		return null;
	}
}
