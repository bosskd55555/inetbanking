package com.Inetbanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	

	@FindBy(name="password")
	WebElement txtPassword;


	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogout;
	
	
public void setUsername(String uname)
{
	
	txtUsername.sendKeys(uname);
}

public void setPassword(String pwd)
{
	
	txtPassword.sendKeys(pwd);
}

public void clickSubmit()
{
	
	btnLogin.click();;
}

public void clickLogout() throws InterruptedException {
	
	 JavascriptExecutor js = (JavascriptExecutor) ldriver;
	js.executeScript("arguments[0].scrollIntoView();", btnLogout);
	
	Thread.sleep(2000);
	btnLogout.click();
	
	
}


	
	
}