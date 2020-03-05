package utilities;

public class Launcher {

	public static void main(String[] args) {
		String filePath = args[1];
		String fileDescriptor;
		String fileRules;
		String fileAnonymizationsRules;
		String fileOutputPath;
		String outputDelimiter = ";";
		switch(args[0]) {
		case "-v":
			fileDescriptor = args[2];
			fileRules = args[3];
			fileOutputPath=args[4];
			if(args.length == 6)
				outputDelimiter=args[5];
			VerifyUtils.verifyData(filePath, fileDescriptor, fileRules, fileOutputPath, outputDelimiter);
			break;
		case "-a":
			fileAnonymizationsRules = args[2];
			fileOutputPath = args[3];
			if(args.length == 5)
				outputDelimiter=args[4];
			AnonymizationUtils.anonymizeData(filePath, fileAnonymizationsRules, fileOutputPath, outputDelimiter);
			break;
		}
	}
}
