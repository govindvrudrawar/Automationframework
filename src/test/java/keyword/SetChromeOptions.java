package keyword;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetChromeOptions {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe\\");
		

		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("--enable-automation");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");

		Constants.driver = new ChromeDriver(options);
		Constants.driver.navigate().to("http://www.google.com");
		Constants.driver.quit();
	}

}
