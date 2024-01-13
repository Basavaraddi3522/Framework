package miscellaneousTopicFromCourse;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotsConfiguration {
	public static void main(String[] args) throws IOException {

		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.get("https://www.amazon.in/");

		File f = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		// using Files to save to local machine
		// Files.copy(f, new
		// File("C:\\Users\\Admin\\Downloads\\SeleniumScreenshot\\p1_sc.jpeg"));

		// using the fileutilities to save to local machine

		FileUtils.copyFile(f, new File("C:\\Users\\Admin\\Downloads\\SeleniumScreenshot\\p2_sc.png"));

	}

}
