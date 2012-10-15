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

}
