package parser;

public class ParserFactory {

	private ParserFactory() {
		
	}
	public static FileParser createParser(String filePath) {
		if (filePath.substring(filePath.lastIndexOf('.') + 1).equalsIgnoreCase("CSV"))
			return new CsvParser(filePath);
		return null;
	}
}
