package testing;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import testing.pages.Login;

public class TestBase {
	
	protected WebDriver driver;
	public String baseUrl = "https://demo.actitime.com/login.do";
	public Properties properties;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\edge\\msedgedriver.exe");
		properties = new Properties();				
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
