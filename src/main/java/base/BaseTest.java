package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;


public class BaseTest {
	
	
	
	
	 @BeforeMethod
	    public void setUp() {
	        String browser = ConfigReader.getProperty("browser");
	        boolean runOnCloud = Boolean.parseBoolean(ConfigReader.getProperty("runOnCloud"));
	        DriverFactory.initDriver(browser, runOnCloud);
	    }

	    @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
	
	
	
	
	
	

}
