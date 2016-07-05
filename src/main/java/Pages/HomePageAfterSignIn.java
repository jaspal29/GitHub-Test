package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class HomePageAfterSignIn extends DriverInit {

	@FindBy(xpath="//*[@id=\"your_repos\"]/div[1]/a")
	WebElement newRepository;
	@FindBy(xpath="//*[@id=\"user-links\"]/li[3]/a/span")
	WebElement viewProfileButton;
	
	@FindBy(xpath="//*[@id=\"user-links\"]/li[3]/div/div/div[1]")
	WebElement signedInaAs;
	
	public HomePageAfterSignIn(WebDriver driver) {
		super(driver);

	}



	public void clickNewRepository(){

		newRepository.click();		


	}
	public void clickOnViewProfile(){

		viewProfileButton.click();		


	}
	
	
	public String signedInAS()
	{
		
		
		return signedInaAs.getText();
	}

}
