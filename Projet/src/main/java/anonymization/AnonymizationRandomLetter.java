package anonymization;

import java.util.Random;
public class AnonymizationRandomLetter implements AnonymizationStrategy {

	/**
	 * {@inheritDoc}
	 * Anonymizes a String by replacing each letter by a random letter
	 * @param toAnonymize : value to anonymize
	 * @return toAnonymize anonymized
	 */

	@Override
	public String anonymize(String toAnonymize) {
		Random r = new Random();
		toAnonymize= toAnonymize.chars()
				.map(c -> {
					int rnd = (int) (r.nextInt(52));
				    char base = (rnd < 26) ? 'A' : 'a';
				    return  (char) (base + rnd % 26);
				}).
				collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		 return toAnonymize;
	}

}
