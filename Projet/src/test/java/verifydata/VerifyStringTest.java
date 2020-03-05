package verifydata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerifyStringTest {

	private VerifyString verify = new VerifyString();
	
	@Test
	void testVerifyType() {
		assertFalse(verify.verifyType("12.4"));
		assertFalse(verify.verifyType("12"));
		assertTrue(verify.verifyType("yanis"));
		assertTrue(verify.verifyType("12maan"));
		assertTrue(verify.verifyType("system.out"));
	}
}
