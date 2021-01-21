package com.etech.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.etech.qa.util.WebEventListener;
import com.etech.qa.util.TestUtil;

public class TestBase {
public static WebDriver driver;
public static WebDriverWait wait;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;

public TestBase(){
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\jigne\\git\\repository2\\etechTest\\src\\main\\java\\com\\etech\\qa\\config\\config.properties");
		prop.load(ip);		
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)	
	{
		e.printStackTrace();
	}
}
public static void initialization(String br) {
	//String browserName = prop.getProperty("browser");
	String browserName=br.toLowerCase();
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jigne\\Downloads\\chromedriver_win32-87\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("FF")) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jigne\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	
	new WebDriverWait(driver,TestUtil.EXPLICIT_WAIT);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
}

}
