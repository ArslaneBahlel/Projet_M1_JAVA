package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import data.Rule;

class JsonParserTest {


	@Test
	void testJsonParser() {
		JsonParser jsonParserRules = new JsonParser("src/main/resources/rules.json");
		List listRules = jsonParserRules.parse();
		Gson gson = new Gson();
		String jsonString = gson.toJson(listRules);
		Rule rule = gson.fromJson(listRules.get(0).toString(), Rule.class);
		System.out.println(rule);
		assertEquals(3, listRules.size());	
	}

	@Test
	void testParse() {
		System.out.println("yanis");//assertEquals("AGE;[BE_AN_AGE]", listRules.get(0));
	}
	//NOM;STRING, AGE;INT, DATE_DE_NAISSANCE;STRING, EMAIL_PRO;STRING, EMAIL_PERSO;STRING
	
}
