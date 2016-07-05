package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class NewRepositoryDetails extends DriverInit{


WebDriver driver;
	
	@FindBy(id="repository_name")
	private WebElement repositoryName;
	
	@FindBy(id="repository_description")
	private WebElement Descriptoin;
	
	@FindBy(xpath="//*[@id=\"new_repository\"]/div[4]/button")
	private WebElement create;
	
	public NewRepositoryDetails(WebDriver driver) {
		super(driver);
		
	}
	
	public void EnterRepository(String name,String description)
	 {
	 repositoryName.sendKeys(name);
	 Descriptoin.sendKeys(description);

	 }	
	
	 public void createRepository()
	 {
		create.click();
		 
		 
	 }


}
