package Pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.DriverInit;

public class SettingsPage extends DriverInit {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='options_bucket']/div[5]/div/button[2]")	
	WebElement Delete_Button;
	
	@FindBy(id="rename_field")
	WebElement DirectoryName;
	
	
	@FindBy(xpath="//*[@id=\"facebox\"]/div/div/form/p/input")
	WebElement PutName;
	
	@FindBy(xpath="//*[@id=\"facebox\"]/div/div/form/button")
	WebElement ConfirmDelete;
	
	@FindBy(id="repo_listing")
	WebElement web;
	
	public SettingsPage(WebDriver driver) {
		super(driver);
	
	}

	
	
	public boolean delete(String str) throws InterruptedException
	{ 
		System.out.println(DirectoryName.getAttribute("value").toString());		
		Delete_Button.click();
Thread.sleep(3000);		
		PutName.sendKeys(DirectoryName.getAttribute("value").toString());
         ConfirmDelete.click();
        
  	   String str1=web.getText();
  	 return(str1.contains(str));
         
        
         
         
         
		
		
		
	}


}
