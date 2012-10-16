package uk.ac.aber.cs211.wordladder.tests;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Discoverer;
import uk.ac.aber.cs211.wordladder.Word;

import junit.framework.TestCase;

public class DiscovererTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRun() throws Exception {
		Discoverer discoverer = new Discoverer()
				.setStart("flask")
				.setGoal("clock");
		
		List<Word> solution = discoverer.run();
		
		assertTrue(solution != null);
		System.out.println(solution);
	}

}
