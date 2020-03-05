package verifydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import data.Descriptor;
import data.Rule;

public class DataVerification {
	private List<HashMap<String, String>> file;
	private List<Descriptor> descriptors;
	private List<Rule> rules;
	
	/**
	 * Data Verification Constructor
	 * @param file : File content in a List of HashMap
	 */
	public DataVerification(List<HashMap<String, String>> file) {
		this.file = file;
	}
	
	/**
	 * Data descriptions setter
	 * @param anonymizers : Data descriptions in a List of Descriptors
	 */
	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
	/**
	 * Data verification rules setter
	 * @param anonymizers : Data verification rules in a List of Rules
	 */
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	
	/**
	 * Tells whether or not the column has a rule
	 * @param column : column name
	 * @return:  whether or not the column has a rule
	 */
	private boolean hasRule(String column) {
		return rules.stream().anyMatch(r -> r.getName().equalsIgnoreCase(column));
	}

	/**
	 * Removes rows that has atleast one column value that doesn't match the Data Descriptions
	 */
	private void verifyDataDescription() {
		file = file.stream().filter(row -> row.entrySet().stream().allMatch(
				e -> VerifyStrategyContextSingletonFactory.getInstance(
						descriptors.stream().filter(
								desc -> desc.getName().equalsIgnoreCase(e.getKey())
								).map(
										desc -> desc.getDataType()
										).findAny().get()
						).verifyType(e.getValue())
				)).collect(Collectors.toCollection(ArrayList::new));
	}
	/**
	 * Removes rows that has atleast one column value that doesn't match the Data Rules
	 */
	private void verifyDataRules() {
		file=file.stream().filter(
				row -> {
					return row.entrySet().stream().allMatch(
							e -> {
								if(hasRule(e.getKey())) {
									return rules.stream().filter(rule -> {
									return rule.getName().equals(e.getKey());
								})
									.allMatch(
											column_rules -> {
												return column_rules.getRules().stream().allMatch( rule ->{
													return VerifyStrategyContextSingletonFactory.getInstance(rule).verifyType(e.getValue());}
													);
											});
								}else{
									return true;
								}
							}
							);
				}
				).collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Verifies Data
	 */
	public List<HashMap<String, String>> getDataVerified(){
		verifyDataDescription();
		verifyDataRules();
		return file;
	}
}
