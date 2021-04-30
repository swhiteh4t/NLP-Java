package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import main.java.PasswordChecker;

class PasswordCheckerTest {

	@Test
	void test() {
		//Create new config file
		boolean res = false;
		try {
			PasswordChecker pC = new PasswordChecker();
			pC.setPassword("invalidpass");
			pC.setPassword("Valid,Password");
			res = pC.checkPassword("Valid,Password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(res,true);
	}

}
