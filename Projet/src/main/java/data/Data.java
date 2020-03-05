package data;

public abstract class Data {
	protected String name;
	
	/**
	 * Data constructor
	 * @param name : column name
	 */
	public Data(String name) {
		this.name = name;
	}
	
	/**
	 * Column name Getter
	 * @return name : column name
	 */
	public String getName() {
		return name;
	}
}
