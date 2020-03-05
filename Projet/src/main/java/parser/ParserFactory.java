package parser;

public class ParserFactory {

	/**
	 * ParserFactory cannot be instantiated
	 */
	private ParserFactory() {}
	
	/**
	 * 
	 * @param filePath : file path of the file to parse, not null
	 * @return FileParser : the right FileParser
	 */
	public static FileParser createParser(String filePath) {
		if (filePath.substring(filePath.lastIndexOf('.') + 1).equalsIgnoreCase("CSV"))
			return new CsvParser(filePath);
		else if (filePath.substring(filePath.lastIndexOf('.') + 1).equalsIgnoreCase("json"))
			return new JsonParser(filePath);
		return null;
	}
}
