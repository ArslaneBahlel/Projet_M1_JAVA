package anonymization;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import anonymization.AnonymizationRandomLetterLocalPart;

class AnonymizationRandomLetterLocalPartTest {

	@Test
	void testAnonymize() {
		AnonymizationRandomLetterLocalPart anoLetter1 = new AnonymizationRandomLetterLocalPart();
		String testString = "yanis@gmail.com";
		String resultString = anoLetter1.anonymize(testString);
		assertFalse(testString.equals(resultString));
		assertTrue(testString.length() == resultString.length());
	}
	
}
