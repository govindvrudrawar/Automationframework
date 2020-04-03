package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.text.html.HTML;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.chainsaw.Main;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class KeyWord {
	/**
	 * This method opens the browser which the user chooses
	 * 
	 */

	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sony\\Downloads\\chromedriver_win32\\chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
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
					"Invalid BrowserName Provided. " + "Expected is Chrome, Firefox, InternetExplorer, Safari, Html");
			System.out.println("You have entered incorrectly as " + browserName);
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
	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = null;
		switch (locatorType) {
		case ("LINK_TEXT"):
			elements = Constants.driver.findElements(By.linkText(locatorValue));
			break;
		case ("ID"):
			elements = Constants.driver.findElements(By.id(locatorValue));
			break;
		case ("CLASS_NAME"):
			elements = Constants.driver.findElements(By.className(locatorValue));
			break;
		case ("PARTIAL_LINK_TEXT"):
			elements = Constants.driver.findElements(By.partialLinkText(locatorValue));
			break;
		case ("XPATH"):
			elements = Constants.driver.findElements(By.xpath(locatorValue));
			break;
		case ("CSS"):
			elements = Constants.driver.findElements(By.cssSelector(locatorValue));
			break;
		case ("TAGNAME"):
			elements = Constants.driver.findElements(By.tagName(locatorValue));
		default:
			System.err.println("Please enter valid locator "
					+ "Expected:CSS, XPATH, CLASSNAME, PARTIAL_LINK_TEXT, LINK_TEXT, ID, TAGNAME");
			System.err.println("You have entered incorrectly as " + locatorType);

		}
		return elements;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickingOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void click_using_Mousefunctions(String locatorType, String locatorValue) {
		Constants.action.moveToElement(getWebElement(locatorType, locatorValue)).build().perform();

	}

	public static String getElementName(String locatorType, String locatorValue) {
		String elementName = null;
		elementName = getWebElement(locatorType, locatorValue).getText();
		return elementName;
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

	public static void createLogs(String classname) {
		Logger logger = Logger.getLogger(classname);
		PropertyConfigurator.configure(
				"C:\\Users\\sony\\eclipse-workspace\\keywordframeworkdesigning\\src\\test\\resources\\Utility\\log4j");

	}

	public static void createLogs(String classname, String filepath) {
		Logger logger = Logger.getLogger(classname);
		PropertyConfigurator.configure(filepath);

	}
	public static void navigateTo(String url) {
		Constants.driver.navigate().to(url);
	}

	public static void takeScreenShot_usingAShot() {
		Constants.ashot = new AShot();
		Screenshot sc = Constants.ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(Constants.driver);
		try {
			ImageIO.write(sc.getImage(), "PNG", new File("C:\\Users\\sony\\Desktop\\New folder.ElementScreenshot.png"));
		} catch (IOException e) {
			System.out.println("Could Not locate the file");
			e.printStackTrace();
		}
		Constants.driver.quit();
	}

	/**
	 * This method reads a file which is in .xlsx format using Apache POI
	 * 
	 * @param filepath:The location at which your Excel File is stored.
	 * @returns Object[][] obj
	 */

	public static Object[][] read_ExcelFile_using_Apache_POI(String filepath) {
		Object[][] obj;
		Constants.logger.info("Reading ExcelFile");

		try {
			Constants.fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Constants.workbook = new XSSFWorkbook(Constants.fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constants.sheet = Constants.workbook.getSheet("Sheet1");
		int rows = Constants.sheet.getLastRowNum();
		int cols = Constants.sheet.getRow(0).getLastCellNum();
		obj = new Object[rows][cols - 1];
		for (int i = 1; i <= rows; i++) {
			Row row = Constants.sheet.getRow(i);
			int column = row.getLastCellNum();
			for (int j = 1; j < column; j++) {
				Constants.cell = row.getCell(j);
				// System.out.println(cell.getCellType());
				switch (Constants.cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					obj[i - 1][j - 1] = "";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					obj[i - 1][j - 1] = Constants.cell.getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_ERROR:
					obj[i - 1][j - 1] = "";
					break;
				case Cell.CELL_TYPE_NUMERIC:
					obj[i - 1][j - 1] = Constants.cell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_STRING:
					obj[i - 1][j - 1] = Constants.cell.getStringCellValue();
					// System.out.println("Get String cell type");
					break;
				}
			}

		}
		try {
			Constants.workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 
	 * This method reads JASON file
	 * 
	 * @param filepath
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException        The filepath when used has to be given in ""
	 *                               key which has to be passed is the name of the
	 *                               JSON object
	 */
	public static Iterator<String> read_JSON_file(String filepath, String key)
			throws FileNotFoundException, IOException, ParseException {
		// This line will initialize JSONParser class
		Object obj = new JSONParser().parse(new FileReader(filepath));

		// this line will type cast normal object into JSONObject
		JSONObject jsobj = (JSONObject) obj;

		// getting JSONArray
		JSONArray ja = (JSONArray) jsobj.get(key);

		// Iterating the contents of the array
		Constants.itr = ja.iterator();
		while (Constants.itr.hasNext()) {
			System.out.println(Constants.itr.next());
		}
		return Constants.itr;
	}

	/**
	 * This method closes the window which is currently opened
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
