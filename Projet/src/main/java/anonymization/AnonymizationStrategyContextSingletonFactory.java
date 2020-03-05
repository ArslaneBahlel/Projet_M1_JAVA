package anonymization;

import java.util.HashMap;

public class AnonymizationStrategyContextSingletonFactory {

	private static HashMap<String, AnonymizationStrategy> anonymization_rules = new HashMap<>();

	/**
	 * Private constructor because it is a Singleton and a Factory
	 */
	private AnonymizationStrategyContextSingletonFactory() {}

	/**
	 * The Factory Method / Singleton Pattern
	 * @param verification : string used to tell which Verify Strategy to return 
	 * @return the suitable verification strategy
	 */
	public static AnonymizationStrategy getInstance(String anonymize) {
		if (anonymization_rules.get(anonymize.toLowerCase()) == null) {
			AnonymizationStrategy strategy = null ;
			if (anonymize.equalsIgnoreCase("RANDOM_LETTER")) {
				strategy = new AnonymizationRandomLetter();
				anonymization_rules.put("RANDOM_LETTER", strategy);
			}else if (anonymize.equalsIgnoreCase("RANDOM_LETTER_FOR_LOCAL_PART")) {
				strategy = new AnonymizationRandomLetterLocalPart();
				anonymization_rules.put("RANDOM_LETTER_FOR_LOCAL_PART", strategy);
			}
		}
		return anonymization_rules.get(anonymize);
	}
}
