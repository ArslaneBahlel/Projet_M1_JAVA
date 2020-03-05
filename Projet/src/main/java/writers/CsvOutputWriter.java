package writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CsvOutputWriter implements FileOutputWriter {
	List<HashMap<String, String>> file;
	String fileOutputPath;
	String delimiter;
	
	public CsvOutputWriter(List<HashMap<String, String>> file, String delimiter,
			String fileOutputPath) {
		this.file = file;
		this.delimiter = delimiter;
		this.fileOutputPath = fileOutputPath;
	}

	/**
	 * Writes into a csv file
	 * @return a List with the File content
	 */
	@Override
	public void write() {

		File outputFile = new File(fileOutputPath);
		FileWriter writer = null;
		try {
			writer = new FileWriter(outputFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(writer);
		
		try {
			bw.write(file.stream().skip(file.size()-1).map( row -> {
				return row.entrySet().stream().map( c -> c.getKey()).reduce("",
						(partial, newelt)-> partial+newelt+delimiter, (p1, p2)-> p1+p2);
			}).reduce("",
					(partial, newelt)-> partial+newelt, (p1, p2)-> p1+p2));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			bw.write("\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		file.stream().forEach(row -> {
			try {
				bw.write( row.entrySet().stream().map( c -> c.getValue()).reduce("",
						(partial, newelt)-> partial+newelt+delimiter, (p1, p2)-> p1+p2));
				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
