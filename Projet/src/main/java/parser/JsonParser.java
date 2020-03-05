package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import data.Anonymizer;
import data.Data;
import data.Descriptor;
import data.Rule;

public class JsonParser<T extends Data> implements FileParser{
	private String filePath;
	
	/**
	 * JsonParser constructor
	 * @param filePath : this json file path
	 */
	public JsonParser(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * {@inheritDoc}
	 * @return the Json file content in a List<? extends Data>, not null
	 */
	@Override
	public List<? extends Data> parse() {
		Gson gson = new Gson();
		String jsonString = null;
		try {
			jsonString = gson.fromJson(new FileReader(this.filePath), Object.class).toString();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Type descriptorType ;
		if (jsonString.contains("should"))
			descriptorType = new TypeToken<List<Rule>>(){}.getType();
		else if (jsonString.contains("changeTo"))
			descriptorType = new TypeToken<List<Anonymizer>>(){}.getType();
		else
			descriptorType = new TypeToken<List<Descriptor>>(){}.getType();
		
		return gson.fromJson(jsonString, descriptorType);

	}
}
