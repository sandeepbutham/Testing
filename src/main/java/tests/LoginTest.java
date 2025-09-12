package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverFactory;
import org.openqa.selenium.By;


public class LoginTest extends BaseTest


{

	 @Test
	    public void testLogin() {
	        DriverFactory.getDriver().get("https://example.com");
	        DriverFactory.getDriver().findElement(By.id("username")).sendKeys("admin");
	        DriverFactory.getDriver().findElement(By.id("password")).sendKeys("admin123");
	        DriverFactory.getDriver().findElement(By.id("login")).click();
	    }
	
	
	
}
