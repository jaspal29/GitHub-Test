package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePageAfterSignIn;
import Pages.NewRepositoryDetails;
import Pages.OpeningPage;
import Pages.SignInPage;
import junit.framework.Assert;

public class NewRepositoryCreationTest {
	
	OpeningPage page;
	WebDriver driver;
	SignInPage signInPage;
	String projectName="hello";
	String description="hi";

	@Test(dataProvider="data")
	public void test(String uid,String passwd)
	{
		
		
	
		driver=new FirefoxDriver();
		driver.get("https://github.com/");
		
		page=PageFactory.initElements(driver, OpeningPage.class);
		page.clickOnSignIn();

		signInPage=PageFactory.initElements(driver, SignInPage.class);		
		signInPage.EnterUsernameAndPassword(uid,passwd);
		signInPage.clickSignIn();
		
		HomePageAfterSignIn homePageAfterSignIn=PageFactory.initElements(driver, HomePageAfterSignIn.class);
	    homePageAfterSignIn.clickNewRepository();
	    
	    NewRepositoryDetails newRepo=PageFactory.initElements(driver, NewRepositoryDetails.class);
	       newRepo.EnterRepository(projectName,description);
		  newRepo.createRepository();
	       Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[1]/div[1]/div/div[3]/div/span/input")).isDisplayed());
		
	}
	@DataProvider
	public static Object[][] data()
	{
		
		
		
		return new Object[][]{
				              {"jaspal29","JAS0000pal" }
		                          
		                     };
	}
	

	
}
