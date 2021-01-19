package com.etech.qa.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.etech.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUTS=40;
	public static long IMPLICIT_WAIT=30;
	
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		
		FileUtils.copyFile(src ,new File(currentDir + "/screenshots/"+ System.currentTimeMillis()+".jpg"));
	}
}
