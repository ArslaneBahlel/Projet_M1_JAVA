package anonymization;
@FunctionalInterface
public interface AnonymizationStrategy {

	/**
	 * Anonymization function
	 * @param toAnonymize : value to anonymize
	 * @return toAnonymize anonymized
	 */
	public String anonymize(String toAnonymize);
}
