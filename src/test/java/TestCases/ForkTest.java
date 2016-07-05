package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.OaIdl.PARAMDESC;

import Pages.OpeningPage;
import Pages.Profile;

import Pages.RepositoryToBeForked;
import Pages.SignInPage;
import junit.framework.Assert;

public class ForkTest {
	WebDriver driver;
	@Test(dataProvider="data")
	public void check(String uid,String passwd,String username,String Repository) throws InterruptedException
	{
		
		driver=new FirefoxDriver();
		driver.get("https://github.com/");
		
		OpeningPage page=PageFactory.initElements(driver, OpeningPage.class);
		page.clickOnSignIn();

		SignInPage signInPage=PageFactory.initElements(driver, SignInPage.class);		
		signInPage.EnterUsernameAndPassword(uid,passwd);
		signInPage.clickSignIn();
		driver.get("https://github.com/"+username+"/"+Repository);
		
		RepositoryToBeForked repositoryToBeForked=PageFactory.initElements(driver, RepositoryToBeForked.class);
		repositoryToBeForked.clickOnFork();
	
		Thread.sleep(7000);
	Assert.assertEquals("https://github.com/"+uid+"/"+Repository, driver.getCurrentUrl());
	}
	
	
	@DataProvider
	public static Object[][] data()
	{
		
		
		
		return new Object[][]{
				              {"jaspal29","JAS0000pal","StacktipsLab","Advance-Android-Tutorials" } //put your username and password here
		                          
		                     };
	}
	
	
}
