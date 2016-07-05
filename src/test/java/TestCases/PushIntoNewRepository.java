package TestCases;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.HomePageAfterSignIn;
import Pages.NewRepositoryDetails;
import Pages.NewRepositoryStartPage;
import Pages.OpeningPage;
import Pages.RepositoryHomepage;
import Pages.SignInPage;
import junit.framework.Assert;



public class PushIntoNewRepository {
		
		OpeningPage page;
		WebDriver driver;
		SignInPage signInPage;
		String projectName="PROJECT-NAME13";//put project name here
		String description="hi113";//put description here

		@Test(dataProvider="data")
		public void test(String uid,String passwd) throws IOException, InterruptedException
		{
			
			
			
			driver=new FirefoxDriver();
			driver.get("https://github.com/");
			
			page=PageFactory.initElements(driver, OpeningPage.class);
			page.clickOnSignIn();

			signInPage=PageFactory.initElements(driver, SignInPage.class);		
			signInPage.EnterUsernameAndPassword(uid,passwd);
			signInPage.clickSignIn();
			
			HomePageAfterSignIn homePageAfterSignIn=PageFactory.initElements(driver, HomePageAfterSignIn.class);
		    homePageAfterSignIn.clickNewRepository();
		    
		    NewRepositoryDetails newRepo=PageFactory.initElements(driver, NewRepositoryDetails.class);
		       newRepo.EnterRepository(projectName,description);
			  newRepo.createRepository();
		      
		NewRepositoryStartPage newRepositoryStartPage=PageFactory.initElements(driver, NewRepositoryStartPage.class);
		String link=newRepositoryStartPage.getRemoteLinkToAdd();
		StringBuilder Link=new StringBuilder(link);
		String insertText=uid+":"+passwd+"@";
		  Link.insert(8,insertText);
		  System.out.println(Link.toString());
		  String url=new String(Link);
		  System.out.println(url);
		
	File file = new File("E:/newfolder");//change according to your directory E is the drive and new folder is the name
		file.mkdir();
		String result="E: \n";
		result+="cd newfolder \n";
		result+="git init \n";
		result+="cd .> readme.txt \n";
		result+="git add . \n";
		result+="git commit -m\"this is first commit\" \n";//this is message after -m
		result+="git remote add first "+url +"\n";
		result+="git push first master";
	
		File file1=new File("E:/push.bat");
		file1.createNewFile();
		FileOutputStream fos = new FileOutputStream(file1);
		fos.write(result.getBytes());
		fos.flush();
		fos.close();
	
		Runtime.getRuntime().exec("cmd /c start E:/push.bat");
		 
		Thread.sleep(5000);
		
	driver.navigate().refresh();
		 RepositoryHomepage repositoryHomepage=PageFactory.initElements(driver, RepositoryHomepage.class);
		 	  	
		Assert.assertEquals("this is first commit",repositoryHomepage.CommitData());
		
		}
		@DataProvider
		public static Object[][] data()
		{
			
			
			
			return new Object[][]{
					              {"jaspal29","JAS0000pal" } //put your username and password here
			                          
			                     };
		}
		


}
