package uk.ac.aber.cs211.wordladder.tests;


import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Word;
import uk.ac.aber.cs211.wordladder.WordGraph;

import junit.framework.TestCase;

public class WordGraphTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testAdd() {
		WordGraph words = new WordGraph();
		words.add("foo");
		Word word = words.get("foo");
		assertEquals(word.getString(), "foo");
	}

	@Test
	public void testLoadTextFile() throws IOException {
		
		System.out.println("Current working directory: "+new File(".").getCanonicalPath() );
		
		WordGraph words = new WordGraph();
		words.loadTextFile("data/wordlist_test.txt");
		System.out.println(words.toString());
	}

}
