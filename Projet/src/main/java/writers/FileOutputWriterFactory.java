package writers;

import java.util.HashMap;
import java.util.List;

public class FileOutputWriterFactory {

	/**
	 * FileOutputWriterFactory cannot be instantiated
	 */
	private FileOutputWriterFactory() {}
	
	/**
	 * 
	 * @param file : file content list
	 * @param delimiter : columns delimiter
	 * @param fileOutputPath : file output path
	 * @return : the right File Writer
	 */
	public static FileOutputWriter createWriter(List<HashMap<String, String>> file, String delimiter,
			String fileOutputPath) {
		if (fileOutputPath.substring(fileOutputPath.lastIndexOf('.') + 1).equalsIgnoreCase("CSV"))
			return new CsvOutputWriter(file, delimiter, fileOutputPath);
		return null;
	}
}
