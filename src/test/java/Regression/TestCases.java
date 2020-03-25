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
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		KeyWord.ClickingtheElement(PropertyFile.getLocator("TodayDeals")[0], PropertyFile.getLocator("TodayDeals")[1]);
		KeyWord.closeAllWindows();
	}

	@Test
	public void TC03() throws InterruptedException {
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
		KeyWord.windowMaximize();
		Thread.sleep(3000);
		System.out.println(
				KeyWord.getTabName(PropertyFile.getLocator("AmazonPay")[0], PropertyFile.getLocator("AmazonPay")[1]));
		System.out.println(
				KeyWord.getTabName(PropertyFile.getLocator("TodayDeals")[0], PropertyFile.getLocator("TodayDeals")[1]));
		System.out.println(KeyWord.getTabName(PropertyFile.getLocator("NewReleases")[0],
				PropertyFile.getLocator("NewReleases")[1]));
		System.out.println(
				KeyWord.getTabName(PropertyFile.getLocator("Mobiles")[0], PropertyFile.getLocator("Mobiles")[1]));
		System.out.println(
				KeyWord.getTabName(PropertyFile.getLocator("Pantry")[0], PropertyFile.getLocator("Pantry")[1]));
		System.out.println(KeyWord.getTabName(PropertyFile.getLocator("BestSellers")[0],
				PropertyFile.getLocator("BestSellers")[1]));
		KeyWord.closeAllWindows();
	}

	@Test
	public void TC04() throws InterruptedException {

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
}
