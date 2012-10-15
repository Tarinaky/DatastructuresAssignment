package uk.ac.aber.cs211.wordladder.tests;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Generator;

import junit.framework.TestCase;

public class GeneratorTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRun() {
		Generator generator = new Generator().setDepth(10).setStart("flask");
		List<String> output = generator.run();
		assertTrue(output != null);
		System.out.println(output);
	}
	
	/**
	 * There are only 26 entries in wordlist_1.txt (all of which are mutually linked)...
	 * So any attempt to walk through 27 entries should fail.
	 */
	public void testFail() {
		Generator generator = new Generator().setDepth(27).setStart("a");
		List<String> output = generator.run();
		System.out.println(output);
		assertTrue(output == null);
		
	}

}
