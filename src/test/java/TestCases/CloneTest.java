package TestCases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CloneTest {
	String OSNAME=System.getProperty("os.name");
	File file=null;

	@Test(dataProvider="url")
	public void setup(String url,String FOLDERNAME) throws IOException
	{

		if(OSNAME.contains("linux")){
			file = new File(FOLDERNAME);
			file.mkdir();
			String result="cd "+FOLDERNAME+"\n";
			result=result+" "+url;
			File file1=new File(file+"/cl.sh");
			file1.createNewFile();
			FileOutputStream fos = new FileOutputStream(file1);
			fos.write(result.getBytes());
			fos.flush();
			fos.close();
			Process p2=Runtime.getRuntime().exec("chmod +rwx "+FOLDERNAME+"cl.sh");
			p2.destroy();
			Assert.assertEquals(true, file1.exists());
		}
		else 
		{

			file = new File(FOLDERNAME);
			file.mkdir();
			String result="E: \n";
			result+="cd "+FOLDERNAME+" \n";
			result=result+" git clone "+url;
			File file1=new File(file+"/cl.bat");
			file1.createNewFile();
			FileOutputStream fos = new FileOutputStream(file1);
			fos.write(result.getBytes());
			fos.flush();
			fos.close();
			Assert.assertEquals(true, file1.exists());

		}


	}
	@Test(dependsOnMethods="setup")
	public void Test() throws IOException, InterruptedException 
	{

		ProcessBuilder processBuilder ;
		Process p = null;
		if(OSNAME.contains("linux")){
			processBuilder = new ProcessBuilder("./cl.sh");
			processBuilder.directory(file);
			p=processBuilder.start();
		}  
		else{
			p=Runtime.getRuntime().exec("cmd /c start E:/FOLDERNAME/cl.bat");
		}

		Thread.sleep(10000);

		int x=p.waitFor();

		if(x==0){

			Assert.assertTrue(file.list().length==2);

		}


	}



	@DataProvider(name="url")
	public Object[][] URL()
	{
		return new Object [][]{{"https://github.com/jaspal29/Advance.git","E:\\FOLDERNAME"}};

	}


}
