package com.etech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.etech.qa.base.TestBase;
import com.etech.qa.pages.ChatPage;
import com.etech.qa.pages.HomePage;
import com.etech.qa.pages.LogOutPage;
import com.etech.qa.pages.LoginPage;

public class ChatPageTest extends TestBase{

	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ChatPage chatPage;
	public static LogOutPage logoutPage;
	
		
	public ChatPageTest()
	{
		super();
	}
	
/*	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		chatPage = new ChatPage();		

	}*/
	
	@Test
	public void verifyAgentWindowTest() throws InterruptedException {
		initialization(prop.getProperty("browser"));
		loginPage = new LoginPage();
		homePage = new HomePage();
		chatPage = new ChatPage();
		logoutPage = new LogOutPage();
		driver.get(prop.getProperty("url1"));
		homePage = loginPage.login(prop.getProperty("orgid"), prop.getProperty("username"), prop.getProperty("password"));
		verifyVisitorWindowTest();
		driver.navigate().refresh();
	    homePage.chatDispose();
	    Thread.sleep(2000);
	    logoutPage=homePage.logout();
		loginPage=logoutPage.signOut();
	    Thread.sleep(10000);
		String title=loginPage.ValidateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ICE | Login");
	}
	

	public void verifyVisitorWindowTest() throws InterruptedException {
		initialization(prop.getProperty("browser1"));
		chatPage = new ChatPage();	
		driver.get(prop.getProperty("url2"));
		chatPage=chatPage.chatlogin(prop.getProperty("name"), prop.getProperty("email"));
		chatPage.chatTalk();
		chatPage.chatSignOff();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
