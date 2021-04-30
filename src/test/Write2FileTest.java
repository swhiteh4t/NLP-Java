package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import main.java.Write2File;

class Write2FileTest {

	@Test
	void test() {
		Write2File w = new Write2File();
		w.writeResult("This is a test");
		assertEquals(new File(System.getProperty("user.home") + "/Desktop/result.txt").exists(),true);
		
		
	}

}
