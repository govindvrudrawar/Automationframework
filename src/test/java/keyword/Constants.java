/**
 * This class contains only variables 
 * @param : WebDriver Driver is a reference variable which will be pointing to the driver of the respective
 * browser being currently used 
 * @returns : returns driver reference variable 
 */

package keyword;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;

/**
 * 
 * This is Class containing just constants.
 * 
 * @author Govind Rudrawar
 *
 */

public class Constants {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static WebElement element;
	public static AShot ashot;
	public static ChromeOptions options;
	public static Iterator<String> itr;
	public static Iterator<WebElement> iterator;
	public static Logger logger;
	public static Actions action;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Cell cell;
	

}
