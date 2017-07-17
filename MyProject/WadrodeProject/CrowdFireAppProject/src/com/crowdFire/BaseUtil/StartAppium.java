package com.crowdFire.BaseUtil;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

	public class StartAppium {
		
	static public WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Chrome");
		capabilities.setCapability("VERSION", "7.0.2"); 
		capabilities.setCapability("deviceName","SamsungEdge6");
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage", "com.crowdfire.aneeshabahukhandi.wadrobeassignment");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.crowdfire.aneeshabahukhandi.wardrobeassignment.activity.WardrobeHome");
	//Create RemoteWebDriver instance and connect to the Appium server
	 	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}


	@AfterSuite
	public void teardown(){
		//close the app
		driver.quit();
	}
	}


