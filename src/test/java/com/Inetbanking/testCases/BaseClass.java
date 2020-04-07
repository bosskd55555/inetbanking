package com.Inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Inetbanking.utilities.ReadConfig;

public class BaseClass
{
	
	ReadConfig readconfig=new ReadConfig();
	Logger log = Logger.getLogger("devpinoyLogger");
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		
		 
		
		
		if(br.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			
			//System.setProperty("webdriver.chrome.driver","F://sel//Selenium//drivers//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			log.info("browser opened");
			
		}
		
		if(br.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",readconfig.getChromepath());
			driver=new FirefoxDriver();
			
		}
		
		if(br.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver",readconfig.getChromepath());
			driver=new InternetExplorerDriver();
			
		}
		
		
		driver.get(baseURL);
		//driver.get("http://demo.guru99.com/v4/index.php");
		Thread.sleep(4000);
		
		
		
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException, InterruptedException
	{
		
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C://Selenium//HybridFramework//Inetbanking//Screenshots//"+ tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		log.info("screenshot taken");
		
		
		
	}

	
}