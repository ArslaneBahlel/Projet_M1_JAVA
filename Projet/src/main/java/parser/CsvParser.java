package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvParser implements FileParser {
	public String filePath;

	private final static List<String> delimiterList = new ArrayList<>();
	static {
		delimiterList.add(",");
		delimiterList.add(";");
	}
	/**
	 * CsvParser constructor
	 * @param filePath : this csv file path
	 */
	public CsvParser(String filePath) {
		
		this.filePath = filePath;
	}
	/**
	 * {@inheritDoc}
	 * <p>returns a List<HashMap<String, String>> where each HashMap<String, String> is a row
	 * <ul>
	 * <li>HashMap's key is the column name</li>
	 * <li>HashMap's value is the column value</li>
	 * </ul></p>
	 * @return the List<HashMap<String, String>>, not null
	 */
	@Override
	public List<HashMap<String, String>> parse() {
		File file = new File(this.filePath);
		String line;
		String [] elts;
		String[] head;
		String delimiter;
		BufferedReader br;
		List<HashMap<String, String>> rows = new ArrayList<>();
		HashMap<String, String> row ;
		try {
			br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			delimiter = CsvParser.getDelimiter(line);
			head = line.split(delimiter);
			while((line=br.readLine())!=null){
				row = new HashMap<>();
				elts = line.split(delimiter);
				for(int i=0;i<head.length;i++) 
					row.put(head[i], elts[i]);
				rows.add(row);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rows;
		
	}
	
	/**
	 * @param text : one row of the csv file, not null
	 * @return String : row delimiter, null if isn't present in delimiterList
	 */
	private static String getDelimiter(String text) {
		String delimiter = delimiterList.stream().filter( x -> text.contains(x)).findAny().orElse(null);
        return delimiter;
    }

}
