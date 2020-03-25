package keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyWord {

	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			System.out.println("Using Chrome Browser");
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			System.out.println("Using FireFox Browser");
			break;
		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			System.out.println("Using IE Browser");
			break;
		case "Safari":
			WebDriverManager.operadriver().setup();
			Constants.driver = new SafariDriver();
			System.out.println("Using the Safari Browser");
			break;
		default:
			System.err.println(
					"Invalid BrowserName Provided. " + "Expected is Chrome, Firefox, InternetExplorer, Safari");
			System.out.println("You have entered"+browserName);
			break;

		}
	}

	/**
	 * This method will open the given url
	 * 
	 * @param url
	 * @return:It will return void
	 */

	public static void openUrl(String url) {

		Constants.driver.get(url);
		System.out.println("Opening the url  " + url + "....");
	}

	/**
	 * This method will maximize the window to which the current driver instance is
	 * pointing to.
	 * 
	 */
	public static void windowMaximize() {
		Constants.driver.manage().window().maximize();
	}

	/**
	 * This method will get WebElement
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case ("LINK_TEXT"):
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case ("ID"):
			element = Constants.driver.findElement(By.id(locatorValue));
			break;
		case ("CLASS_NAME"):
			element = Constants.driver.findElement(By.className(locatorValue));
			break;
		case ("PARTIAL_LINK_TEXT"):
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case ("XPATH"):
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case ("CSS"):
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case ("TAGNAME"):
			element = Constants.driver.findElement(By.tagName(locatorValue));
		default:
			System.err.println("Please enter valid locator "
					+ "Expected:CSS, XPATH, CLASSNAME, PARTIAL_LINK_TEXT, LINK_TEXT, ID, TAGNAME");
			System.err.println("You have entered incorrectly as " + locatorType);

		}
		return element;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void ClickingtheElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static String getTabName(String locatorType, String locatorValue) {
		String tabName = null;
		tabName = getWebElement(locatorType, locatorValue).getText();
		return tabName;
	}

	
	

	/**
	 * This method verifies if the number of main tabs of the opened url is same as
	 * expected expected
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException,          FileNotFoundException
	 * 
	 */

	public static void verifyNoOfMainTabs() throws FileNotFoundException, IOException {
		System.out.println(PropertyFile.getProperty("NoOfTabs"));
		String NumberofTabs = PropertyFile.getProperty("NoOfTabs");
		int i = Integer.parseInt(NumberofTabs);
		if (i == 6) {
			System.out.println("Test is Passed as Number of Tabs seen on the main page is same as " + i);
		} else {
			System.out.println("Test is failed as Number of Tabs seen on the main page is not equal to" + i);
		}
	}

	/**
	 * This method will select the value from a Dropdown if the Dropdown has a
	 * Select tag
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @param textToEnter
	 */
	public static void selectFromDropdown(String locatorType, String locatorValue, String textToEnter) {
		WebElement element = getWebElement(locatorType, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToEnter);
	}

	/**
	 * This method closes the window which is currently closed
	 */

	public static void closeWindow() {
		Constants.driver.close();
	}

	/**
	 * This method closes all windows opened by the browsers
	 * 
	 */
	public static void closeAllWindows() {
		Constants.driver.quit();
	}
}
