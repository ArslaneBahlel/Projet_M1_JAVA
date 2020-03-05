package anonymization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import anonymization.AnonymizationRandomLetter;

class AnonymizationRandomLetterTest {

	@Test
	void testAnonymize() {
		AnonymizationRandomLetter anoLetter1 = new AnonymizationRandomLetter();
		String testString = "yanis";
		String resultString = anoLetter1.anonymize(testString);
		assertFalse(testString.equals(resultString));
		assertTrue(testString.length() == resultString.length());
	}

}
