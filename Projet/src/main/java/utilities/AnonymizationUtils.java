package utilities;

import anonymization.DataAnonymization;
import parser.FileParser;
import parser.ParserFactory;
import writers.FileOutputWriterFactory;

public class AnonymizationUtils {

	/**
	 * 
	 * @param filePath : path of file to verify
	 * @param fileAnonymizationsRules : path of data anonymization rules file
	 * @param fileOutputPath : path of output file
	 * @param outputDelimiter : delimiter of the output file
	 */
	public static void anonymizeData(String filePath,
			String fileAnonymizationsRules, String fileOutputPath, String outputDelimiter) {
		FileParser parser = ParserFactory.createParser(filePath);
		
		DataAnonymization dv = new DataAnonymization(parser.parse());
				
		parser = ParserFactory.createParser(fileAnonymizationsRules);

		dv.setAnonymizers(parser.parse());
		
		FileOutputWriterFactory.createWriter(dv.getDataAnonymized(), outputDelimiter, fileOutputPath).write();
	}
	
}
