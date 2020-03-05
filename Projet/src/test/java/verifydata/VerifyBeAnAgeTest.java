package verifydata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import verifydata.VerifyBeAnAge;

class VerifyBeAnAgeTest {

	private VerifyBeAnAge verify = new VerifyBeAnAge();
	
	@Test
	void testVerifyType() {
		assertTrue(verify.verifyType("22"));
		assertFalse(verify.verifyType("yanis"));
	}

}
