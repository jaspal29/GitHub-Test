package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class RepositoryToBeForked extends DriverInit{
	
	
    @FindBy(xpath="//*[@id=\"js-repo-pjax-container\"]/div[1]/div[1]/ul/li[3]/form/button")
	WebElement forkButton;
	
	public RepositoryToBeForked(WebDriver driver) {
		super(driver);
		
	}
	
 public void clickOnFork()
 {
	 
	 
	 
	 forkButton.click();
 }
	
	
}
