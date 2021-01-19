package com.etech.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etech.qa.base.TestBase;
import com.etech.qa.pages.ChatPage;

public class ChatPageTest extends TestBase{

	public static ChatPage chatPage;
	
	public ChatPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		driver.get(prop.getProperty("url2"));
		chatPage = new ChatPage();
	}
	
	@Test (priority=1)
	public static void verifyChatPageLogoTest() throws InterruptedException {
		boolean chatPageLogo=chatPage.verifyChatPageLogo();
		Assert.assertTrue(chatPageLogo);
	}
	
	@Test (priority=2)
	public void verifyChatMsg() throws InterruptedException {
	    chatPage.chatlogin(prop.getProperty("name"), prop.getProperty("email"));
		chatPage.typeMsg();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
