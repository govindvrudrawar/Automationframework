package SmokeTest;

import org.testng.annotations.Test;

import keyword.KeyWord;

public class TestCases {
	@Test
	public void TC01 () {
		KeyWord.openBrowser("Chrome");
		KeyWord.openUrl("https://www.amazon.in");
			
	}

}
