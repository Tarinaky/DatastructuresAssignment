/**
 * 
 * @opt hide
 *
 */
class String {}

/**
 * @opt hide
 */
class Stack<Word> {}
/**
 * @opt hide
 */
class Queue<Word> {}

/**
 * @opt hide
 */
class IOException {}

/**
 * @opt hide
 */
class List<Word> {}
/**
 * @opt hide
 */
class Random {}

class Word {
	public Word() {}
	
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
	
	public WordGraph() {}
	
	public void add(String word) {}
	public Word get(String word) {}
	
	//Load from text file.
	public void loadTextFile(String path) {}
	
}

/**
 * @composed 1 - 1 WordGraph
 */
class Discoverer {
	private WordGraph words;
	private Word start,goal,cursor;
	private Queue<Stack<Word> > frontier;
	private Stack<Word> visited;
	
	public Discoverer() {}
	public Discoverer setStart(String string) throws IOException {}
	public Discoverer setGoal(String string) {}
	
	public List<Word> run() {}
}

/**
 * @composed 1 - 1 WordGraph
 */
class Generator {
	private WordGraph words;
	private Random random;
	private int depth;
	private int wordLength;
	private Word start;
	
	public Generator() {}
	public Generator setStart(String string) {}
	public Generator setDepth(int depth) {}
	public List<String> run() {}
}
