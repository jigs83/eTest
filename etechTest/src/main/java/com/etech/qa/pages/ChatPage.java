package com.etech.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.etech.qa.base.TestBase;

public class ChatPage extends TestBase{
	
	//Page Factory - OR;
	
		@FindBy(xpath="//*[@id='imgH']/div/img")
		WebElement chatlink;
		
		@FindBy(xpath="//*[@id='3374']")
		WebElement name;
		
		@FindBy(xpath="//*[@id='3375']")
		WebElement email;
		
		@FindBy(xpath="//input[@id='minimizedButton']")
		WebElement submitbtn;
		
		@FindBy(xpath="//textarea[@id='msg']")
		WebElement msg;
		
		@FindBy(xpath="//label[@class='fix' and @for=3485]")
		WebElement nmlabel;
		
		@FindBy(xpath="//i[contains(text(),'close')]")
		WebElement closebtn;
		
		@FindBy(xpath="//input[@value='yes']")
		WebElement yesbtn;
		
		@FindBy(xpath="//img[@src='https://staging.enterice.com/chat//Images/ButtonImages/floating/bottom/blue/blue-Online.png']")
		WebElement chatpagelogo;
		
		@FindBy(xpath="//img[@src='https://staging.enterice.com/chat//Images/ButtonImages/floating/bottom/blue/blue-Offline.png']")
		WebElement chatpageofflinelogo;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		public ChatPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyChatPageLogo() throws InterruptedException {
			Thread.sleep(10000);
			return chatpagelogo.isDisplayed();
		}
		public ChatPage chatlogin(String nm, String eml) throws InterruptedException {
			Thread.sleep(10000);
			chatpagelogo.click();
			//Thread.sleep(10000);
			driver.switchTo().frame("chatpopup");
			name.clear();
			name.sendKeys(nm);
			Thread.sleep(2000);
			email.clear();
			email.sendKeys(eml);
			Thread.sleep(2000);
			//js.executeScript("arguments[0].scrollIntoView();", submitbtn);
			submitbtn.click();
			return new ChatPage();
		}
		
		public void chatTalk() {
			msg.sendKeys("Hi! How are you?");
			msg.sendKeys(Keys.ENTER);
		}

		public void chatSignOff() throws InterruptedException {
			Thread.sleep(15000);
			closebtn.click();
			yesbtn.click();
			Thread.sleep(5000);
			closebtn.click();
		}
}
