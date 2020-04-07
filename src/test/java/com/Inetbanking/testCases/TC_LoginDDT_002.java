package com.Inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Inetbanking.pageObjects.LoginPage;
import com.Inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	
	}
	
	public boolean isAlertPresent()
	{
		
		try
		{
			
			driver.switchTo().alert();
			return true;
		}
		
		catch(NoAlertPresentException e)
		{
			return false;
			
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Inetbanking/testData/data.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			
			for(int j=0;j<colcount;j++)
			{
				
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
				}			
		}
		
		return logindata;
	}
	
}