package data;

import java.util.List;

public class Anonymizer extends Data {
	private String changeTo;
	
	/**
	 * Anonymizer constructor
	 * @param name : column name
	 * @param changeTo : anonymization rules for that column
	 */
	public Anonymizer(String name, String changeTo) {
		super(name);
		this.changeTo = changeTo;
	}

	/**
	 * Column anonymization rules getter
	 * @return this changeTo
	 */
	public String getAnonymizer() {
		return changeTo;
	}

	@Override
	public String toString() {
		return name+";"+changeTo;
	}

}
