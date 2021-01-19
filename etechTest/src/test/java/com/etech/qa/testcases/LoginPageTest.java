package com.etech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etech.qa.base.TestBase;
import com.etech.qa.pages.HomePage;
import com.etech.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		driver.get(prop.getProperty("url1"));
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "ICE | Login");
	}
	
	@Test(priority=2)
	public void loginTest() 
	{
		homepage = loginPage.login(prop.getProperty("orgid"),prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
