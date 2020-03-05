package parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import parser.CsvParser;

class CsvParserTest {

	
	private CsvParser csvParser = new CsvParser("src/main/resources/file.csv");
	
	
	@Test
	void testParser() {
		List<HashMap<String, String>> list = csvParser.parse();
		assertEquals(1, list.size());	
		assertEquals(5, list.get(0).size());	
	}

	@Test
	void testParse() {
		List<HashMap<String, String>> list = csvParser.parse();
		System.out.println(list);
		assertEquals("arslane.bahlel@dauphine.eu", list.get(0).get("EMAIL_PRO"));
		assertEquals("arslane.bahlel@gmail.com", list.get(0).get("EMAIL_PERSO"));
		assertEquals("Arslane", list.get(0).get("NOM"));
		assertEquals("2", list.get(0).get("AGE"));
		assertEquals("05/06/1997", list.get(0).get("DATE_DE_NAISSANCE"));
	}
	
}
