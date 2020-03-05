package data;

public class Descriptor extends Data{
	private String dataType;
	
	/**
	 * Descriptor constructor
	 * @param name : column name
	 * @param dataType : data description for that column
	 */
	public Descriptor(String name, String dataType) {
		super(name);
		this.dataType = dataType;
	}
	
	/**
	 * Column descriptor getter
	 * @return this dataType
	 */
	public String getDataType() {
		return dataType;
	}
	
	@Override
	public String toString() {
		return name+";"+dataType;
	}
}
