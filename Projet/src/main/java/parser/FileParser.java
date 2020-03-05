package parser;

import java.util.List;

@FunctionalInterface
public interface FileParser {
	
	/**
	 * File parse Method
	 * @return a List with the File content
	 */
	List parse();
	
}
