package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import main.java.NameFinder;

class NameFinderTest {
	private final String resultName = "";

	@Test
	void testNameFinder() {
		String result = null;
		try {
			String[] text = new String[] { "John", "Smith", "is", "standing", "next", "to", "bus", "stop", "and",
					"waiting", "for", "Mike", "." };
			NameFinder nF = new NameFinder();
			result = nF.nameFinder(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expResult = "-------Finding entities belonging to category : person name------\n"
				+ "[0..2) person  :  John Smith \n" + "[11..12) person  :  Mike \n" + "";

		assertEquals(result, expResult);
	}
	
	@Test
	void testNameFinderOL() {
		String info = "There was little surprise at the No 1 overall pick in Thursday night’s event in Cleveland. The Jacksonville Jaguars selected Clemson quarterback Trevor Lawrence considered one of the best college prospects in decades. Similarly, BYU quarterback Zach Wilson had long"
				+ "     been predicted as the second overall pick for the New York Jets, and those predictions came true.";
		String[] text = info.split("[ \t]+");
		NameFinder n;
		String res = null;
		String expRes= "[Clemson, Lawrence, Trevor, Wilson, Zach]";
		try {
			n = new NameFinder();
			res = n.nameFinderOL(text,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expRes,res);
				
	}

	@Test
	void testOrgFinder() {
		String result = null;
		String expResult = "-------Finding entities belonging to category : organization name------\n"
				+ "[10..11) organization  :  CIA" + " \n";
		String[] sentence = new String[] { "One", "of", "the", "most", "powerful", "organizations","in", "the", "world", "is",
				"CIA", "which", "is","from", "USA","not","from","FR","(france)", "." };
		try {
			NameFinder nF = new NameFinder();
			result = nF.orgFinder(sentence);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expResult, result);
	}

	@Test
	void testDateFinder() {
		String result = null;
		String expResult = "-------Finding entities belonging to category : date------\n" + "[4..5) date  :  1999"
				+ " \n";
		String[] sentence = new String[] { "He", "was", "born", "on", "1999", "on", "Atlanta", "surrounded", "by",
				"445", "pidgeons", "." };
		try {
			NameFinder nF = new NameFinder();
			result = nF.dateFinder(sentence);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expResult, result);
	}

	@Test
	void testLocationFinder() {
		String result = null;
		String expResult = "-------Finding entities belonging to category : place name------\n"
				+ "[4..5) location  :  Atlanta" + " \n";
		String[] sentence = new String[] { "John", "Smith", "is", "from", "Atlanta", "." };
		try {
			NameFinder nF = new NameFinder();
			result = nF.locationFinder(sentence);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expResult, result);
	}
	
	

}
