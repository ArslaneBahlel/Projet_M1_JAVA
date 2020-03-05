package verifydata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerifyIntTest {

	private VerifyInt verify = new VerifyInt();
	
	@Test
	void testVerifyType() {
		assertFalse(verify.verifyType("12.4"));
		assertFalse(verify.verifyType("12yanis"));
		assertTrue(verify.verifyType("12"));
		assertFalse(verify.verifyType("0.000012"));
	}

}
