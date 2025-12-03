package testcases;

import java.util.List;

import org.testng.annotations.Test;

import com.giantteddy.pages.HomePage;

import base.DriverFactory;

public class TC01_HomePageTest {
	
	@Test
	public void homePageValidationTest() {
	    HomePage home = new HomePage(DriverFactory.getDriver());

	    System.out.println("Title → " + home.getHomePageTitle());
	    System.out.println("Header → " + home.getHeaderText());
	    System.out.println("Banner URL → " + home.getMainBannerLink());

	    List<String> brokenLinks = home.getBrokenLinks();
	    System.out.println("Broken links count: " + brokenLinks.size());
	}


}
