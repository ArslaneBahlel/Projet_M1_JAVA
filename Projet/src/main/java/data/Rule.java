package data;

import java.util.List;

public class Rule extends Data{
	private List<String> should;

	/**
	 * Rule constructor
	 * @param name
	 * @param should
	 */
	public Rule(String name, List<String> should) {
		super(name);
		this.should = should;
	}
	
	/**
	 * Column rules getter
	 * @return this should
	 */
	public List<String> getRules() {
		return should;
	}

	@Override
	public String toString() {
		return name+";"+should;
	}
}
