package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class SignUp extends DriverInit {
	@FindBy(id="user_login")
	WebElement name;	
	
	@FindBy(id="user_email")
	WebElement email;	
	
	@FindBy(id="user_password")
	WebElement password;	
	
	@FindBy(id="signup_button")
	WebElement signup;
	
	public SignUp(WebDriver driver) {
		super(driver);
		
	}

public void signUpDetails(String str1,String str2,String str3)
{
	name.sendKeys(str1);
	email.sendKeys(str2);
	password.sendKeys(str3);
	
	signup.click();



}



}
