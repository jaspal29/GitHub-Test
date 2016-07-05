package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class Profile extends DriverInit {

	@FindBy(linkText="Repositories")
    WebElement repository;	
	
	public Profile(WebDriver driver) {
		super(driver);
		
	}
	
	public void clickOnRepository()
	{
		
		
		repository.click();
	}
	

}
