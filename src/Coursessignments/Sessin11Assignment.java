package Coursessignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Sessin11Assignment {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]"));
		String selectedCheckboxNmae = checkBox.getText();
		WebElement clickOnoption = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		clickOnoption.click();
		System.out.println(selectedCheckboxNmae);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select se = new Select(dropdown);
		se.selectByVisibleText(selectedCheckboxNmae);

		// handing the alert

		WebElement enterName = driver.findElement(
				By.xpath("//legend[text()='Switch To Alert Example']/following-sibling::input[@id='name']"));
		enterName.sendKeys(selectedCheckboxNmae);

		WebElement alert = driver.findElement(By.id("alertbtn"));
		alert.click();

		Alert ale = driver.switchTo().alert();

		String alertmessage = ale.getText();
		// System.out.println(alertmessage);

		Assert.assertEquals(alertmessage,
				"Hello" + " " + selectedCheckboxNmae + "," + " " + "share this practice page and share your knowledge");
		ale.accept();
		driver.close();

	}

}
