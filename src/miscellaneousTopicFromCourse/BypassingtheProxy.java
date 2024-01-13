package miscellaneousTopicFromCourse;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BypassingtheProxy {
	public static void main(String[] args) {
		ChromeOptions op=new ChromeOptions();
		Proxy proxy =new Proxy();
		proxy.setHttpProxy("ex ipaddress:ports");
		op.setCapability("proxy", proxy);
		WebDriver d=new ChromeDriver(op);
		
		// to know more options in chrome go to :  https://chromedriver.chromium.org/capabilities
		
	}

}
