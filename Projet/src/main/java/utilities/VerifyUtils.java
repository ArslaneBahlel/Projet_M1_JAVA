package utilities;

import parser.FileParser;
import parser.ParserFactory;
import verifydata.DataVerification;
import writers.FileOutputWriterFactory;

public class VerifyUtils {
	
	/**
	 * Verifies Data in filePath according to fileDescriptor data description and to fileRules data verification rules
	 * @param filePath : path of file to verify
	 * @param fileDescriptor : path of data description file
	 * @param fileRules : path of data verification rules file
	 * @param fileOutputPath : path of output file
	 * @param outputDelimiter : delimiter of the output file
	 */
	public static void verifyData(String filePath, String fileDescriptor, 
			String fileRules, String fileOutputPath, String outputDelimiter) {
		FileParser parser = ParserFactory.createParser(filePath);
		
		DataVerification dv = new DataVerification(parser.parse());
		
		parser = ParserFactory.createParser(fileDescriptor);
		dv.setDescriptors(parser.parse());
		
		parser = ParserFactory.createParser(fileRules);
		dv.setRules(parser.parse());

		FileOutputWriterFactory.createWriter(dv.getDataVerified(), outputDelimiter, fileOutputPath).write();

	}

}
