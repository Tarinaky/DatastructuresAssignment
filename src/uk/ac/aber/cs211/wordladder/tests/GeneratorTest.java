package uk.ac.aber.cs211.wordladder.tests;


import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Generator;

import junit.framework.TestCase;

public class GeneratorTest extends TestCase {

	private Generator fixture;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		fixture = new Generator();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRunFlask() throws IOException {
		fixture.setDepth(10).setStart("flask");
		List<String> output = fixture.run();
		assertTrue(output != null);
		System.out.println(output);
	}
	
	public void testRunCash() throws IOException {
		fixture.setDepth(10).setStart("cash");
		List<String> output = fixture.run();
		assertTrue(output != null);
		System.out.println(output);
	}
	
	public void testRunPenny() throws IOException {
		fixture.setDepth(10).setStart("penny");
		List<String> output = fixture.run();
		assertTrue(output != null);
		System.out.println(output);
	}
	
	/**
	 * There are only 26 entries in wordlist_1.txt (all of which are mutually linked)...
	 * So any attempt to walk through 27 entries should fail.
	 * @throws IOException 
	 */
	public void testFail() throws IOException {
		Generator generator = new Generator().setDepth(27).setStart("a");
		List<String> output = generator.run();
		//System.out.println(output);
		assertTrue(output == null);
		
	}

}
