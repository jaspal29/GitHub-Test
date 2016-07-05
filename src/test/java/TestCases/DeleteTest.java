package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePageAfterSignIn;
import Pages.OpeningPage;
import Pages.RepositoryHomepage;
import Pages.SettingsPage;
import Pages.SignInPage;
import junit.framework.Assert;

public class DeleteTest {


	OpeningPage page;
	WebDriver driver;
	SignInPage signInPage;


	@Test(dataProvider="data")
	public void test(String Uid,String passwd,String ProjectName) throws InterruptedException {
		
		driver=new FirefoxDriver();
		driver.get("https://github.com/");
		
		page=PageFactory.initElements(driver, OpeningPage.class);
		page.clickOnSignIn();

		signInPage=PageFactory.initElements(driver, SignInPage.class);		
		signInPage.EnterUsernameAndPassword(Uid,passwd);
		signInPage.clickSignIn();
		
		HomePageAfterSignIn homePageAfterSignIn=PageFactory.initElements(driver, HomePageAfterSignIn.class);
		homePageAfterSignIn.clickOnViewProfile();
		
		driver.get("https://github.com/jaspal29/"+ProjectName);
		
		RepositoryHomepage repositoryHomepage =PageFactory.initElements(driver, RepositoryHomepage.class);
		repositoryHomepage.clickOnSettings();
		 SettingsPage s= PageFactory.initElements(driver,SettingsPage.class);
		   Thread.sleep(3000);
		   Assert.assertEquals(false,s.delete(ProjectName));
		
	}
	
	
	@DataProvider
	public static Object[][] data()
	{
		
		
		
		return new Object[][]{
				              {"jaspal29","JAS0000pal","hgh" }// put here your username and password and the project you want to delete
		                          
		                     };
	}




}
