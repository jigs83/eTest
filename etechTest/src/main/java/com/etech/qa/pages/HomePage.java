package com.etech.qa.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}
		
		public LogOutPage logout() {
			userNameLabel.click();
			logoutdd.click();
			return new LogOutPage();
			
		}
		public void chatDispose() {
			closechatbtn.click();
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
}
