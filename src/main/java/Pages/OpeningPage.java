package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utility.DriverInit;

public class OpeningPage extends DriverInit{

	@FindBy(linkText="Sign in")
	WebElement signIn;
	@FindBy(linkText="Sign up")
	WebElement signup;

	@FindBy(css="[class^='logged-out']")
	WebElement pageBody;


	public OpeningPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnSignIn()
	{
		signIn.click();

	}


	public boolean verifyPage()
	{
		return pageBody.isDisplayed();

	}

	public void clickOnSignUP()
	{
		
		
		signup.click();
	}
	
	
	
	

}
