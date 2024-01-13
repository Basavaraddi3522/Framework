package com.frameworkDesign.SeleniumFrameWorkDesign.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import frameWorksPages.LandingPage;

public class BaseTest {
	public WebDriver d;
	public LandingPage l;

	// reading the Content from Global properties

	public WebDriver browserInitilization() throws IOException {

		// reading the global property file using Properties class
		Properties prop = new Properties();
		// since load() will take input stream need to convert the file to input stream
		// using fileInputSream
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\frameworkDesign\\SeleniumFrameWorkDesign\\resources\\Global.properties");
		// System.getProperty("user.dir")--> will give the package name used dynamically
		prop.load(fis);
		
		// this below lie is to handle the parameteriztin using maven as well if no browser is provided it will search in global property and run on respective browser
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");

		//String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			d = new ChromeDriver(options);
			d.manage().window().setSize(new Dimension(1440, 900));// to make screen ize full when executed in headless

		} else if (browserName.contains("firefox")) {
			d = new FirefoxDriver();
		} else if (browserName.contains("xyz")) {
			// write respctive driver
		} else {
			System.out.println("Broswer is not found");
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return d;
	}

	@BeforeMethod(alwaysRun = true)

	public LandingPage launchApplicationFromBase() throws IOException {

		d = browserInitilization();
		l = new LandingPage(d);
		l.navigateToUrl();
		return l;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		d.close();
	}

	public List<HashMap<String, String>> getjsondataToMap() throws IOException {

		// read the json to string

		String jsonContent = FileUtils.readFileToString(
				new File("C:\\Users\\Admin\\SeleniumJavaCourse\\SeleniumFrameWorkDesign\\src\\test\\java\\com\\frameworkDesign\\SeleniumFrameWorkDesign\\data\\dataprovider.json"),
				StandardCharsets.UTF_8);

		// Convert String to HashMap using Jackson dependency

		ObjectMapper mapper = new ObjectMapper();
		// Object mapper have inbuilt method to read

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
	
	public String getSceenShot(String testCaseName,WebDriver d) throws IOException {
		TakesScreenshot t=(TakesScreenshot)d;
		File source=t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\report\\"+ testCaseName+".png"));
		return  System.getProperty("user.dir")+"\\report\\"+ testCaseName+".png";
		
		// here the local workspce locaion is returned to attached the screenshot to the reports
	}

}
