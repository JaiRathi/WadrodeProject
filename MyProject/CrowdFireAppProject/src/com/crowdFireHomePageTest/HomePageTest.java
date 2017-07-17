package com.crowdFireHomePageTest;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crowdFire.BaseUtil.Screenshot;
import com.crowdFire.BaseUtil.StartAppium;
import com.crowdFireHomePageMethods.HomePage;

public class HomePageTest extends StartAppium {

		
		@Test (priority=0)
		public void testSearch() throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 500);
			//Verifying the Header of App and taking the screenshot of this
			HomePage homePage = new HomePage(driver);
			homePage.VerifyHomePage();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//", "testSearch");	
			
}	   @Test (priority=1)
		//Verifying the Favorites products in section
		public void testFavoriteButton() throws IOException{
	   HomePage homePage = new HomePage(driver);
	   homePage.VerifyFavoriteButton();
		Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//", "testFavoriteButton");

}
        @Test (priority=2)
         //Clicked on Pluse button and Verifying the product in section
        public void testPluseButton() throws IOException{
        HomePage homePage = new HomePage(driver);
        homePage.VerifyPluseButton();
         Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//", "testPluseButton");


}
}
