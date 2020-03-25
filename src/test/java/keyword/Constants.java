/**
 * This class contains only variables 
 * @param : WebDriver Driver is a reference variable which will be pointing to the driver of the respective
 * browser being currently used 
 * @returns : returns driver reference variable 
 */

package keyword;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
