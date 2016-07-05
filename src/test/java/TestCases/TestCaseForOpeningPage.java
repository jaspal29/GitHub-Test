package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.OpeningPage;
import junit.framework.Assert;

public class TestCaseForOpeningPage {

	OpeningPage page;
	WebDriver driver;


	@Test
	public void test() throws InterruptedException {
		
		driver=new FirefoxDriver();
		driver.get("https://github.com/");
		page=PageFactory.initElements(driver, OpeningPage.class);

		Assert.assertEquals(true, page.verifyPage());



	}
}
