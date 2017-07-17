package com.crowdFireHomePageMethods;

	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




	public class HomePage {
		public static WebDriver driver;
		public static Properties OR = new Properties();
		public static FileInputStream fis ;
					
		public HomePage(WebDriver driver) throws IOException {
			this.driver = driver;
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"/src/com/crowdFireHomePageMethods/ORHomePage.properties");	
				OR.load(fis);

				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void VerifyHomePage() throws Exception {
		//Fetching the header of app which is home pag or not
		WebElement results= driver.findElement(By.className(OR.getProperty("PageHeader")));
			if (results.getText().equals("My Wardrobe")){
				 System.out.println("Users reach at home Page: " +((WebElement) results).getText());  
				
			}else{
				 System.out.println("Unable get reach at home page");  
			}

	}
	//clicking on Favorite button from home for adding in Wishlist section and checked has added
	public void VerifyFavoriteButton(){
		driver.findElement(By.id(OR.getProperty("ClickONFavoriteButton"))).click();
		List<WebElement> results= driver.findElements(By.id(OR.getProperty("ClickONFavoriteIconHeader")));
			results.get(1).click();
			}
	//clicking on pluse + sign and adding products in Upper and lower section
	public void VerifyPluseButton(){
		WebDriverWait wait = new WebDriverWait(driver, 500);
		List<WebElement> results= driver.findElements(By.id(OR.getProperty("ClickONFavoriteIconHeader")));
			results.get(3).click();
			driver.findElement(By.id(OR.getProperty("ClickOnUpperCloths"))).click();
			WebElement feedsCatItems = driver.findElement(By.xpath(OR.getProperty("UpperImages")));
		    if(feedsCatItems.isDisplayed()){
		    	feedsCatItems.isSelected();
		    	results.get(3).click();
		         System.out.println("Upper Product displayed for addition");
		    }else{
		        System.out.println("Bug: Upper product not displayed for addition");
		    }
			driver.findElement(By.id(OR.getProperty("ClickOnLowerCloths"))).click();
			WebElement ImageFile= driver.findElement(By.xpath(OR.getProperty("LowerImages")));
		     if(ImageFile.isDisplayed()){
		    	 ImageFile.isSelected();

					results.get(3).click();

		         System.out.println("Lower product displayed for addition");
		    }
		    else
		    {
		        System.out.println("Bug: Lower product not displayed for addition");
		    }
		    
		    }
		}

	
	

	
	
		

			
	