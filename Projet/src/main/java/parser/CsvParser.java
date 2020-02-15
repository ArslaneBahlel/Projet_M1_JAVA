package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvParser implements FileParser {
	public String filePath;

	
	private static List<String> delimiterList = new ArrayList<String>() {{
		add(",");
        add(";");
	}};

	public CsvParser(String filePath) {
		this.filePath = filePath;
	}

	public List<HashMap<String, String>> parse() {
		File file = new File(this.filePath);
		String line;
		String [] elts;
		String[] head;
		String delimiter;
		BufferedReader br;
		List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> row = new HashMap<String, String>();
		try {
			br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			delimiter = CsvParser.getDelimiter(line);
			head = line.split(delimiter);						
			do {
				elts = line.split(delimiter);
				for(int i=0;i<head.length;i++) 
					row.put(head[i], elts[i]);
				rows.add(row);
			}while((line=br.readLine())!=null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	private static String getDelimiter(String text) {
		String delimiter = delimiterList.stream().filter( x -> text.contains(x)).findFirst().orElseThrow();
        return delimiter;
    }

}
