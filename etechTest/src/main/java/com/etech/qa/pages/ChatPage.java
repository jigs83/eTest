package com.etech.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etech.qa.base.TestBase;

public class ChatPage extends TestBase{
	
	//Page Factory - OR;
	
		@FindBy(xpath="//*[@id='imgH']/div/img")
		WebElement chatlink;
		
		@FindBy(xpath="//input[@id='3374']")
		WebElement name;
		
		@FindBy(xpath="//input[@id='3375']")
		WebElement email;
		
		@FindBy(id="minimizedButton")
		WebElement submitbtn;
		
		@FindBy(xpath="//textarea[@id='msg']")
		WebElement msg;
		
		@FindBy(xpath="//i[contains(text(),'close')]")
		WebElement closebtn;
		
		@FindBy(xpath="//input[@value='yes']")
		WebElement yesbtn;
		
		@FindBy(xpath="//img[@src='https://staging.enterice.com/chat//Images/ButtonImages/floating/bottom/blue/blue-Online.png']")
		WebElement chatpagelogo;
		
		public ChatPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyChatPageLogo() throws InterruptedException {
			Thread.sleep(20000);
			return chatpagelogo.isDisplayed();
		}
		public ChatPage chatlogin(String nm, String eml) throws InterruptedException {
			Thread.sleep(20000);
			chatpagelogo.click();
			name.clear();
			name.sendKeys(nm);
			email.clear();
			email.sendKeys(eml);
			submitbtn.click();
			
			return new ChatPage();
		}

		public void typeMsg() {
			msg.sendKeys("Hi");
			msg.sendKeys("How are you!");
			msg.sendKeys("AUT");
			closebtn.click();
			yesbtn.click();
			closebtn.click();
		}
}
