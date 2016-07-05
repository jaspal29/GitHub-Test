package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePageAfterSignIn;
import Pages.OpeningPage;
import Pages.SignInPage;
import junit.framework.Assert;

public class TestCaseForSignIn {
	
	OpeningPage page;
	WebDriver driver;
	SignInPage signInPage;


	@Test(dataProvider="data")
	public void test(String Uid,String passwd) throws InterruptedException {
		
		driver=new FirefoxDriver();
		driver.get("https://github.com/");
		
		page=PageFactory.initElements(driver, OpeningPage.class);
		page.clickOnSignIn();

		signInPage=PageFactory.initElements(driver, SignInPage.class);		
		signInPage.EnterUsernameAndPassword(Uid,passwd);
		signInPage.clickSignIn();
		
		HomePageAfterSignIn homePageAfterSignIn=PageFactory.initElements(driver, HomePageAfterSignIn.class);
		homePageAfterSignIn.clickOnViewProfile();
		
		Assert.assertEquals("Signed in as "+Uid,homePageAfterSignIn.signedInAS());
		
		
	}
	
	
	@DataProvider
	public static Object[][] data()
	{
		
		
		
		return new Object[][]{
				              {"jaspal29","JAS0000pal" }
		                          
		                     };
	}
	

}
