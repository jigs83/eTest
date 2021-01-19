package com.etech.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etech.qa.pages.HomePage;
import com.etech.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR;
	
	@FindBy(name="OrgID")
	WebElement orgid;
	
	@FindBy(id="Username")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	//Initializing the Page Objects
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String ValidateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public HomePage login(String ogid, String un, String pwd)
		{
			orgid.sendKeys(ogid);
			username.sendKeys(un);
			password.sendKeys(pwd);
			submit.click();			
			return new HomePage();
		}

}
