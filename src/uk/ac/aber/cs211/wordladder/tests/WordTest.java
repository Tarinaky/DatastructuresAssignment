/**
 * 
 */
package uk.ac.aber.cs211.wordladder.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Word;

import junit.framework.TestCase;

/**
 * @author Jacob Smith, jas32
 *
 */
public class WordTest extends TestCase {
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link uk.ac.aber.cs211.wordladder.Word#getString()}.
	 */
	@Test
	public void testGetString() {
		Word word = new Word("foo");
		assertEquals(word.getString(), "foo");
	}

	/**
	 * Test method for {@link uk.ac.aber.cs211.wordladder.Word#isSimilar(java.lang.String)}.
	 */
	@Test
	public void testIsSimilar() {
		Word flash = new Word("flash");
		Word clash = new Word("clash");
		Word clock = new Word("clock");
		
		assertTrue(flash.isSimilar(clash));
		assertFalse(flash.isSimilar(flash));
		assertFalse(flash.isSimilar(clock));
	}
	
	

}
