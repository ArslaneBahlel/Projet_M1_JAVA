package writers;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import parser.FileParser;
import parser.ParserFactory;


class DataWriterTest {


	@Test
	void testWrite() {
		String file = ".\\src\\test\\resources\\output.csv";
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> row = new HashMap<>();
		row.put("test", "test1");
		list.add(row);
		FileOutputWriterFactory.createWriter(list, ",", file).write();
		list  = ParserFactory.createParser(file).parse();
		assertEquals(1,list.size());
		assertFalse(list.get(0).keySet().contains("NOM"));
		assertFalse(list.get(0).keySet().contains("EMAIL_PRO"));
		assertFalse(list.get(0).values().contains("Arslane"));
	
		
	}

}
