package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oblig3.mengde.TabellMengde;

public class TabellMengdeTest {
	
	private TabellMengde<Integer> mengde1;
	private TabellMengde<Integer> mengde2;
	
	@BeforeEach
	public void setup() {
		mengde1 = new TabellMengde<Integer>(10);
		mengde2 = new TabellMengde<>(10);
	}
	
	@Test
	public void testErTom() {
		
		assertTrue(mengde1.erTom());
		assertTrue(mengde2.erTom());
	}
}
