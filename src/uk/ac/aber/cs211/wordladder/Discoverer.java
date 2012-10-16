package uk.ac.aber.cs211.wordladder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Discoverer {

	private WordGraph words;
	private Word start, goal, cursor;
	private Queue<Stack<Word> > frontier;
	private Stack<Word> visited;
	
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
		frontier = new LinkedList<Stack<Word> >();
		frontier.offer(new Stack<Word>() );
		frontier.peek().add(start);
		
		this.visited = new Stack<Word>();
		
		return this;
		
		
	}
	
	public Discoverer setGoal(String string) {
		this.goal = words.get(string);
		if (goal == null) {
			words.add(string);
			goal = words.get(string);
		}

		return this;
		
	}
	
	public List<Word> run() {
		while (!frontier.isEmpty() ) {
			Stack<Word> solution = frontier.poll();
			
			//System.out.println(solution);
			
			Word cursor = solution.get(solution.size()-1);
			
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
				Stack<Word> expand = (Stack<Word>) solution.clone();
				expand.add(next);
				frontier.offer(expand);
				
				
			}
			
			
		}
		return null;
	}
}
