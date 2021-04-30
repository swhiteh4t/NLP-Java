package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ReaderTest {
	private final String RESULT = "Hello\n"
			+ "Hello\n"
			+ "\n"
			+ "HEllo\n"
			+ "";
	private String DIR = "";
	private final String RESOURCES = "/src/main/resources/test.txt";
	
	@Before
	void checkDir() {
		String dir = System.getProperty("user.dir");
		DIR = dir;
		File f = new File(dir + RESOURCES);
		assertEquals(f.exists(),true);
		System.out.println(DIR);
	}

	@Test
	void testRead() {
		checkDir();
		String content = null;
		try {
			content = Files.readString(Path.of(DIR + RESOURCES));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(RESULT,content);
	}

}
