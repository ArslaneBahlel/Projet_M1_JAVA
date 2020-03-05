package verifydata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import verifydata.VerifyBeAnDauphineEmail;

class VerifyBeAnDauphineEmailTest {

	private VerifyBeAnDauphineEmail verify = new VerifyBeAnDauphineEmail();
	
	@Test
	void testVerifyType() {
		assertFalse(verify.verifyType("yanis@gmail.com"));
		assertTrue(verify.verifyType("yanis@dauphine.eu"));
	}

}
