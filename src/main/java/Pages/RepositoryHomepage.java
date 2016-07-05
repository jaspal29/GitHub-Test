package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;


public class RepositoryHomepage extends DriverInit{
	
	@FindBy(xpath="//*[@id=\"js-repo-pjax-container\"]/div[1]/div[2]/nav/a[4]")
	WebElement settings;
	@FindBy(linkText="README.md")
	WebElement readme;
	@FindBy(className="message")
	List<WebElement> list;
	

	   
	public RepositoryHomepage(WebDriver driver)
	{
		
	super(driver);
		}

	public void clickOnSettings()
	{
		
		
		settings.click();
		
	}

	
	
	
	
	public void ClickOnREADME()
	{
		
		
		 readme.click();
		
		
		 }
	
	public String CommitData() throws IOException, InterruptedException
	{  
		System.out.println(list.get(2).getText().toString());
		 String commitMessage=list.get(2).getText();
		return commitMessage;
		
		
	}
	
	

}
