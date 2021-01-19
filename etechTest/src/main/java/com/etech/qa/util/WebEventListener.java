package com.etech.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.etech.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigate to : '"+url+"'");
	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigate to : '"+url+"'");
	}
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the element : "+element.toString() 
		+ "before any changes made");
	}
	
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value cahnge to : "+element.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " +element.toString());
	}
	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " +element.toString());
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}
	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}
	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}
	
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " +error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by: " + by.toString());
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by: " + by.toString());
	}
	
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Just before beforeScript " + script);
	}
	
	public void afterScript(String script, WebDriver driver) {
		System.out.println("Inside the afterScript to, Script is " + script);
	}
	
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before alert accept : ");
	}
	
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After alert accept : ");
	}
	
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before alert dismiss : ");
	}
	
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After alert dismiss : ");
	}
	
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Page title before navigating refresh : "+driver.getTitle());
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page title after navigated refresh : "+driver.getTitle());
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Window name before swiching the window : "+windowName.toString());		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Window name after swiched the window : "+windowName.toString());
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Value of element before get text is : "+element.getText());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Value of element after get text is : "+text);
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before change the value of element : "+element.getText());
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After change the value of element : "+element.getText());
		
	}

}
