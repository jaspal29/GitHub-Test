package Pages;
import org.openqa.selenium.WebDriver;


import utility.DriverInit;

public class NewRepositoryStartPage extends DriverInit {
	

	public NewRepositoryStartPage(WebDriver driver) {
		super(driver);

	}


	public String getRemoteLinkToAdd()
	{

		String str =driver.getCurrentUrl()+".git";
		return str;

	}








}



