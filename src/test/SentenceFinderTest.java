package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import main.java.SentenceFinder;

class SentenceFinderTest {

	@Test
	void test() throws FileNotFoundException {
		SentenceFinder st = new SentenceFinder();
		String paragraph = "This is a statement. This is an email: bob@dot.domain.edu.pl. This is another statement. Now is an abstract word for time, that is always flying.";
		String result = null;
		String expResult = "0 -> This is a statement.\n"
				+ "1 -> This is an email: bob@dot.domain.edu.pl.\n"
				+ "2 -> This is another statement.\n"
				+ "3 -> Now is an abstract word for time, that is always flying.\n";
		try {
			result = st.sentenceDetect(paragraph);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expResult,result);
		
	}

}
