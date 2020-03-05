package verifydata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import verifydata.VerifyBeAnEmail;

class VerifyBeAnEmailTest {

	private VerifyBeAnEmail verify = new VerifyBeAnEmail();
	
	@Test
	void testVerifyType() {
		assertTrue(verify.verifyType("yanis@abouch.com"));
		assertFalse(verify.verifyType("yanis#gmail.com"));
	}

}
