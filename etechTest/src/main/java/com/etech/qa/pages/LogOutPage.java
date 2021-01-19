package com.etech.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etech.qa.base.TestBase;

public class LogOutPage extends TestBase {
	
	@FindBy(xpath="//input[@class='select-dropdown' and @value='Select logout reason']")
	WebElement logoutReason;
	
	@FindBy(xpath="//*[@id='dropdownChat']/li[6]/a")
	WebElement logout;
	
	@FindBy(xpath="//span[text()='End of The Day']")
	WebElement reason;
	
	@FindBy(xpath="//form[@class='col s12 ng-untouched ng-valid ng-dirty']//input[@value='OK']")
	WebElement okbtn;
	
	@FindBy(xpath="//*[@id=\"modal\"]/div/div/div/form/div/div[2]/input")
	WebElement closepopup;
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage signOut() throws InterruptedException {
		Thread.sleep(5000);
		logoutReason.sendKeys(Keys.DOWN,Keys.RETURN);
		//logoutReason.sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		okbtn.click();	
        return new LoginPage();
	}
	
	

}
