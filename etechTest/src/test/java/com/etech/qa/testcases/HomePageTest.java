package com.etech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etech.qa.base.TestBase;
import com.etech.qa.pages.HomePage;
import com.etech.qa.pages.LogOutPage;
import com.etech.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	LogOutPage logoutPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test cases -- launch the browser and login
	//test -- execute test cases
	//after each test cases -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization(prop.getProperty("browser"));
		driver.get(prop.getProperty("url1"));
		loginPage= new LoginPage();
		homePage = new HomePage();
		homePage=loginPage.login(prop.getProperty("orgid"),prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "ICE Agent Console");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyLogoutTest() throws InterruptedException {
		logoutPage= new LogOutPage();
		logoutPage=homePage.logout();
		loginPage=logoutPage.signOut();
		//System.out.println(loginPage);
		Thread.sleep(10000);
		String title=loginPage.ValidateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ICE | Login");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

