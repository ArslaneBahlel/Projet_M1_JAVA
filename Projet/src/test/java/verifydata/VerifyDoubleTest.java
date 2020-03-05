package verifydata;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import verifydata.VerifyDouble;

class VerifyDoubleTest {

	private VerifyDouble verify = new VerifyDouble();
	
	@Test
	void testVerifyType() {
		assertTrue(verify.verifyType("12.4"));
		assertFalse(verify.verifyType("12.4yanis"));
		assertTrue(verify.verifyType("12"));
		assertTrue(verify.verifyType("0.000012"));
		assertFalse(verify.verifyType("12......4"));
	}

}
