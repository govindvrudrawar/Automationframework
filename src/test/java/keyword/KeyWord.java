package keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyWord {
	
		public static void openBrowser(String browserName) {
		switch(browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		case "Safari":
			WebDriverManager.operadriver().setup();
			Constants.driver = new SafariDriver();
			break;
		default:
			System.err.println("Invalid BrowserName Provided. "+"Expected is Chrome, Firefox, InternetExplorer, Safari");
			break;
			
		}
	}

	public static void openUrl (String url) {
		
		Constants.driver.get(url);
	}
}
	