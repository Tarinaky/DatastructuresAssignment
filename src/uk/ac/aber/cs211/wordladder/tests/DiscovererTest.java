package uk.ac.aber.cs211.wordladder.tests;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.cs211.wordladder.Discoverer;
import uk.ac.aber.cs211.wordladder.Word;

import junit.framework.TestCase;

public class DiscovererTest extends TestCase {

	private Discoverer fixture;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		fixture = new Discoverer();
	
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRunFlashClock() throws Exception {
		fixture.setStart("flash").setGoal("clock");
		List<Word> solution = fixture.run();
		
		assertTrue(solution != null);
		System.out.println(solution);
	}
		
		
	public void testRunHeadFoot() throws Exception {
		fixture.setStart("head").setGoal("foot");
		List<Word> solution = fixture.run();
			
		assertTrue(solution != null);
		System.out.println(solution);
			
	}
	
	public void testRunSpiderWriter() throws Exception {
		fixture.setStart("spider").setGoal("writer");
		List<Word> solution = fixture.run();
		
		assertTrue(solution != null);
		System.out.println(solution);
	}

}
