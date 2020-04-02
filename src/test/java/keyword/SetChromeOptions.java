package keyword;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetChromeOptions {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
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

		options.addExtensions(new File("/path/to/extension.crx"));
		Constants.driver = new ChromeDriver(options);
		options.addArguments("load-extension=/path/to/extension");

		Constants.driver = new ChromeDriver(options);
		Constants.driver.navigate().to("http://www.google.com");
		Constants.driver.quit();
	}

}
