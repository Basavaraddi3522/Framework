package WorkingWithJsonData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingTheDatasUsingJson {
	
	public List<HashMap<String, String>> readData() throws IOException {
		
		String JsonContent=FileUtils.readFileToString(new File("C:\\Users\\Admin\\SeleniumJavaCourse\\Introduction\\src\\WorkingWithJsonData\\Data.json\\LoginData.json"), StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String, String>> maa=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return maa;
	}
	
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> dataIs=readData();
		return new Object[][] {{dataIs.get(0)}};
	}
	
	@Test(dataProvider = "getData")
	public void readingtheJsonThroughDataProvider(HashMap<String, String> j) {
		System.out.println(j.get("email"));
		
		
		
	}

}


