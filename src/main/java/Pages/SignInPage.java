package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.DriverInit;

public class SignInPage extends DriverInit {

	@FindBy(how=How.NAME,using="login")
	WebElement username;

	@FindBy(how=How.ID,using="password")
	WebElement password;


	@FindBy(how=How.NAME,using="commit")
	WebElement signin ;



	public SignInPage(WebDriver driver) {
		super(driver);

	}



	public void EnterUsernameAndPassword(String uid,String pass)
	{
		username.sendKeys(uid);
		password.sendKeys(pass);

	}
	public void clickSignIn()
	{
		signin.click();




	}






}