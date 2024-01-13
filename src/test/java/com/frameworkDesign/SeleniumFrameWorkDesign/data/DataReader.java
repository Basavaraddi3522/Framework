package com.frameworkDesign.SeleniumFrameWorkDesign.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getjsondataToMap() throws IOException {
		
		//read the json to string
		
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("usr.dire")+"\\src\\test\\java\\com\\frameworkDesign\\SeleniumFrameWorkDesign\\data\\dataprovider.json"),StandardCharsets.UTF_8);
		
		// Convert String to HashMap using Jackson dependency
		
		ObjectMapper mapper=new ObjectMapper() ;
		// Object mapper have inbuilt method to read
		
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference <List<HashMap<String,String>>>() {
		});
		
		return data;
	}

}
