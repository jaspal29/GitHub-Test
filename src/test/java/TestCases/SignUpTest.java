package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.OpeningPage;
import Pages.SignUp;

public class SignUpTest {

	@Test
	public void test()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://github.com/");

          driver.manage().window().maximize();
		OpeningPage opening=PageFactory.initElements(driver,OpeningPage.class);
		
		opening.clickOnSignUP();
		
		SignUp signup=PageFactory.initElements(driver,SignUp.class);
		signup.signUpDetails("jaspal12345567284", "heeihui542ehf@gmail.com", "huegfiuhe2oi1");// enter name and password and email
		
		
		
		Assert.assertEquals("https://github.com/join/plan",driver.getCurrentUrl());
	}
	
}
