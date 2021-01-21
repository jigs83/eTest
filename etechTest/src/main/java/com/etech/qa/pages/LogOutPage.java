package com.etech.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.etech.qa.base.TestBase;

public class LogOutPage extends TestBase {
	
	@FindBy(xpath="//*[@id='logout-reason']//input[@value='Select logout reason']")
	WebElement logoutReason;
	
	@FindBy(xpath="//ul/li/span[text()='Tea Break']")
	WebElement tbrk;
	
	@FindBy(xpath="//*[@id='dropdownChat']/li[6]/a")
	WebElement logout;
	
	@FindBy(xpath="//span[text()='End of The Day']")
	WebElement reason;
	
	@FindBy(xpath="//*[@id='logout-reason']/div/div/div/form/div/div[2]/input[1]")
	WebElement okbtn;
	
	@FindBy(xpath="//*[@id=modal]/div/div/div/form/div/div[2]/input")
	WebElement closepopup;
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage signOut() throws InterruptedException {
		Thread.sleep(5000);
	/*	Select reasonlist=new Select (logoutReason);
		System.out.println(reasonlist);
		reasonlist.selectByIndex(2);*/
		//System.out.println(logoutReason.getSize());
		logoutReason.click();
		Thread.sleep(2000);
		//logoutReason.sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		try {
			tbrk.click();
			okbtn.click();	
		}catch(Exception e){
			e.printStackTrace();
			Thread.sleep(3000);
			tbrk.click();
			okbtn.click();
		}
        return new LoginPage();
	}
	
	

}
