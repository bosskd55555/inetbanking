package com.Inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		

		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	
	{
	Assert.assertTrue(true);
	}
	
	else
	{
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		
	}
		
		
	}
	
	
	
	
	
	
}