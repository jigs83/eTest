package com.etech.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.etech.qa.base.TestBase;

public class HomePage extends TestBase{
	//Page Factory - OR;
	
		@FindBy(xpath="//a[@id='profiledd']")
		WebElement userNameLabel;
		
		@FindBy(xpath="//a[contains(text(),'My Chats')]")
		WebElement myChats;
		
		@FindBy(xpath="//a[@id='manage']")
		WebElement chatbtn;
		
		@FindBy(xpath="//a[contains(text(),'Logout')]")
		WebElement logoutdd;
		
		@FindBy(xpath="//a[@class='cursorCls tooltipped']/i[contains(text(),'close')]")
		WebElement closechatbtn;
		
		@FindBy(xpath="//*[@id='modal']//div[@class='input-field col s12'][2]//input[@type='submit' and @value='OK']")
		WebElement popokbtn;
		
		@FindBy(xpath="//input[@type='submit' and @value='Hang-Up']")
		WebElement hangupbtn;
		
		@FindBy(xpath="//input[@value='Select Disposition']")
		WebElement dispdd;
		
		@FindBy(xpath="//ul/li/span[text()='Tea Break']")
		WebElement tbrk;
		
		@FindBy(xpath="//ul/li/span[text()='Success']")
		WebElement successdd;
		
		@FindBy(xpath="//ul/li/span[text()='Failure']")
		WebElement faildd;
		
		@FindBy(xpath="//input[@value='Submit']")
		WebElement submitbtn;
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}
		
		public boolean verifyclsbtnEnable() {
			return closechatbtn.isDisplayed();			
		}
		
		public LogOutPage logout() {
			userNameLabel.click();
			logoutdd.click();
			
			return new LogOutPage();
			
		}
		public void chatDispose() throws InterruptedException {
			closechatbtn.click();
			Thread.sleep(2000);
			popokbtn.click();
			Thread.sleep(2000);
			dispdd.click();
			Thread.sleep(2000);
			faildd.click();
			Thread.sleep(2000);
			submitbtn.click();
		}
}
