package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testing.pages.Login;

public class TestLogin extends TestBase{

	Login login;
	private static final String TITLE = "actiTIME - Enter Time-Track";
	
	@Test
	public void userLogin() {
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setCapability("marionette", true);
		driver = new EdgeDriver(capabilities);
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
		login = new Login(driver);
		login.typeUsername("admin");
		login.typePassword("manager");
		login.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(titleIsEqualTo(TITLE));
		System.out.println("Current URL is:" + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("submit_tt"));
	}
	
	@Test
	public void testIncorrectUser() {
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setCapability("marionette", true);
		driver = new EdgeDriver(capabilities);
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
		login = new Login(driver);
		login.typeUsername("admin");
		login.typePassword("123");
		login.clickLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("errormsg")));
	}
	
	private ExpectedCondition<Boolean> titleIsEqualTo(final String searchString) {
	    return driver -> driver.getTitle().toLowerCase().equals(searchString.toLowerCase());
	}
}
