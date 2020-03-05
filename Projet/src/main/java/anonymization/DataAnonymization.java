package anonymization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import data.Anonymizer;

public class DataAnonymization {
	private List<HashMap<String, String>> file;
	private List<Anonymizer> anonymizers;

	/**
	 * Data Anonymization Constructor
	 * @param file : File content in a List of HashMap
	 */
	public DataAnonymization(List<HashMap<String, String>> file) {
		this.file = file;
	}

	/**
	 * Anonymizations rules setter
	 * @param anonymizers : Anonymization Rules in a List of Anonymizers
	 */
	public void setAnonymizers(List<Anonymizer> anonymizers) {
		this.anonymizers = anonymizers;
	}

	/**
	 * Returns the Anonymization Rules mapped to the column
	 * @param column : Column name
	 * @return : the Anonymization Rules mapped to the column name
	 */
	private Anonymizer getAnonymizer(String column) {
		return anonymizers.stream().filter(a -> a!=null).filter(a -> a.getName().equalsIgnoreCase(column)).findAny().orElse(null);
	}
	
	/**
	 * Anonymizes Data
	 */
	private void doAnonymization() {
		file = file.stream().map(
				row -> {
					row.entrySet().stream().map(
							e -> {
								if (getAnonymizer(e.getKey())!=null) {
									e.setValue(
											AnonymizationStrategyContextSingletonFactory.getInstance(getAnonymizer(e.getKey()).getAnonymizer()).anonymize(e.getValue())
											);
									
								}
								return e;
								}).collect(HashMap::new, (partial, nextelt) -> partial.put(nextelt.getKey(), nextelt.getValue()), (p1, p2)-> p1.putAll(p2));
				return row;	
				})
					.collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Returns the file content Anonymized
	 * @return : the file content Anonymized
	 */
	public List<HashMap<String, String>> getDataAnonymized(){
		doAnonymization();
		return file;
	}
}
