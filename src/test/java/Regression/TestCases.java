package Regression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import keyword.Constants;
import keyword.KeyWord;
import keyword.PropertyFile;

public class TestCases {

	@Test
	public void TC01() {
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();

	}

	@Test
	public void TC02() throws InterruptedException {
		// This test will check if given tab on the webpage is clickable
		KeyWord.openBrowser("FireFox");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		KeyWord.ClickingtheElement(PropertyFile.getLocator("TodayDeals")[0], PropertyFile.getLocator("TodayDeals")[1]);
		KeyWord.closeAllWindows();
	}

	@Test
	public void TC03() throws InterruptedException {
		// To test if the url opens in all browser
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();

		KeyWord.openBrowser("FireFox");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();

		KeyWord.openBrowser("InternetExplorer");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();

		KeyWord.openBrowser("Safari");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();

		KeyWord.openBrowser("Html");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.closeWindow();
	}

	@Test
	public void TC04() throws InterruptedException {
		// This Test case will get the tab names of the main tabs present on the webpage
		KeyWord.openBrowser("FireFox");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("AmazonPay")[0],
				PropertyFile.getLocator("AmazonPay")[1]));
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("TodayDeals")[0],
				PropertyFile.getLocator("TodayDeals")[1]));
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("NewReleases")[0],
				PropertyFile.getLocator("NewReleases")[1]));
		System.out.println(
				KeyWord.getElementName(PropertyFile.getLocator("Mobiles")[0], PropertyFile.getLocator("Mobiles")[1]));
		System.out.println(
				KeyWord.getElementName(PropertyFile.getLocator("Pantry")[0], PropertyFile.getLocator("Pantry")[1]));
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("BestSellers")[0],
				PropertyFile.getLocator("BestSellers")[1]));
		KeyWord.closeAllWindows();
	}

	@Test
	public void TC05() throws InterruptedException {
		// This test case will check the TAB sequence of the main tabs/elements

		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		try {
			KeyWord.getWebElement(PropertyFile.getLocator("AmazonPay")[0], PropertyFile.getLocator("AmazonPay")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("TodaysDeal")[0], PropertyFile.getLocator("TodaysDeal")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("BestSellers")[0], PropertyFile.getLocator("BestSellers")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Mobiles")[0], PropertyFile.getLocator("Mobiles")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("CustomerService")[0],
					PropertyFile.getLocator("CustomerService")[1]).sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("NewRealses")[0], PropertyFile.getLocator("NewRealses")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Pantry")[0], PropertyFile.getLocator("Pantry")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Coupons")[0], PropertyFile.getLocator("Coupons")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Sell")[0], PropertyFile.getLocator("Sell")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Computers")[0], PropertyFile.getLocator("Computers")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Books")[0], PropertyFile.getLocator("Books")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("AmazonBasic")[0], PropertyFile.getLocator("AmazonBasic")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("Baby")[0], PropertyFile.getLocator("Baby")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("GiftIdeas")[0], PropertyFile.getLocator("GiftIdeas")[1])
					.sendKeys(Keys.TAB);
		} catch (NoSuchElementException e) {
			System.out.println("Could not find the element");
		} finally {

			KeyWord.closeAllWindows();
		}
	}

	public static void TC06() throws InterruptedException {
		// This test case will check if the item searched in the TextBox is searched
		// correctly and displays correct result and if the
		// item is not there does it displays appropriate message
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"SoapDispenser");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1], "Sanitizer");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"HydroxyChloroquine Tablets");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1], "Detol");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"N95 Face Mask");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"Mobile Charger");
		Thread.sleep(1000);
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"1 TB HardDrive");
		Thread.sleep(1000);
	}

	public static void TC07() throws InterruptedException {
		// This test case checks how does the application behaves if we make a spelling
		// mistake and does the web application auto-correct and/or auto-populate or
		// give appropriate message
		KeyWord.enterText(PropertyFile.getLocator("TextBox")[0], PropertyFile.getLocator("TextBox")[1],
				"Hydrochloroquine tablets");

		Thread.sleep(3000);
	}

	public static void TC08() throws InterruptedException {
		// This test case checks does the webapplications follow TAB sequence whilst
		// choosing payment method
		// i.e. COD(cash on delivery, debit/credit card, internet banking, UPI and
		// installments)
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in/gp/buy/payselect/handlers/display.html?hasWorkingJavascript=1");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		try {
			KeyWord.getWebElement(PropertyFile.getLocator("DebitCard")[0], PropertyFile.getLocator("DebitCard")[1])
					.sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("CVVQuestionMark")[0],
					PropertyFile.getLocator("CVVQuestionMark")[1]).sendKeys(Keys.TAB);
			KeyWord.getWebElement(PropertyFile.getLocator("CVV_BlankSpace")[0],
					PropertyFile.getLocator("CVV_BlankSpace")[1]).sendKeys(Keys.TAB);
		} finally {

			System.out.println("Could not find the element");
		}
	}

	public static void TC10() throws InterruptedException {
		// This test case is to check if the same product search in two different
		// portals gives comparable results i.e. Amazon and Flipkart in this case.
		// and display the result.
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		KeyWord.enterText(PropertyFile.getLocator("AmazonTextBox")[0], PropertyFile.getLocator("AmazonTextBox")[1],
				"Colgate ZigZag");
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("Colgate ZigZag")[0],
				PropertyFile.getLocator("Colgate ZigZag")[1]));
		Thread.sleep(3000);
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.flipkart.com");
		KeyWord.windowMaximize();
		KeyWord.enterText(PropertyFile.getLocator("FlipkartTextBox")[0], PropertyFile.getLocator("FlipkartTextBox")[1],
				"Colgate ZigZag");
		System.out.println(KeyWord.getElementName(PropertyFile.getLocator("FlipkartColgateZigZag")[0],
				PropertyFile.getLocator("FlipkartColgateZigZag")[1]));

		Thread.sleep(3000);

	}

	public static void TC11() {

	}

	public static void TC12() {

	}

	public static void TC13() {

	}

	public static void TC14() {

	}

	public static void TC15() {

	}

	public static void TC16() {

	}

	public static void TC17() {

	}

	public static void TC18() {

	}

	public static void TC19() {

	}

	public static void TC20() {

	}
}
