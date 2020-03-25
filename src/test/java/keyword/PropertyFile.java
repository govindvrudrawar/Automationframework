package keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertyFile {

	public static String getProperty(String key) throws IOException, FileNotFoundException {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter the number of main tabs");
		// String NoOfTabs = sc.next();
		// int i =Integer.parseInt(NoOfTabs);
		// (for int j=0; j<=i; j++)
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\sony\\eclipse-workspace\\keywordframeworkdesigning\\src\\test\\java\\keyword\\ObjectRepository.properties");
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("Could not locate the file");
			e.printStackTrace();
		}
		return value;
	}
	public static String[] getLocator(String key ) {
		String[] parts =null;
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\sony\\eclipse-workspace\\keywordframeworkdesigning\\src\\test\\java\\keyword\\ObjectRepository.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String values = prop.getProperty(key);
			parts=values.split("&&");
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not locate the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not fetch the data from the file ");
			e.printStackTrace();
		}
		return parts;
	}
	
}
