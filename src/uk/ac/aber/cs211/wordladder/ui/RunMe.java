package uk.ac.aber.cs211.wordladder.ui;

import java.io.IOException;
import java.util.List;

import uk.ac.aber.cs211.wordladder.Discoverer;
import uk.ac.aber.cs211.wordladder.Generator;
import uk.ac.aber.cs211.wordladder.Word;

public class RunMe {

	public RunMe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			printHelp();
			System.exit(-1);
		}
		
		String mode = args[0];
		if (mode.equals("discover") ) {
			discover(args);
		}
		if (mode.equals("generate") ) {
			generate(args);
		}
		printHelp();
		System.exit(-1);
		
	}
	
	public static void generate(String[] args) {
		String startWord = null;
		int depth = 0;
		
		try {
			startWord = args[1];
			depth = Integer.parseInt(args[2]);
		} catch (NullPointerException e) {
			if (args.length < 3) {
				System.err.println("Insufficient arguments.");
				printHelp();
				System.exit(-1);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
		Generator generator = null;
		try {
			generator = new Generator()
				.setStart(startWord)
				.setDepth(depth);
		} catch (IOException e) {
			System.err.println("Could not load dictionaries. Check current working directory.");
			System.exit(-1);
		}
		
		List<String> solution = generator.run();
		if (solution == null) {
			System.err.println("A ladder of that depth is not possible.");
			System.exit(-1);
		}
		System.out.println(solution);
		System.exit(0);
	}
		

	public static void discover(String[] args) {
		String startWord = null, endWord = null;
		
		try {
			startWord = args[1];
			endWord = args[2];
		} catch (NullPointerException e) {
			if (args.length < 3) {
				System.err.println("Insufficient arguments.");
				printHelp();
				System.exit(-1);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
		if (startWord.length() != endWord.length() ) {
			System.err.println("The words must be of equal lengths.");
			System.exit(-1);
		}
		
		Discoverer discoverer = null;
		try {
			discoverer = new Discoverer()
				.setStart(startWord)
				.setGoal(endWord);
		} catch (IOException e) {
			System.err.println("Could not load dictionaries. Check current working directory.");
			System.exit(-1);
		}
		
		List<Word> solution = discoverer.run();
		if (solution == null) {
			System.err.println("No solution exists for "+startWord+"->"+endWord+".");
			System.exit(-1);
		}
		System.out.println(solution);
		System.exit(0);
	}
	
	public static void printHelp() {
		System.err.println("Usage:");
		System.err.println("\tFind a word ladder connecting two words: " +
				"java wordladder.jar discover <start word> <end word>");
		System.err.println("\tProduce a word ladder of length 'depth' from a start word: " +
				"java wordladder.jar generate <start word> <ladder depth>");
		System.err.println("\tPrint this message: " +
				"java wordladder.jar --help");
	}

}
